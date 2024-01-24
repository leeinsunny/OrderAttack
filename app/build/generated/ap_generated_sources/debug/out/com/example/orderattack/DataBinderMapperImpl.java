package com.example.orderattack;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.orderattack.databinding.ActivitiyStage2introBindingImpl;
import com.example.orderattack.databinding.ActivityGameintroBindingImpl;
import com.example.orderattack.databinding.ActivityIntroBindingImpl;
import com.example.orderattack.databinding.ActivityJoinBindingImpl;
import com.example.orderattack.databinding.ActivityLoginBindingImpl;
import com.example.orderattack.databinding.ActivityMainBindingImpl;
import com.example.orderattack.databinding.ActivityStage1introBindingImpl;
import com.example.orderattack.databinding.ActivityStage3introBindingImpl;
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

  private static final int LAYOUT_ACTIVITYGAMEINTRO = 2;

  private static final int LAYOUT_ACTIVITYINTRO = 3;

  private static final int LAYOUT_ACTIVITYJOIN = 4;

  private static final int LAYOUT_ACTIVITYLOGIN = 5;

  private static final int LAYOUT_ACTIVITYMAIN = 6;

  private static final int LAYOUT_ACTIVITYSTAGE1INTRO = 7;

  private static final int LAYOUT_ACTIVITYSTAGE3INTRO = 8;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(8);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activitiy_stage2intro, LAYOUT_ACTIVITIYSTAGE2INTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_gameintro, LAYOUT_ACTIVITYGAMEINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_intro, LAYOUT_ACTIVITYINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_join, LAYOUT_ACTIVITYJOIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_stage1intro, LAYOUT_ACTIVITYSTAGE1INTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.orderattack.R.layout.activity_stage3intro, LAYOUT_ACTIVITYSTAGE3INTRO);
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
        case  LAYOUT_ACTIVITYGAMEINTRO: {
          if ("layout/activity_gameintro_0".equals(tag)) {
            return new ActivityGameintroBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_gameintro is invalid. Received: " + tag);
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
        case  LAYOUT_ACTIVITYSTAGE1INTRO: {
          if ("layout/activity_stage1intro_0".equals(tag)) {
            return new ActivityStage1introBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_stage1intro is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSTAGE3INTRO: {
          if ("layout/activity_stage3intro_0".equals(tag)) {
            return new ActivityStage3introBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_stage3intro is invalid. Received: " + tag);
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
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(8);

    static {
      sKeys.put("layout/activitiy_stage2intro_0", com.example.orderattack.R.layout.activitiy_stage2intro);
      sKeys.put("layout/activity_gameintro_0", com.example.orderattack.R.layout.activity_gameintro);
      sKeys.put("layout/activity_intro_0", com.example.orderattack.R.layout.activity_intro);
      sKeys.put("layout/activity_join_0", com.example.orderattack.R.layout.activity_join);
      sKeys.put("layout/activity_login_0", com.example.orderattack.R.layout.activity_login);
      sKeys.put("layout/activity_main_0", com.example.orderattack.R.layout.activity_main);
      sKeys.put("layout/activity_stage1intro_0", com.example.orderattack.R.layout.activity_stage1intro);
      sKeys.put("layout/activity_stage3intro_0", com.example.orderattack.R.layout.activity_stage3intro);
    }
  }
}
