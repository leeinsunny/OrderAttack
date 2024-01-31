package com.example.orderattack;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.orderattack.databinding.ActivitiyStage2introBindingImpl;
import com.example.orderattack.databinding.ActivityBusintroBindingImpl;
import com.example.orderattack.databinding.ActivityGameintroBindingImpl;
import com.example.orderattack.databinding.ActivityHealingMainBindingImpl;
import com.example.orderattack.databinding.ActivityIntroBindingImpl;
import com.example.orderattack.databinding.ActivityJoinBindingImpl;
import com.example.orderattack.databinding.ActivityKioskintroBindingImpl;
import com.example.orderattack.databinding.ActivityLoginBindingImpl;
import com.example.orderattack.databinding.ActivityMainBindingImpl;
import com.example.orderattack.databinding.ActivityMypageBindingImpl;
import com.example.orderattack.databinding.FragmentChattingBindingImpl;
import com.example.orderattack.databinding.FragmentMypageBindingImpl;
import com.example.orderattack.databinding.FragmentOurtownBindingImpl;
import com.example.orderattack.databinding.FragmentRankBindingImpl;
import com.example.orderattack.databinding.FragmentWalletBindingImpl;
import com.example.orderattack.databinding.PopupBusBonusBindingImpl;
import com.example.orderattack.databinding.PopupBusStep1BindingImpl;
import com.example.orderattack.databinding.PopupBusStep2BindingImpl;
import com.example.orderattack.databinding.PopupBusStep3BindingImpl;
import com.example.orderattack.databinding.PopupKioskBonusBindingImpl;
import com.example.orderattack.databinding.PopupKioskStep1BindingImpl;
import com.example.orderattack.databinding.PopupKioskStep2BindingImpl;
import com.example.orderattack.databinding.PopupKioskStep3BindingImpl;
import com.example.orderattack.databinding.PopupMovieBonusBindingImpl;
import com.example.orderattack.databinding.PopupMovieStep1BindingImpl;
import com.example.orderattack.databinding.PopupMovieStep2BindingImpl;
import com.example.orderattack.databinding.PopupMovieStep3BindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITIYSTAGE2INTRO = 1;

  private static final int LAYOUT_ACTIVITYBUSINTRO = 2;

  private static final int LAYOUT_ACTIVITYGAMEINTRO = 3;

  private static final int LAYOUT_ACTIVITYHEALINGMAIN = 4;

  private static final int LAYOUT_ACTIVITYINTRO = 5;

  private static final int LAYOUT_ACTIVITYJOIN = 6;

  private static final int LAYOUT_ACTIVITYKIOSKINTRO = 7;

  private static final int LAYOUT_ACTIVITYLOGIN = 8;

  private static final int LAYOUT_ACTIVITYMAIN = 9;

  private static final int LAYOUT_ACTIVITYMYPAGE = 10;

  private static final int LAYOUT_FRAGMENTCHATTING = 11;

  private static final int LAYOUT_FRAGMENTMYPAGE = 12;

  private static final int LAYOUT_FRAGMENTOURTOWN = 13;

  private static final int LAYOUT_FRAGMENTRANK = 14;

  private static final int LAYOUT_FRAGMENTWALLET = 15;

  private static final int LAYOUT_POPUPBUSBONUS = 16;

  private static final int LAYOUT_POPUPBUSSTEP1 = 17;

  private static final int LAYOUT_POPUPBUSSTEP2 = 18;

  private static final int LAYOUT_POPUPBUSSTEP3 = 19;

  private static final int LAYOUT_POPUPKIOSKBONUS = 20;

  private static final int LAYOUT_POPUPKIOSKSTEP1 = 21;

  private static final int LAYOUT_POPUPKIOSKSTEP2 = 22;

  private static final int LAYOUT_POPUPKIOSKSTEP3 = 23;

  private static final int LAYOUT_POPUPMOVIEBONUS = 24;

  private static final int LAYOUT_POPUPMOVIESTEP1 = 25;

  private static final int LAYOUT_POPUPMOVIESTEP2 = 26;

  private static final int LAYOUT_POPUPMOVIESTEP3 = 27;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(27);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activitiy_stage2intro, LAYOUT_ACTIVITIYSTAGE2INTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_busintro, LAYOUT_ACTIVITYBUSINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_gameintro, LAYOUT_ACTIVITYGAMEINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_healing_main, LAYOUT_ACTIVITYHEALINGMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_intro, LAYOUT_ACTIVITYINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_join, LAYOUT_ACTIVITYJOIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_kioskintro, LAYOUT_ACTIVITYKIOSKINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_mypage, LAYOUT_ACTIVITYMYPAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.fragment_chatting, LAYOUT_FRAGMENTCHATTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.fragment_mypage, LAYOUT_FRAGMENTMYPAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.fragment_ourtown, LAYOUT_FRAGMENTOURTOWN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.fragment_rank, LAYOUT_FRAGMENTRANK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.fragment_wallet, LAYOUT_FRAGMENTWALLET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.popup_bus_bonus, LAYOUT_POPUPBUSBONUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.popup_bus_step1, LAYOUT_POPUPBUSSTEP1);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.popup_bus_step2, LAYOUT_POPUPBUSSTEP2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.popup_bus_step3, LAYOUT_POPUPBUSSTEP3);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.popup_kiosk_bonus, LAYOUT_POPUPKIOSKBONUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.popup_kiosk_step1, LAYOUT_POPUPKIOSKSTEP1);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.popup_kiosk_step2, LAYOUT_POPUPKIOSKSTEP2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.popup_kiosk_step3, LAYOUT_POPUPKIOSKSTEP3);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.popup_movie_bonus, LAYOUT_POPUPMOVIEBONUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.popup_movie_step1, LAYOUT_POPUPMOVIESTEP1);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.popup_movie_step2, LAYOUT_POPUPMOVIESTEP2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.popup_movie_step3, LAYOUT_POPUPMOVIESTEP3);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITIYSTAGE2INTRO: {
          if ("layout/activitiy_stage2intro_0".equals(tag)) {
            return new ActivitiyStage2introBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activitiy_stage2intro is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYBUSINTRO: {
          if ("layout/activity_busintro_0".equals(tag)) {
            return new ActivityBusintroBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_busintro is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYGAMEINTRO: {
          if ("layout/activity_gameintro_0".equals(tag)) {
            return new ActivityGameintroBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_gameintro is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYHEALINGMAIN: {
          if ("layout/activity_healing_main_0".equals(tag)) {
            return new ActivityHealingMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_healing_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYINTRO: {
          if ("layout/activity_intro_0".equals(tag)) {
            return new ActivityIntroBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_intro is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYJOIN: {
          if ("layout/activity_join_0".equals(tag)) {
            return new ActivityJoinBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_join is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYKIOSKINTRO: {
          if ("layout/activity_kioskintro_0".equals(tag)) {
            return new ActivityKioskintroBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_kioskintro is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMYPAGE: {
          if ("layout/activity_mypage_0".equals(tag)) {
            return new ActivityMypageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_mypage is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCHATTING: {
          if ("layout/fragment_chatting_0".equals(tag)) {
            return new FragmentChattingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_chatting is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMYPAGE: {
          if ("layout/fragment_mypage_0".equals(tag)) {
            return new FragmentMypageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_mypage is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTOURTOWN: {
          if ("layout/fragment_ourtown_0".equals(tag)) {
            return new FragmentOurtownBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_ourtown is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTRANK: {
          if ("layout/fragment_rank_0".equals(tag)) {
            return new FragmentRankBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_rank is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWALLET: {
          if ("layout/fragment_wallet_0".equals(tag)) {
            return new FragmentWalletBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_wallet is invalid. Received: " + tag);
        }
        case  LAYOUT_POPUPBUSBONUS: {
          if ("layout/popup_bus_bonus_0".equals(tag)) {
            return new PopupBusBonusBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for popup_bus_bonus is invalid. Received: " + tag);
        }
        case  LAYOUT_POPUPBUSSTEP1: {
          if ("layout/popup_bus_step1_0".equals(tag)) {
            return new PopupBusStep1BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for popup_bus_step1 is invalid. Received: " + tag);
        }
        case  LAYOUT_POPUPBUSSTEP2: {
          if ("layout/popup_bus_step2_0".equals(tag)) {
            return new PopupBusStep2BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for popup_bus_step2 is invalid. Received: " + tag);
        }
        case  LAYOUT_POPUPBUSSTEP3: {
          if ("layout/popup_bus_step3_0".equals(tag)) {
            return new PopupBusStep3BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for popup_bus_step3 is invalid. Received: " + tag);
        }
        case  LAYOUT_POPUPKIOSKBONUS: {
          if ("layout/popup_kiosk_bonus_0".equals(tag)) {
            return new PopupKioskBonusBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for popup_kiosk_bonus is invalid. Received: " + tag);
        }
        case  LAYOUT_POPUPKIOSKSTEP1: {
          if ("layout/popup_kiosk_step1_0".equals(tag)) {
            return new PopupKioskStep1BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for popup_kiosk_step1 is invalid. Received: " + tag);
        }
        case  LAYOUT_POPUPKIOSKSTEP2: {
          if ("layout/popup_kiosk_step2_0".equals(tag)) {
            return new PopupKioskStep2BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for popup_kiosk_step2 is invalid. Received: " + tag);
        }
        case  LAYOUT_POPUPKIOSKSTEP3: {
          if ("layout/popup_kiosk_step3_0".equals(tag)) {
            return new PopupKioskStep3BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for popup_kiosk_step3 is invalid. Received: " + tag);
        }
        case  LAYOUT_POPUPMOVIEBONUS: {
          if ("layout/popup_movie_bonus_0".equals(tag)) {
            return new PopupMovieBonusBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for popup_movie_bonus is invalid. Received: " + tag);
        }
        case  LAYOUT_POPUPMOVIESTEP1: {
          if ("layout/popup_movie_step1_0".equals(tag)) {
            return new PopupMovieStep1BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for popup_movie_step1 is invalid. Received: " + tag);
        }
        case  LAYOUT_POPUPMOVIESTEP2: {
          if ("layout/popup_movie_step2_0".equals(tag)) {
            return new PopupMovieStep2BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for popup_movie_step2 is invalid. Received: " + tag);
        }
        case  LAYOUT_POPUPMOVIESTEP3: {
          if ("layout/popup_movie_step3_0".equals(tag)) {
            return new PopupMovieStep3BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for popup_movie_step3 is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(27);

    static {
      sKeys.put("layout/activitiy_stage2intro_0", com.example.orderattack.R.layout.activitiy_stage2intro);
      sKeys.put("layout/activity_busintro_0", com.example.orderattack.R.layout.activity_busintro);
      sKeys.put("layout/activity_gameintro_0", com.example.orderattack.R.layout.activity_gameintro);
      sKeys.put("layout/activity_healing_main_0", com.example.orderattack.R.layout.activity_healing_main);
      sKeys.put("layout/activity_intro_0", com.example.orderattack.R.layout.activity_intro);
      sKeys.put("layout/activity_join_0", com.example.orderattack.R.layout.activity_join);
      sKeys.put("layout/activity_kioskintro_0", com.example.orderattack.R.layout.activity_kioskintro);
      sKeys.put("layout/activity_login_0", com.example.orderattack.R.layout.activity_login);
      sKeys.put("layout/activity_main_0", com.example.orderattack.R.layout.activity_main);
      sKeys.put("layout/activity_mypage_0", com.example.orderattack.R.layout.activity_mypage);
      sKeys.put("layout/fragment_chatting_0", com.example.orderattack.R.layout.fragment_chatting);
      sKeys.put("layout/fragment_mypage_0", com.example.orderattack.R.layout.fragment_mypage);
      sKeys.put("layout/fragment_ourtown_0", com.example.orderattack.R.layout.fragment_ourtown);
      sKeys.put("layout/fragment_rank_0", com.example.orderattack.R.layout.fragment_rank);
      sKeys.put("layout/fragment_wallet_0", com.example.orderattack.R.layout.fragment_wallet);
      sKeys.put("layout/popup_bus_bonus_0", com.example.orderattack.R.layout.popup_bus_bonus);
      sKeys.put("layout/popup_bus_step1_0", com.example.orderattack.R.layout.popup_bus_step1);
      sKeys.put("layout/popup_bus_step2_0", com.example.orderattack.R.layout.popup_bus_step2);
      sKeys.put("layout/popup_bus_step3_0", com.example.orderattack.R.layout.popup_bus_step3);
      sKeys.put("layout/popup_kiosk_bonus_0", com.example.orderattack.R.layout.popup_kiosk_bonus);
      sKeys.put("layout/popup_kiosk_step1_0", com.example.orderattack.R.layout.popup_kiosk_step1);
      sKeys.put("layout/popup_kiosk_step2_0", com.example.orderattack.R.layout.popup_kiosk_step2);
      sKeys.put("layout/popup_kiosk_step3_0", com.example.orderattack.R.layout.popup_kiosk_step3);
      sKeys.put("layout/popup_movie_bonus_0", com.example.orderattack.R.layout.popup_movie_bonus);
      sKeys.put("layout/popup_movie_step1_0", com.example.orderattack.R.layout.popup_movie_step1);
      sKeys.put("layout/popup_movie_step2_0", com.example.orderattack.R.layout.popup_movie_step2);
      sKeys.put("layout/popup_movie_step3_0", com.example.orderattack.R.layout.popup_movie_step3);
    }
  }
}
