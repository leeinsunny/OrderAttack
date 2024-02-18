package com.example.orderattack;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.orderattack.databinding.ActivitiyStage2introBindingImpl;
import com.example.orderattack.databinding.ActivityBeforepayOrdercheckBindingImpl;
import com.example.orderattack.databinding.ActivityBurgerAllBindingImpl;
import com.example.orderattack.databinding.ActivityBurgerBeefBindingImpl;
import com.example.orderattack.databinding.ActivityBurgerBulBindingImpl;
import com.example.orderattack.databinding.ActivityBurgerChickenBindingImpl;
import com.example.orderattack.databinding.ActivityBurgerSeafoodBindingImpl;
import com.example.orderattack.databinding.ActivityBusintroBindingImpl;
import com.example.orderattack.databinding.ActivityCardpayBindingImpl;
import com.example.orderattack.databinding.ActivityChooseplaceBindingImpl;
import com.example.orderattack.databinding.ActivityFinalCheckInburgerBindingImpl;
import com.example.orderattack.databinding.ActivityGameintroBindingImpl;
import com.example.orderattack.databinding.ActivityHealingMainBindingImpl;
import com.example.orderattack.databinding.ActivityHomeBeforeorderBindingImpl;
import com.example.orderattack.databinding.ActivityIntroBindingImpl;
import com.example.orderattack.databinding.ActivityJoinBindingImpl;
import com.example.orderattack.databinding.ActivityKioskStep1BindingImpl;
import com.example.orderattack.databinding.ActivityKioskintroBindingImpl;
import com.example.orderattack.databinding.ActivityLoginBindingImpl;
import com.example.orderattack.databinding.ActivityMainBindingImpl;
import com.example.orderattack.databinding.ActivityMpornotAfterCokeBindingImpl;
import com.example.orderattack.databinding.ActivityMpornotAfterFriBindingImpl;
import com.example.orderattack.databinding.ActivityMpornotAfterHamBindingImpl;
import com.example.orderattack.databinding.ActivityMpornotBindingImpl;
import com.example.orderattack.databinding.ActivityMpornotCokeAnswerBindingImpl;
import com.example.orderattack.databinding.ActivityMpornotCokeBindingImpl;
import com.example.orderattack.databinding.ActivityMpornotFriAnswer1BindingImpl;
import com.example.orderattack.databinding.ActivityMpornotFriBindingImpl;
import com.example.orderattack.databinding.ActivityMpornotHamAnswer1BindingImpl;
import com.example.orderattack.databinding.ActivityMpornotHamAnswer2BindingImpl;
import com.example.orderattack.databinding.ActivityMpornotHamBindingImpl;
import com.example.orderattack.databinding.ActivityMypageBindingImpl;
import com.example.orderattack.databinding.ActivityOrderfinishBindingImpl;
import com.example.orderattack.databinding.ActivityPaywaychooseBindingImpl;
import com.example.orderattack.databinding.ActivityRealwalletgetBindingImpl;
import com.example.orderattack.databinding.ActivitySetornotBindingImpl;
import com.example.orderattack.databinding.ActivitySetsideBindingImpl;
import com.example.orderattack.databinding.ActivitySetsideDrinkBindingImpl;
import com.example.orderattack.databinding.ActivitySetsizeBindingImpl;
import com.example.orderattack.databinding.ActivitySuccessOrderBindingImpl;
import com.example.orderattack.databinding.ActivitySuccesswindowBindingImpl;
import com.example.orderattack.databinding.ActivityTogetherBindingImpl;
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
import com.example.orderattack.databinding.PopupNoticeSuccessLv1BindingImpl;
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

  private static final int LAYOUT_ACTIVITYBEFOREPAYORDERCHECK = 2;

  private static final int LAYOUT_ACTIVITYBURGERALL = 3;

  private static final int LAYOUT_ACTIVITYBURGERBEEF = 4;

  private static final int LAYOUT_ACTIVITYBURGERBUL = 5;

  private static final int LAYOUT_ACTIVITYBURGERCHICKEN = 6;

  private static final int LAYOUT_ACTIVITYBURGERSEAFOOD = 7;

  private static final int LAYOUT_ACTIVITYBUSINTRO = 8;

  private static final int LAYOUT_ACTIVITYCARDPAY = 9;

  private static final int LAYOUT_ACTIVITYCHOOSEPLACE = 10;

  private static final int LAYOUT_ACTIVITYFINALCHECKINBURGER = 11;

  private static final int LAYOUT_ACTIVITYGAMEINTRO = 12;

  private static final int LAYOUT_ACTIVITYHEALINGMAIN = 13;

  private static final int LAYOUT_ACTIVITYHOMEBEFOREORDER = 14;

  private static final int LAYOUT_ACTIVITYINTRO = 15;

  private static final int LAYOUT_ACTIVITYJOIN = 16;

  private static final int LAYOUT_ACTIVITYKIOSKSTEP1 = 17;

  private static final int LAYOUT_ACTIVITYKIOSKINTRO = 18;

  private static final int LAYOUT_ACTIVITYLOGIN = 19;

  private static final int LAYOUT_ACTIVITYMAIN = 20;

  private static final int LAYOUT_ACTIVITYMPORNOT = 21;

  private static final int LAYOUT_ACTIVITYMPORNOTAFTERCOKE = 22;

  private static final int LAYOUT_ACTIVITYMPORNOTAFTERFRI = 23;

  private static final int LAYOUT_ACTIVITYMPORNOTAFTERHAM = 24;

  private static final int LAYOUT_ACTIVITYMPORNOTCOKE = 25;

  private static final int LAYOUT_ACTIVITYMPORNOTCOKEANSWER = 26;

  private static final int LAYOUT_ACTIVITYMPORNOTFRI = 27;

  private static final int LAYOUT_ACTIVITYMPORNOTFRIANSWER1 = 28;

  private static final int LAYOUT_ACTIVITYMPORNOTHAM = 29;

  private static final int LAYOUT_ACTIVITYMPORNOTHAMANSWER1 = 30;

  private static final int LAYOUT_ACTIVITYMPORNOTHAMANSWER2 = 31;

  private static final int LAYOUT_ACTIVITYMYPAGE = 32;

  private static final int LAYOUT_ACTIVITYORDERFINISH = 33;

  private static final int LAYOUT_ACTIVITYPAYWAYCHOOSE = 34;

  private static final int LAYOUT_ACTIVITYREALWALLETGET = 35;

  private static final int LAYOUT_ACTIVITYSETORNOT = 36;

  private static final int LAYOUT_ACTIVITYSETSIDE = 37;

  private static final int LAYOUT_ACTIVITYSETSIDEDRINK = 38;

  private static final int LAYOUT_ACTIVITYSETSIZE = 39;

  private static final int LAYOUT_ACTIVITYSUCCESSORDER = 40;

  private static final int LAYOUT_ACTIVITYSUCCESSWINDOW = 41;

  private static final int LAYOUT_ACTIVITYTOGETHER = 42;

  private static final int LAYOUT_FRAGMENTCHATTING = 43;

  private static final int LAYOUT_FRAGMENTMYPAGE = 44;

  private static final int LAYOUT_FRAGMENTOURTOWN = 45;

  private static final int LAYOUT_FRAGMENTRANK = 46;

  private static final int LAYOUT_FRAGMENTWALLET = 47;

  private static final int LAYOUT_POPUPBUSBONUS = 48;

  private static final int LAYOUT_POPUPBUSSTEP1 = 49;

  private static final int LAYOUT_POPUPBUSSTEP2 = 50;

  private static final int LAYOUT_POPUPBUSSTEP3 = 51;

  private static final int LAYOUT_POPUPKIOSKBONUS = 52;

  private static final int LAYOUT_POPUPKIOSKSTEP1 = 53;

  private static final int LAYOUT_POPUPKIOSKSTEP2 = 54;

  private static final int LAYOUT_POPUPKIOSKSTEP3 = 55;

  private static final int LAYOUT_POPUPMOVIEBONUS = 56;

  private static final int LAYOUT_POPUPMOVIESTEP1 = 57;

  private static final int LAYOUT_POPUPMOVIESTEP2 = 58;

  private static final int LAYOUT_POPUPMOVIESTEP3 = 59;

  private static final int LAYOUT_POPUPNOTICESUCCESSLV1 = 60;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(60);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activitiy_stage2intro, LAYOUT_ACTIVITIYSTAGE2INTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_beforepay_ordercheck, LAYOUT_ACTIVITYBEFOREPAYORDERCHECK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_burger_all, LAYOUT_ACTIVITYBURGERALL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_burger_beef, LAYOUT_ACTIVITYBURGERBEEF);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_burger_bul, LAYOUT_ACTIVITYBURGERBUL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_burger_chicken, LAYOUT_ACTIVITYBURGERCHICKEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_burger_seafood, LAYOUT_ACTIVITYBURGERSEAFOOD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_busintro, LAYOUT_ACTIVITYBUSINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_cardpay, LAYOUT_ACTIVITYCARDPAY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_chooseplace, LAYOUT_ACTIVITYCHOOSEPLACE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_final_check_inburger, LAYOUT_ACTIVITYFINALCHECKINBURGER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_gameintro, LAYOUT_ACTIVITYGAMEINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_healing_main, LAYOUT_ACTIVITYHEALINGMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_home_beforeorder, LAYOUT_ACTIVITYHOMEBEFOREORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_intro, LAYOUT_ACTIVITYINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_join, LAYOUT_ACTIVITYJOIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_kiosk_step1, LAYOUT_ACTIVITYKIOSKSTEP1);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_kioskintro, LAYOUT_ACTIVITYKIOSKINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_mpornot, LAYOUT_ACTIVITYMPORNOT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_mpornot_after_coke, LAYOUT_ACTIVITYMPORNOTAFTERCOKE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_mpornot_after_fri, LAYOUT_ACTIVITYMPORNOTAFTERFRI);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_mpornot_after_ham, LAYOUT_ACTIVITYMPORNOTAFTERHAM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_mpornot_coke, LAYOUT_ACTIVITYMPORNOTCOKE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_mpornot_coke_answer, LAYOUT_ACTIVITYMPORNOTCOKEANSWER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_mpornot_fri, LAYOUT_ACTIVITYMPORNOTFRI);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_mpornot_fri_answer1, LAYOUT_ACTIVITYMPORNOTFRIANSWER1);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_mpornot_ham, LAYOUT_ACTIVITYMPORNOTHAM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_mpornot_ham_answer1, LAYOUT_ACTIVITYMPORNOTHAMANSWER1);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_mpornot_ham_answer2, LAYOUT_ACTIVITYMPORNOTHAMANSWER2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_mypage, LAYOUT_ACTIVITYMYPAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_orderfinish, LAYOUT_ACTIVITYORDERFINISH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_paywaychoose, LAYOUT_ACTIVITYPAYWAYCHOOSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_realwalletget, LAYOUT_ACTIVITYREALWALLETGET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_setornot, LAYOUT_ACTIVITYSETORNOT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_setside, LAYOUT_ACTIVITYSETSIDE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_setside_drink, LAYOUT_ACTIVITYSETSIDEDRINK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_setsize, LAYOUT_ACTIVITYSETSIZE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_success_order, LAYOUT_ACTIVITYSUCCESSORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_successwindow, LAYOUT_ACTIVITYSUCCESSWINDOW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_together, LAYOUT_ACTIVITYTOGETHER);
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
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.popup_notice_success_lv1, LAYOUT_POPUPNOTICESUCCESSLV1);
  }

  private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITIYSTAGE2INTRO: {
        if ("layout/activitiy_stage2intro_0".equals(tag)) {
          return new ActivitiyStage2introBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activitiy_stage2intro is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYBEFOREPAYORDERCHECK: {
        if ("layout/activity_beforepay_ordercheck_0".equals(tag)) {
          return new ActivityBeforepayOrdercheckBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_beforepay_ordercheck is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYBURGERALL: {
        if ("layout/activity_burger_all_0".equals(tag)) {
          return new ActivityBurgerAllBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_burger_all is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYBURGERBEEF: {
        if ("layout/activity_burger_beef_0".equals(tag)) {
          return new ActivityBurgerBeefBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_burger_beef is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYBURGERBUL: {
        if ("layout/activity_burger_bul_0".equals(tag)) {
          return new ActivityBurgerBulBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_burger_bul is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYBURGERCHICKEN: {
        if ("layout/activity_burger_chicken_0".equals(tag)) {
          return new ActivityBurgerChickenBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_burger_chicken is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYBURGERSEAFOOD: {
        if ("layout/activity_burger_seafood_0".equals(tag)) {
          return new ActivityBurgerSeafoodBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_burger_seafood is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYBUSINTRO: {
        if ("layout/activity_busintro_0".equals(tag)) {
          return new ActivityBusintroBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_busintro is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCARDPAY: {
        if ("layout/activity_cardpay_0".equals(tag)) {
          return new ActivityCardpayBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_cardpay is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCHOOSEPLACE: {
        if ("layout/activity_chooseplace_0".equals(tag)) {
          return new ActivityChooseplaceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_chooseplace is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFINALCHECKINBURGER: {
        if ("layout/activity_final_check_inburger_0".equals(tag)) {
          return new ActivityFinalCheckInburgerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_final_check_inburger is invalid. Received: " + tag);
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
      case  LAYOUT_ACTIVITYHOMEBEFOREORDER: {
        if ("layout/activity_home_beforeorder_0".equals(tag)) {
          return new ActivityHomeBeforeorderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_home_beforeorder is invalid. Received: " + tag);
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
      case  LAYOUT_ACTIVITYKIOSKSTEP1: {
        if ("layout/activity_kiosk_step1_0".equals(tag)) {
          return new ActivityKioskStep1BindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_kiosk_step1 is invalid. Received: " + tag);
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
      case  LAYOUT_ACTIVITYMPORNOT: {
        if ("layout/activity_mpornot_0".equals(tag)) {
          return new ActivityMpornotBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_mpornot is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMPORNOTAFTERCOKE: {
        if ("layout/activity_mpornot_after_coke_0".equals(tag)) {
          return new ActivityMpornotAfterCokeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_mpornot_after_coke is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMPORNOTAFTERFRI: {
        if ("layout/activity_mpornot_after_fri_0".equals(tag)) {
          return new ActivityMpornotAfterFriBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_mpornot_after_fri is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMPORNOTAFTERHAM: {
        if ("layout/activity_mpornot_after_ham_0".equals(tag)) {
          return new ActivityMpornotAfterHamBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_mpornot_after_ham is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMPORNOTCOKE: {
        if ("layout/activity_mpornot_coke_0".equals(tag)) {
          return new ActivityMpornotCokeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_mpornot_coke is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMPORNOTCOKEANSWER: {
        if ("layout/activity_mpornot_coke_answer_0".equals(tag)) {
          return new ActivityMpornotCokeAnswerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_mpornot_coke_answer is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMPORNOTFRI: {
        if ("layout/activity_mpornot_fri_0".equals(tag)) {
          return new ActivityMpornotFriBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_mpornot_fri is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMPORNOTFRIANSWER1: {
        if ("layout/activity_mpornot_fri_answer1_0".equals(tag)) {
          return new ActivityMpornotFriAnswer1BindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_mpornot_fri_answer1 is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMPORNOTHAM: {
        if ("layout/activity_mpornot_ham_0".equals(tag)) {
          return new ActivityMpornotHamBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_mpornot_ham is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMPORNOTHAMANSWER1: {
        if ("layout/activity_mpornot_ham_answer1_0".equals(tag)) {
          return new ActivityMpornotHamAnswer1BindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_mpornot_ham_answer1 is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMPORNOTHAMANSWER2: {
        if ("layout/activity_mpornot_ham_answer2_0".equals(tag)) {
          return new ActivityMpornotHamAnswer2BindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_mpornot_ham_answer2 is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYPAGE: {
        if ("layout/activity_mypage_0".equals(tag)) {
          return new ActivityMypageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_mypage is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYORDERFINISH: {
        if ("layout/activity_orderfinish_0".equals(tag)) {
          return new ActivityOrderfinishBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_orderfinish is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPAYWAYCHOOSE: {
        if ("layout/activity_paywaychoose_0".equals(tag)) {
          return new ActivityPaywaychooseBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_paywaychoose is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYREALWALLETGET: {
        if ("layout/activity_realwalletget_0".equals(tag)) {
          return new ActivityRealwalletgetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_realwalletget is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSETORNOT: {
        if ("layout/activity_setornot_0".equals(tag)) {
          return new ActivitySetornotBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_setornot is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSETSIDE: {
        if ("layout/activity_setside_0".equals(tag)) {
          return new ActivitySetsideBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_setside is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSETSIDEDRINK: {
        if ("layout/activity_setside_drink_0".equals(tag)) {
          return new ActivitySetsideDrinkBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_setside_drink is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSETSIZE: {
        if ("layout/activity_setsize_0".equals(tag)) {
          return new ActivitySetsizeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_setsize is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSUCCESSORDER: {
        if ("layout/activity_success_order_0".equals(tag)) {
          return new ActivitySuccessOrderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_success_order is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSUCCESSWINDOW: {
        if ("layout/activity_successwindow_0".equals(tag)) {
          return new ActivitySuccesswindowBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_successwindow is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYTOGETHER: {
        if ("layout/activity_together_0".equals(tag)) {
          return new ActivityTogetherBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_together is invalid. Received: " + tag);
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
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
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
      case  LAYOUT_POPUPNOTICESUCCESSLV1: {
        if ("layout/popup_notice_success_lv1_0".equals(tag)) {
          return new PopupNoticeSuccessLv1BindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for popup_notice_success_lv1 is invalid. Received: " + tag);
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      // find which method will have it. -1 is necessary becausefirst id starts with 1;
      int methodIndex = (localizedLayoutId - 1) / 50;
      switch(methodIndex) {
        case 0: {
          return internalGetViewDataBinding0(component, view, localizedLayoutId, tag);
        }
        case 1: {
          return internalGetViewDataBinding1(component, view, localizedLayoutId, tag);
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
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(60);

    static {
      sKeys.put("layout/activitiy_stage2intro_0", com.example.orderattack.R.layout.activitiy_stage2intro);
      sKeys.put("layout/activity_beforepay_ordercheck_0", com.example.orderattack.R.layout.activity_beforepay_ordercheck);
      sKeys.put("layout/activity_burger_all_0", com.example.orderattack.R.layout.activity_burger_all);
      sKeys.put("layout/activity_burger_beef_0", com.example.orderattack.R.layout.activity_burger_beef);
      sKeys.put("layout/activity_burger_bul_0", com.example.orderattack.R.layout.activity_burger_bul);
      sKeys.put("layout/activity_burger_chicken_0", com.example.orderattack.R.layout.activity_burger_chicken);
      sKeys.put("layout/activity_burger_seafood_0", com.example.orderattack.R.layout.activity_burger_seafood);
      sKeys.put("layout/activity_busintro_0", com.example.orderattack.R.layout.activity_busintro);
      sKeys.put("layout/activity_cardpay_0", com.example.orderattack.R.layout.activity_cardpay);
      sKeys.put("layout/activity_chooseplace_0", com.example.orderattack.R.layout.activity_chooseplace);
      sKeys.put("layout/activity_final_check_inburger_0", com.example.orderattack.R.layout.activity_final_check_inburger);
      sKeys.put("layout/activity_gameintro_0", com.example.orderattack.R.layout.activity_gameintro);
      sKeys.put("layout/activity_healing_main_0", com.example.orderattack.R.layout.activity_healing_main);
      sKeys.put("layout/activity_home_beforeorder_0", com.example.orderattack.R.layout.activity_home_beforeorder);
      sKeys.put("layout/activity_intro_0", com.example.orderattack.R.layout.activity_intro);
      sKeys.put("layout/activity_join_0", com.example.orderattack.R.layout.activity_join);
      sKeys.put("layout/activity_kiosk_step1_0", com.example.orderattack.R.layout.activity_kiosk_step1);
      sKeys.put("layout/activity_kioskintro_0", com.example.orderattack.R.layout.activity_kioskintro);
      sKeys.put("layout/activity_login_0", com.example.orderattack.R.layout.activity_login);
      sKeys.put("layout/activity_main_0", com.example.orderattack.R.layout.activity_main);
      sKeys.put("layout/activity_mpornot_0", com.example.orderattack.R.layout.activity_mpornot);
      sKeys.put("layout/activity_mpornot_after_coke_0", com.example.orderattack.R.layout.activity_mpornot_after_coke);
      sKeys.put("layout/activity_mpornot_after_fri_0", com.example.orderattack.R.layout.activity_mpornot_after_fri);
      sKeys.put("layout/activity_mpornot_after_ham_0", com.example.orderattack.R.layout.activity_mpornot_after_ham);
      sKeys.put("layout/activity_mpornot_coke_0", com.example.orderattack.R.layout.activity_mpornot_coke);
      sKeys.put("layout/activity_mpornot_coke_answer_0", com.example.orderattack.R.layout.activity_mpornot_coke_answer);
      sKeys.put("layout/activity_mpornot_fri_0", com.example.orderattack.R.layout.activity_mpornot_fri);
      sKeys.put("layout/activity_mpornot_fri_answer1_0", com.example.orderattack.R.layout.activity_mpornot_fri_answer1);
      sKeys.put("layout/activity_mpornot_ham_0", com.example.orderattack.R.layout.activity_mpornot_ham);
      sKeys.put("layout/activity_mpornot_ham_answer1_0", com.example.orderattack.R.layout.activity_mpornot_ham_answer1);
      sKeys.put("layout/activity_mpornot_ham_answer2_0", com.example.orderattack.R.layout.activity_mpornot_ham_answer2);
      sKeys.put("layout/activity_mypage_0", com.example.orderattack.R.layout.activity_mypage);
      sKeys.put("layout/activity_orderfinish_0", com.example.orderattack.R.layout.activity_orderfinish);
      sKeys.put("layout/activity_paywaychoose_0", com.example.orderattack.R.layout.activity_paywaychoose);
      sKeys.put("layout/activity_realwalletget_0", com.example.orderattack.R.layout.activity_realwalletget);
      sKeys.put("layout/activity_setornot_0", com.example.orderattack.R.layout.activity_setornot);
      sKeys.put("layout/activity_setside_0", com.example.orderattack.R.layout.activity_setside);
      sKeys.put("layout/activity_setside_drink_0", com.example.orderattack.R.layout.activity_setside_drink);
      sKeys.put("layout/activity_setsize_0", com.example.orderattack.R.layout.activity_setsize);
      sKeys.put("layout/activity_success_order_0", com.example.orderattack.R.layout.activity_success_order);
      sKeys.put("layout/activity_successwindow_0", com.example.orderattack.R.layout.activity_successwindow);
      sKeys.put("layout/activity_together_0", com.example.orderattack.R.layout.activity_together);
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
      sKeys.put("layout/popup_notice_success_lv1_0", com.example.orderattack.R.layout.popup_notice_success_lv1);
    }
  }
}
