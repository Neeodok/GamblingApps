// Generated by view binder compiler. Do not edit!
package com.goldrush.offortune.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.goldrush.offortune.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SettingsScreenBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView btnResScore;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final RadioButton musicOff;

  @NonNull
  public final RadioButton musicOn;

  @NonNull
  public final RadioGroup rd;

  @NonNull
  public final RadioGroup rd1;

  @NonNull
  public final ImageView soff;

  @NonNull
  public final RadioButton soundOff;

  @NonNull
  public final RadioButton soundOn;

  private SettingsScreenBinding(@NonNull ConstraintLayout rootView, @NonNull TextView btnResScore,
      @NonNull ImageView imageView2, @NonNull RadioButton musicOff, @NonNull RadioButton musicOn,
      @NonNull RadioGroup rd, @NonNull RadioGroup rd1, @NonNull ImageView soff,
      @NonNull RadioButton soundOff, @NonNull RadioButton soundOn) {
    this.rootView = rootView;
    this.btnResScore = btnResScore;
    this.imageView2 = imageView2;
    this.musicOff = musicOff;
    this.musicOn = musicOn;
    this.rd = rd;
    this.rd1 = rd1;
    this.soff = soff;
    this.soundOff = soundOff;
    this.soundOn = soundOn;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SettingsScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SettingsScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.settings_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SettingsScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_res_score;
      TextView btnResScore = ViewBindings.findChildViewById(rootView, id);
      if (btnResScore == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.music_off;
      RadioButton musicOff = ViewBindings.findChildViewById(rootView, id);
      if (musicOff == null) {
        break missingId;
      }

      id = R.id.music_on;
      RadioButton musicOn = ViewBindings.findChildViewById(rootView, id);
      if (musicOn == null) {
        break missingId;
      }

      id = R.id.rd;
      RadioGroup rd = ViewBindings.findChildViewById(rootView, id);
      if (rd == null) {
        break missingId;
      }

      id = R.id.rd1;
      RadioGroup rd1 = ViewBindings.findChildViewById(rootView, id);
      if (rd1 == null) {
        break missingId;
      }

      id = R.id.soff;
      ImageView soff = ViewBindings.findChildViewById(rootView, id);
      if (soff == null) {
        break missingId;
      }

      id = R.id.sound_off;
      RadioButton soundOff = ViewBindings.findChildViewById(rootView, id);
      if (soundOff == null) {
        break missingId;
      }

      id = R.id.sound_on;
      RadioButton soundOn = ViewBindings.findChildViewById(rootView, id);
      if (soundOn == null) {
        break missingId;
      }

      return new SettingsScreenBinding((ConstraintLayout) rootView, btnResScore, imageView2,
          musicOff, musicOn, rd, rd1, soff, soundOff, soundOn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}