package com.lance.androidlovelylogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        bindViews();
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
            mLayoutHideHand.setVisibility(View.GONE);
            mLayoutShowHand.setVisibility(View.VISIBLE);
        }
        if(mEdt_password.hasFocus()){
            mLayoutHideHand.setVisibility(View.VISIBLE);
            mLayoutShowHand.setVisibility(View.GONE);
        }
    }
}
