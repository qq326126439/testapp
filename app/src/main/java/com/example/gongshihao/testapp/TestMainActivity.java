package com.example.gongshihao.testapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gongshihao.testapp.Base.BaseActivity;
import com.example.gongshihao.testapp.Ui.Fragment.MainFragment;
import com.example.gongshihao.testapp.Util.RxthrottleFirst;
import com.jakewharton.rxbinding2.support.v7.widget.RxToolbar;

import io.reactivex.functions.Consumer;

/**
 * Created by gongshihao on 2018/4/19.
 */

public class TestMainActivity extends BaseActivity{
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initCreate(Bundle savedInstanceState) {
        loadRootFragment(R.id.content, MainFragment.newInstance());
    }

    private void initView() {
        RxToolbar.itemClicks(toolbar).compose(RxthrottleFirst.<MenuItem>applyRxThrottle()).subscribe(new Consumer<MenuItem>() {
            @Override
            public void accept(MenuItem menuItem) throws Exception {
                switch (menuItem.getItemId()){
                    case R.id.scan:
                        Toast.makeText(mContext,"click the scan",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.setting:
                        Toast.makeText(mContext,"click the setting",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.help:
                        Toast.makeText(mContext,"click the help",Toast.LENGTH_LONG).show();
                        break;

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {

        return true;
    }

}
