package com.lance.androidlovelylogin;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener {

    private LinearLayout mLayoutHideHand;
    private LinearLayout mLayoutShowHand;
    private EditText mEdt_username;
    private EditText mEdt_password;
    private ImageView mIv_avator;
    private ImageView mIv_left_hand_hide;
    private ImageView mIv_right_hand_hide;
    private ImageView mIv_left_hand_show;
    private ImageView mIv_right_hand_show;
    private Handler mHandler = new Handler();
    //动画
    private Animation mAnimationTranlate_Right;
    private Animation mAnimationTranlate_Left;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        bindViews();
        //
        mAnimationTranlate_Right = AnimationUtils.loadAnimation(this, R.anim.translation_right);
        mAnimationTranlate_Left = AnimationUtils.loadAnimation(this, R.anim.translation_left);
        //
        mEdt_password.setOnFocusChangeListener(this);
        mEdt_username.setOnFocusChangeListener(this);
    }

    private void bindViews() {
        mLayoutHideHand = (LinearLayout) findViewById(R.id.layout_hand_hide);
        mLayoutShowHand = (LinearLayout) findViewById(R.id.layout_hand_show);
        mEdt_username = (EditText) findViewById(R.id.edt_username);
        mEdt_password = (EditText) findViewById(R.id.edt_password);
        mIv_avator = (ImageView) findViewById(R.id.iv_avator);
        mIv_left_hand_hide = (ImageView) findViewById(R.id.iv_left_hand_hide);
        mIv_right_hand_hide = (ImageView) findViewById(R.id.iv_right_hand_hide);
        mIv_left_hand_show = (ImageView) findViewById(R.id.iv_left_hand_show);
        mIv_right_hand_show = (ImageView) findViewById(R.id.iv_right_hand_show);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(mEdt_username.hasFocus()){
            mIv_left_hand_show.startAnimation(mAnimationTranlate_Left);
            mIv_right_hand_show.setAnimation(mAnimationTranlate_Right);
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mLayoutHideHand.setVisibility(View.GONE);
                    mLayoutShowHand.setVisibility(View.VISIBLE);
                }
            }, 500);
        }
        if(mEdt_password.hasFocus()){
            mIv_left_hand_show.startAnimation(mAnimationTranlate_Right);
            mIv_right_hand_show.setAnimation(mAnimationTranlate_Left);
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mLayoutHideHand.setVisibility(View.VISIBLE);
                    mLayoutShowHand.setVisibility(View.GONE);
                }
            }, 500);
        }
    }
}
