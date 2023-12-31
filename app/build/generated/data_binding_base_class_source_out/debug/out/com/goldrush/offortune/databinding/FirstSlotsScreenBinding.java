// Generated by view binder compiler. Do not edit!
package com.goldrush.offortune.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.goldrush.offortune.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FirstSlotsScreenBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LottieAnimationView animationWinLottie;

  @NonNull
  public final TextView btnDown;

  @NonNull
  public final TextView btnSpin;

  @NonNull
  public final TextView btnUp;

  /**
   * This binding is not available in all configurations.
   * <p>
   * Present:
   * <ul>
   *   <li>layout-land/</li>
   * </ul>
   *
   * Absent:
   * <ul>
   *   <li>layout/</li>
   * </ul>
   */
  @Nullable
  public final Guideline guideline3;

  @NonNull
  public final LinearLayout holder1;

  @NonNull
  public final LinearLayout holder2;

  @NonNull
  public final LinearLayout holder3;

  @NonNull
  public final LinearLayout holder4;

  @NonNull
  public final LinearLayout holder5;

  @NonNull
  public final LinearLayout linearPointer;

  /**
   * This binding is not available in all configurations.
   * <p>
   * Present:
   * <ul>
   *   <li>layout-land/</li>
   * </ul>
   *
   * Absent:
   * <ul>
   *   <li>layout/</li>
   * </ul>
   */
  @Nullable
  public final RelativeLayout relativeLayout3;

  @NonNull
  public final ScrollView scroll1;

  @NonNull
  public final ScrollView scroll2;

  @NonNull
  public final ScrollView scroll3;

  @NonNull
  public final ScrollView scroll4;

  @NonNull
  public final ScrollView scroll5;

  @NonNull
  public final TextView tvBankScore;

  @NonNull
  public final TextView tvBetScore;

  @NonNull
  public final TextView tvWinScore;

  @NonNull
  public final View view;

  private FirstSlotsScreenBinding(@NonNull ConstraintLayout rootView,
      @NonNull LottieAnimationView animationWinLottie, @NonNull TextView btnDown,
      @NonNull TextView btnSpin, @NonNull TextView btnUp, @Nullable Guideline guideline3,
      @NonNull LinearLayout holder1, @NonNull LinearLayout holder2, @NonNull LinearLayout holder3,
      @NonNull LinearLayout holder4, @NonNull LinearLayout holder5,
      @NonNull LinearLayout linearPointer, @Nullable RelativeLayout relativeLayout3,
      @NonNull ScrollView scroll1, @NonNull ScrollView scroll2, @NonNull ScrollView scroll3,
      @NonNull ScrollView scroll4, @NonNull ScrollView scroll5, @NonNull TextView tvBankScore,
      @NonNull TextView tvBetScore, @NonNull TextView tvWinScore, @NonNull View view) {
    this.rootView = rootView;
    this.animationWinLottie = animationWinLottie;
    this.btnDown = btnDown;
    this.btnSpin = btnSpin;
    this.btnUp = btnUp;
    this.guideline3 = guideline3;
    this.holder1 = holder1;
    this.holder2 = holder2;
    this.holder3 = holder3;
    this.holder4 = holder4;
    this.holder5 = holder5;
    this.linearPointer = linearPointer;
    this.relativeLayout3 = relativeLayout3;
    this.scroll1 = scroll1;
    this.scroll2 = scroll2;
    this.scroll3 = scroll3;
    this.scroll4 = scroll4;
    this.scroll5 = scroll5;
    this.tvBankScore = tvBankScore;
    this.tvBetScore = tvBetScore;
    this.tvWinScore = tvWinScore;
    this.view = view;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FirstSlotsScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FirstSlotsScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.first_slots_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FirstSlotsScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.animationWinLottie;
      LottieAnimationView animationWinLottie = ViewBindings.findChildViewById(rootView, id);
      if (animationWinLottie == null) {
        break missingId;
      }

      id = R.id.btn_down;
      TextView btnDown = ViewBindings.findChildViewById(rootView, id);
      if (btnDown == null) {
        break missingId;
      }

      id = R.id.btn_spin;
      TextView btnSpin = ViewBindings.findChildViewById(rootView, id);
      if (btnSpin == null) {
        break missingId;
      }

      id = R.id.btn_up;
      TextView btnUp = ViewBindings.findChildViewById(rootView, id);
      if (btnUp == null) {
        break missingId;
      }

      id = R.id.guideline3;
      Guideline guideline3 = ViewBindings.findChildViewById(rootView, id);

      id = R.id.holder1;
      LinearLayout holder1 = ViewBindings.findChildViewById(rootView, id);
      if (holder1 == null) {
        break missingId;
      }

      id = R.id.holder2;
      LinearLayout holder2 = ViewBindings.findChildViewById(rootView, id);
      if (holder2 == null) {
        break missingId;
      }

      id = R.id.holder3;
      LinearLayout holder3 = ViewBindings.findChildViewById(rootView, id);
      if (holder3 == null) {
        break missingId;
      }

      id = R.id.holder4;
      LinearLayout holder4 = ViewBindings.findChildViewById(rootView, id);
      if (holder4 == null) {
        break missingId;
      }

      id = R.id.holder5;
      LinearLayout holder5 = ViewBindings.findChildViewById(rootView, id);
      if (holder5 == null) {
        break missingId;
      }

      id = R.id.linear_pointer;
      LinearLayout linearPointer = ViewBindings.findChildViewById(rootView, id);
      if (linearPointer == null) {
        break missingId;
      }

      id = R.id.relativeLayout3;
      RelativeLayout relativeLayout3 = ViewBindings.findChildViewById(rootView, id);

      id = R.id.scroll1;
      ScrollView scroll1 = ViewBindings.findChildViewById(rootView, id);
      if (scroll1 == null) {
        break missingId;
      }

      id = R.id.scroll2;
      ScrollView scroll2 = ViewBindings.findChildViewById(rootView, id);
      if (scroll2 == null) {
        break missingId;
      }

      id = R.id.scroll3;
      ScrollView scroll3 = ViewBindings.findChildViewById(rootView, id);
      if (scroll3 == null) {
        break missingId;
      }

      id = R.id.scroll4;
      ScrollView scroll4 = ViewBindings.findChildViewById(rootView, id);
      if (scroll4 == null) {
        break missingId;
      }

      id = R.id.scroll5;
      ScrollView scroll5 = ViewBindings.findChildViewById(rootView, id);
      if (scroll5 == null) {
        break missingId;
      }

      id = R.id.tv_bank_score;
      TextView tvBankScore = ViewBindings.findChildViewById(rootView, id);
      if (tvBankScore == null) {
        break missingId;
      }

      id = R.id.tv_bet_score;
      TextView tvBetScore = ViewBindings.findChildViewById(rootView, id);
      if (tvBetScore == null) {
        break missingId;
      }

      id = R.id.tv_win_score;
      TextView tvWinScore = ViewBindings.findChildViewById(rootView, id);
      if (tvWinScore == null) {
        break missingId;
      }

      id = R.id.view;
      View view = ViewBindings.findChildViewById(rootView, id);
      if (view == null) {
        break missingId;
      }

      return new FirstSlotsScreenBinding((ConstraintLayout) rootView, animationWinLottie, btnDown,
          btnSpin, btnUp, guideline3, holder1, holder2, holder3, holder4, holder5, linearPointer,
          relativeLayout3, scroll1, scroll2, scroll3, scroll4, scroll5, tvBankScore, tvBetScore,
          tvWinScore, view);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
