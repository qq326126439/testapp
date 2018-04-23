package com.example.gongshihao.testapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.arcsoft.facerecognition.AFR_FSDKEngine;
import com.arcsoft.facerecognition.AFR_FSDKError;
import com.arcsoft.facerecognition.AFR_FSDKVersion;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private AFR_FSDKEngine mEngine;
    private AFR_FSDKVersion mFRVersion;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initFaceEngine();
    }

    private void initFaceEngine() {
        mEngine=new AFR_FSDKEngine();
        mFRVersion = new AFR_FSDKVersion();
        AFR_FSDKError error=mEngine.AFR_FSDK_InitialEngine(Constracts.App_id,Constracts.FR_SDK_key);
        if (error.getCode() != AFR_FSDKError.MOK) {

        } else {
            mEngine.AFR_FSDK_GetVersion(mFRVersion);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mEngine != null) {
            mEngine.AFR_FSDK_UninitialEngine();
        }
    }
}
