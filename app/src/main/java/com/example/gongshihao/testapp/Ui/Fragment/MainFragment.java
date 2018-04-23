package com.example.gongshihao.testapp.Ui.Fragment;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.Toast;

import com.example.gongshihao.testapp.Base.BaseFramgent;
import com.example.gongshihao.testapp.R;
import com.example.gongshihao.testapp.Util.RxthrottleFirst;
import com.example.gongshihao.testapp.Util.ViewUtil;
import com.jakewharton.rxbinding2.support.v7.widget.RxSearchView;
import com.jakewharton.rxbinding2.support.v7.widget.RxToolbar;
import com.jakewharton.rxbinding2.support.v7.widget.SearchViewQueryTextEvent;

import butterknife.BindView;
import io.reactivex.functions.Consumer;

/**
 * Created by gongshihao on 2018/4/23.
 */

public class MainFragment extends BaseFramgent{
    @BindView(R.id.navigation_view)
    public NavigationView navigationView;
    public DrawerLayout drawerLayout;
    public static MainFragment newInstance() {
        
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.frament_main;
    }

    @Override
    protected void viewCreate(Bundle savedInstanceState) {
        initView();
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
        setupDrawerContent(navigationView);

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {

                            case R.id.navigation_item_book:
                                ViewUtil.showToast("navigation_item_book");
                                break;
                            case R.id.navigation_item_example:
                                ViewUtil.showToast("navigation_item_example");
                                break;
                            case R.id.navigation_item_blog:
                                ViewUtil.showToast("navigation_item_blog");
                                break;
                            case R.id.navigation_item_about:
                                ViewUtil.showToast("navigation_item_about");
                                break;

                        }
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.toolmenu,menu);
        MenuItem menuItem=menu.findItem(R.id.search);
        SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        mSearchView.setSubmitButtonEnabled(true);
        RxSearchView.queryTextChangeEvents(mSearchView).compose(RxthrottleFirst.<SearchViewQueryTextEvent>applyRxThrottle())
                .subscribe(new Consumer<SearchViewQueryTextEvent>() {
                    @Override
                    public void accept(SearchViewQueryTextEvent searchViewQueryTextEvent) throws Exception {
                        if(searchViewQueryTextEvent.isSubmitted()){
                            Toast.makeText(mContext,searchViewQueryTextEvent.queryText().toString(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
