package com.example.orderattack.game.kiosk

import android.Manifest

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
import androidx.core.content.ContextCompat
import com.example.orderattack.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.snackbar.Snackbar
import java.io.IOException
import java.util.Locale



class KioskBonusActivity : AppCompatActivity(), OnMapReadyCallback, OnRequestPermissionsResultCallback {
    private var mMap: GoogleMap? = null
    private var currentMarker: Marker? = null
    var needRequest = false

    // 앱을 실행하기 위해 필요한 퍼미션 정의
    var REQUIRED_PERMISSION = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )
    var mCurrentLocation: Location? = null
    var currentPosition: LatLng? = null
    private var mFusedLocationClient: FusedLocationProviderClient? = null
    private var locationRequest: LocationRequest? = null // 주의
    private var location: Location? = null
    private val mLayout: View? = null // snackbar 사용하기 위함.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kiosk_bonus)
        setupLocationRequest()
        val builder = LocationSettingsRequest.Builder()
        locationRequest?.let { builder.addLocationRequest(it) }
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }
    private fun setupLocationRequest() {
        locationRequest = LocationRequest()
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
            .setInterval(UPDATE_INTERVAL_MS.toLong())
            .setFastestInterval(FASTEST_UPDATE_INTERVAL_MS.toLong())

    }

    override fun onMapReady(googleMap: GoogleMap) {
        Log.d(TAG, "onMapReady: 들어옴 ")
        mMap = googleMap

        // 지도의 초기위치 이동
        setDefaultLocation()

        // 런타임 퍼미션 처리
        // 1. 위치 퍼미션을 가지고 있는지 확인합니다.
        val hasFineLocationPermission =
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        val hasCoarseLocationPermission =
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED && hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED) {
            // 2. 이미 퍼미션을 가지고 있다면
            startLocationUpdates() // 3. 위치 업데이트 실행
        } else {
            // 2. 퍼미션 요청을 허용한 적 없다면 퍼미션 요청하기
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSION[0])) {
                // 요청 진행하기 전에 퍼미션이 왜필요한지 설명
                Snackbar.make(mLayout!!, "이 앱을 실행하려면 위치 접근 권한이 필요합니다.", Snackbar.LENGTH_INDEFINITE)
                    .setAction(
                        "확인"
                    ) { // 사용자에게 퍼미션 요청, 요청 결과는 onRequestPermisionResult에서 수신
                        ActivityCompat.requestPermissions(
                            this@KioskBonusActivity,
                            REQUIRED_PERMISSION,
                            PERMISSION_REQUEST_CODE
                        )
                    }.show()
            } else {
                // 사용자가 퍼미션 거부를 한적이 없는 경우 퍼미션 요청을 바로 함.
                // 요청 결과는 onRequestPermissionResult에서 수신된다.
                ActivityCompat.requestPermissions(
                    this,
                    REQUIRED_PERMISSION,
                    PERMISSION_REQUEST_CODE
                )
            }
        }
        mMap!!.uiSettings.isMyLocationButtonEnabled = true
        mMap!!.setOnMapClickListener {
            Log.d(
                TAG,
                "onMapClick: "
            )
        }
    }

    var locationCallback: LocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            super.onLocationResult(locationResult)
            val locationList = locationResult.locations
            if (locationList.size > 0) {
                location = locationList[locationList.size - 1]
                currentPosition = LatLng(location!!.latitude, location!!.longitude)
                val markerTitle = getCurrentAddress(currentPosition!!)
                val markerSnippet =
                    "위도 :" + location!!.latitude.toString() + "경도 :" + location!!.longitude.toString()

                // 현재 위치에 마커 생성하고 이동
                setCurrentLocation(location, markerTitle, markerSnippet)
                mCurrentLocation = location
            }
        }
    }

    private fun getCurrentAddress(currentPosition: LatLng): String {
        // 지오코더 gps를 주소로 변환
        val geocoder = Geocoder(this, Locale.getDefault())
        val addresses: List<Address>?
        addresses = try {
            geocoder.getFromLocation(
                currentPosition.latitude,
                currentPosition.longitude,
                1
            )
        } catch (ioException: IOException) {
            // 네트워크 문제
            Toast.makeText(this, "지오코더 서비스 사용불가", Toast.LENGTH_LONG).show()
            return "지오코더 서비스 사용 불가"
        } catch (illegalArgumentException: IllegalArgumentException) {
            Toast.makeText(this, "잘못된 GPS 좌표", Toast.LENGTH_LONG).show()
            return "잘못된 GPS 좌표"
        }
        return if (addresses == null || addresses.size == 0) {
            Toast.makeText(this, "주소 미발견", Toast.LENGTH_LONG).show()
            "주소 미발견"
        } else {
            val address = addresses[0]
            address.getAddressLine(0).toString()
        }
    }

    private fun setCurrentLocation(
        location: Location?,
        markerTitle: String,
        markerSnippet: String
    ) {
        if (currentMarker != null) {
            currentMarker!!.remove()
        }
        val currentLatLng = LatLng(location!!.latitude, location.longitude)
        val markerOptions = MarkerOptions()
        markerOptions.position(currentLatLng)
        markerOptions.title(markerTitle)
        markerOptions.snippet(markerSnippet)
        markerOptions.draggable(true)
        currentMarker = mMap!!.addMarker(markerOptions)
        val cameraUpdate = CameraUpdateFactory.newLatLng(currentLatLng)
        mMap!!.moveCamera(cameraUpdate)
    }

    private fun startLocationUpdates() {
        if (!checkLocationServicesStatus()) {
            showDiologForLocationServiceSetting()
        } else {
            val hasFineLocationPermission =
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            val hasCoarseLocationPermission =
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
            if (hasFineLocationPermission != PackageManager.PERMISSION_GRANTED || hasCoarseLocationPermission != PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "startLocationUpdates: 퍼미션 없음")
                return
            }
            mFusedLocationClient!!.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.myLooper()
            )
            if (checkPermission()) {
                mMap!!.isMyLocationEnabled = true
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
        if (checkPermission()) {
            mFusedLocationClient!!.requestLocationUpdates(locationRequest, locationCallback, null)
            if (mMap != null) {
                mMap!!.isMyLocationEnabled = true
            }
        }
    }

    override fun onStop() {
        super.onStop()
        if (mFusedLocationClient != null) {
            mFusedLocationClient!!.removeLocationUpdates(locationCallback)
        }
    }

    private fun checkPermission(): Boolean {
        val hasFineLocationPermission =
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        val hasCoarseLocationPermission =
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        return if (hasFineLocationPermission != PackageManager.PERMISSION_GRANTED || hasCoarseLocationPermission != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "startLocationUpdates: 퍼미션 없음")
            false
        } else {
            true
        }
    }

    private fun showDiologForLocationServiceSetting() {
        val builder = AlertDialog.Builder(this@KioskBonusActivity)
        builder.setTitle("위치 서비스 비활성화")
        builder.setMessage("앱을 사용하기 위해서는 위치 서비스가 필요합니다. 위치설정을 수정하시겠습니까?")
        builder.setCancelable(true)
        builder.setPositiveButton(
            "설정"
        ) { dialogInterface, i ->
            val callGPSSettingIntent =
                Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivityForResult(
                callGPSSettingIntent,
                GPS_ENABLE_REQUEST_CODE
            )
        }
        builder.setNegativeButton(
            "취소"
        ) { dialogInterface, i -> dialogInterface.cancel() }
        builder.create().show()
    }

    private fun checkLocationServicesStatus(): Boolean {
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    private fun setDefaultLocation() {

        // 기본 위치
        val DEFAULT_LOCATION = LatLng(37.56, 126.97)
        val markerTitle = "위치 정보 가져올 수 없음"
        val markerSnippet = "위치 퍼미션과 GPS 활성 여부를 확인하세요"
        if (currentMarker != null) {
            currentMarker!!.remove()
        }
        val markerOptions = MarkerOptions()
        markerOptions.position(DEFAULT_LOCATION)
        markerOptions.title(markerTitle)
        markerOptions.snippet(markerSnippet)
        markerOptions.draggable(true)
        currentMarker = mMap!!.addMarker(markerOptions)
        val cameraUpdate = CameraUpdateFactory.newLatLngZoom(DEFAULT_LOCATION, 15f)
        mMap!!.moveCamera(cameraUpdate)
    }

    companion object {
        private const val TAG = "googlemap"
        private const val GPS_ENABLE_REQUEST_CODE = 2001
        private const val UPDATE_INTERVAL_MS = 1000 // 1초
        private const val FASTEST_UPDATE_INTERVAL_MS = 500 // 0.5초

        // OnRequestPermissionsResultCallback에서 수신된 결과에서 ActivityCompat.OnRequestPermissionsResultCallback를 사용한 퍼미션 요청을 구별하기 위함
        private const val PERMISSION_REQUEST_CODE = 100
    }
}