// Generated by view binder compiler. Do not edit!
package com.goldrush.offortune.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public final class ChooseGameScreenBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView btnGame1;

  @NonNull
  public final TextView btnGame2;

  @NonNull
  public final TextView btnGamebonus;

  @NonNull
  public final Guideline guideline;

  @NonNull
  public final ImageView imageViewWelcome;

  @NonNull
  public final ImageView img1game;

  @NonNull
  public final ImageView img2game;

  private ChooseGameScreenBinding(@NonNull ConstraintLayout rootView, @NonNull TextView btnGame1,
      @NonNull TextView btnGame2, @NonNull TextView btnGamebonus, @NonNull Guideline guideline,
      @NonNull ImageView imageViewWelcome, @NonNull ImageView img1game,
      @NonNull ImageView img2game) {
    this.rootView = rootView;
    this.btnGame1 = btnGame1;
    this.btnGame2 = btnGame2;
    this.btnGamebonus = btnGamebonus;
    this.guideline = guideline;
    this.imageViewWelcome = imageViewWelcome;
    this.img1game = img1game;
    this.img2game = img2game;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ChooseGameScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ChooseGameScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.choose_game_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ChooseGameScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_game1;
      TextView btnGame1 = ViewBindings.findChildViewById(rootView, id);
      if (btnGame1 == null) {
        break missingId;
      }

      id = R.id.btn_game2;
      TextView btnGame2 = ViewBindings.findChildViewById(rootView, id);
      if (btnGame2 == null) {
        break missingId;
      }

      id = R.id.btn_gamebonus;
      TextView btnGamebonus = ViewBindings.findChildViewById(rootView, id);
      if (btnGamebonus == null) {
        break missingId;
      }

      id = R.id.guideline;
      Guideline guideline = ViewBindings.findChildViewById(rootView, id);
      if (guideline == null) {
        break missingId;
      }

      id = R.id.imageViewWelcome;
      ImageView imageViewWelcome = ViewBindings.findChildViewById(rootView, id);
      if (imageViewWelcome == null) {
        break missingId;
      }

      id = R.id.img_1game;
      ImageView img1game = ViewBindings.findChildViewById(rootView, id);
      if (img1game == null) {
        break missingId;
      }

      id = R.id.img_2game;
      ImageView img2game = ViewBindings.findChildViewById(rootView, id);
      if (img2game == null) {
        break missingId;
      }

      return new ChooseGameScreenBinding((ConstraintLayout) rootView, btnGame1, btnGame2,
          btnGamebonus, guideline, imageViewWelcome, img1game, img2game);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}