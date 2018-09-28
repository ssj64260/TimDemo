package com.android.timdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.android.timdemo.R;
import com.android.timdemo.business.TimSdkConfigBusiness;
import com.android.timdemo.util.PermissionsHelper;

/**
 * 启动页面
 */
public class SplashActivity extends AppCompatActivity {

    private ConstraintLayout mRootView;

    private AlphaAnimation mAnimation;
    private PermissionsHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initData();
        initView();

        mHelper.requestPermissions(this);
    }

    private void initData() {
        mAnimation = new AlphaAnimation(0f, 1f);
        mAnimation.setDuration(2000);
        mAnimation.setAnimationListener(mAnimationListener);

        mHelper = new PermissionsHelper.Builder()
                .writeExternalStorage()
                .camera()
                .recordAudio()
                .setPermissionsResult(mPermissionsResult)
                .bulid();

        TimSdkConfigBusiness.init();
    }

    private void initView() {
        mRootView = findViewById(R.id.rootView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mHelper.activityResult(this, requestCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mHelper.requestPermissionsResult(this, grantResults);
    }

    @Override
    public void onBackPressed() {

    }

    private PermissionsHelper.OnPermissionsResult mPermissionsResult = new PermissionsHelper.OnPermissionsResult() {
        @Override
        public void allPermissionGranted() {
            mRootView.startAnimation(mAnimation);
        }

        @Override
        public void cancelToSettings() {

        }
    };

    private Animation.AnimationListener mAnimationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            MainActivity.show(SplashActivity.this);
            finish();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };
}
