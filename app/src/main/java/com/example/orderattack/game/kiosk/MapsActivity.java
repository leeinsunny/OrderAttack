package com.example.orderattack.game.kiosk;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderattack.R;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.orderattack.databinding.ActivityMapsBinding;

import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.api.net.SearchByTextRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static String TAG = ".MapsActivity";


    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LatLng defaultLocation = new LatLng(37.630140656804954, 127.07703483221336);
    private static final int DEFAULT_ZOOM = 15;
    private PlacesClient placesClient;
    private List<Marker> mMarkerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Location
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        // Places Api 초기화
        Places.initialize(getApplicationContext(), getString(R.string.maps_api_key));
        placesClient = Places.createClient(this);

        // Maps 초기화
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng gongneung = new LatLng(37.630140656804954, 127.07703483221336);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gongneung,17));


        LatLng macdonald1 = new LatLng(37.62976545168152, 127.07627177238464);
        mMap.addMarker(new MarkerOptions().position(macdonald1).title("맥도날드 서울과학기술대점"));

        LatLng macdonald2 = new LatLng(37.650804, 127.0759853);
        mMap.addMarker(new MarkerOptions().position(macdonald2).title("맥도날드 중계점"));

        LatLng lotteria = new LatLng(37.62634747744992, 127.07434326410294);
        mMap.addMarker(new MarkerOptions().position(lotteria).title("롯데리아 공릉역점"));

        LatLng burgerking = new LatLng(37.62670436464418, 127.07222431898117);
        mMap.addMarker(new MarkerOptions().position(burgerking).title("롯데리아 공릉역점"));


        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        mMap.setOnMarkerClickListener(marker -> {
            String title = marker.getTitle();
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.popup_cleak_macdonalds, null);
            PopupWindow popupWindow = new PopupWindow(popupView,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT);

            TextView branchNameTextView = popupView.findViewById(R.id.tvMacdonaldTitle);
            branchNameTextView.setText(title);

            // 이미지 버튼을 찾고 클릭 리스너를 설정
            ImageButton btnBonusSuccess = popupView.findViewById(R.id.btnBonusSuccess);
            btnBonusSuccess.setOnClickListener(v -> {
                // KioskBonusAiActivity로 이동
                Intent intent = new Intent(this, KioskBonusAiActivity.class);
                startActivity(intent);

                // 팝업 창을 닫음
                popupWindow.dismiss();
            });

            popupWindow.setAnimationStyle(android.R.style.Animation_Dialog);

            // 팝업창 위치 설정 변경: 이전에는 팝업창이 항상 화면 중앙에 나타났지만,
            // 버튼 클릭 리스너 내에서 popupWindow를 참조할 수 있도록 변수 선언 위치를 조정
            popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

            return true;
        });

        getLocationPermission();

    }


    private void getLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getDeviceLocationAndNearbyPlaces();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if (requestCode == PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getDeviceLocationAndNearbyPlaces();
            }
        } else {

            Toast.makeText(this, "Location permission denied. Location-related features are disabled.", Toast.LENGTH_SHORT).show();
        }
    }


    @SuppressLint("MissingPermission")
    private void getDeviceLocationAndNearbyPlaces() {
        Log.d(TAG, "getDeviceLocationAndNearbyPlaces: ");
        Task<Location> locationResult = fusedLocationProviderClient.getLastLocation();
        locationResult.addOnSuccessListener(location -> {
            if (location != null) {
                LatLng temp = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(temp, 17));
                findWithTextSearch(location);
            }
            findNearbyMcDonalds();
        }).addOnFailureListener(e -> {
            e.printStackTrace();
            Log.d(TAG, "getDeviceLocationAndNearbyPlaces: " + e.getMessage());
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, DEFAULT_ZOOM));
        });
    }


    @SuppressLint("MissingPermission")
    private void findNearbyMcDonalds() {
        Log.d(TAG, "findNearbyMcDonalds: ");
        List<Place.Field> placeFields = Arrays.asList(Place.Field.NAME, Place.Field.LAT_LNG);
        FindCurrentPlaceRequest request = FindCurrentPlaceRequest.newInstance(placeFields);

        Task<FindCurrentPlaceResponse> placeResponse = placesClient.findCurrentPlace(request);
        placeResponse.addOnSuccessListener(findCurrentPlaceResponse -> {

            if (findCurrentPlaceResponse == null) return;

            mMarkerList = new ArrayList<>();

            for (PlaceLikelihood placeLikelihood : findCurrentPlaceResponse.getPlaceLikelihoods()) {
                Place place = placeLikelihood.getPlace();
                Log.d(TAG, "findNearbyMcDonalds: " + place.getName());

                for (String target : new String[]{"McDonald", "맥도날드"}) {
                    if (place.getName().contains(target)) {
                        Marker marker = mMap.addMarker(new MarkerOptions()
                                .position(place.getLatLng())
                                .title(place.getName()));

                        mMarkerList.add(marker);
                    }
                }

            }
        }).addOnFailureListener(e -> {
            e.printStackTrace();
            Log.d(TAG, "getDeviceLocationAndNearbyPlaces: " + e.getMessage());
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, DEFAULT_ZOOM));
        });
    }


    private void findWithTextSearch(Location location) {
        List<Place.Field> placeFields = Arrays.asList(Place.Field.NAME, Place.Field.LAT_LNG);
        // 0.01 = 1km
        double region = 0.5;
        LatLng southWest = new LatLng(location.getLatitude() - region, location.getLongitude() - region); // 왼쪽 아래
        LatLng northEast = new LatLng(location.getLatitude() + region, location.getLongitude() + region); // 오른쪽 위

        final SearchByTextRequest searchByTextRequest = SearchByTextRequest
                .builder("맥도날드", placeFields)
                .setMaxResultCount(10)
                .setLocationRestriction(RectangularBounds.newInstance(southWest, northEast))
                .build();

        placesClient.searchByText(searchByTextRequest).addOnSuccessListener(response -> {
            List<Place> places = response.getPlaces();
            mMarkerList = new ArrayList<>();
            for (Place place : places) {
                Log.d(TAG, "findWithTextSearch: " + place.getName() + place.getLatLng());
                Marker marker = mMap.addMarker(new MarkerOptions()
                        .position(place.getLatLng())
                        .title(place.getName()));

                // 여기 태그로 아무 객체나 넣을 수 있음
                marker.setTag(place);

                mMarkerList.add(marker);
            }
        });
    }


}

