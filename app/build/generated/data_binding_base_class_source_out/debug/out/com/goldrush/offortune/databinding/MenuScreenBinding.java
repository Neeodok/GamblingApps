// Generated by view binder compiler. Do not edit!
package com.goldrush.offortune.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.goldrush.offortune.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MenuScreenBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView btnChoosegame;

  @NonNull
  public final TextView btnExit;

  @NonNull
  public final TextView btnPrivacy;

  @NonNull
  public final TextView btnSettings;

  @NonNull
  public final Guideline guideline2;

  private MenuScreenBinding(@NonNull ConstraintLayout rootView, @NonNull TextView btnChoosegame,
      @NonNull TextView btnExit, @NonNull TextView btnPrivacy, @NonNull TextView btnSettings,
      @NonNull Guideline guideline2) {
    this.rootView = rootView;
    this.btnChoosegame = btnChoosegame;
    this.btnExit = btnExit;
    this.btnPrivacy = btnPrivacy;
    this.btnSettings = btnSettings;
    this.guideline2 = guideline2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MenuScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MenuScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.menu_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MenuScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_choosegame;
      TextView btnChoosegame = ViewBindings.findChildViewById(rootView, id);
      if (btnChoosegame == null) {
        break missingId;
      }

      id = R.id.btn_exit;
      TextView btnExit = ViewBindings.findChildViewById(rootView, id);
      if (btnExit == null) {
        break missingId;
      }

      id = R.id.btn_privacy;
      TextView btnPrivacy = ViewBindings.findChildViewById(rootView, id);
      if (btnPrivacy == null) {
        break missingId;
      }

      id = R.id.btn_settings;
      TextView btnSettings = ViewBindings.findChildViewById(rootView, id);
      if (btnSettings == null) {
        break missingId;
      }

      id = R.id.guideline2;
      Guideline guideline2 = ViewBindings.findChildViewById(rootView, id);
      if (guideline2 == null) {
        break missingId;
      }

      return new MenuScreenBinding((ConstraintLayout) rootView, btnChoosegame, btnExit, btnPrivacy,
          btnSettings, guideline2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
