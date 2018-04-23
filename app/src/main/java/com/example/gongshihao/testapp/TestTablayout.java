package com.example.gongshihao.testapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import com.example.gongshihao.testapp.Base.BaseActivity;
import com.example.gongshihao.testapp.Base.BaseFramgent;

import butterknife.BindView;

/**
 * Created by gongshihao on 2018/4/23.
 */

public class TestTablayout extends BaseActivity{
    @BindView(R.id.TabLayout)
    public TabLayout tabLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test_tablayout;
    }

    @Override
    protected void initCreate(Bundle savedInstanceState) {

    }
}
