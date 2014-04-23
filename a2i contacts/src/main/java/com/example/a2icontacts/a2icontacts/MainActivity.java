package com.example.a2icontacts.a2icontacts;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    private static final int NUM_PAGES = 5;

    private ActionBar actionBar;
    private ViewPager viewPager;

    private void addActionBarTabs(ActionBar.TabListener listener) {
        actionBar.addTab(actionBar.newTab().setText(getString(R.string.pager_category_a2i)).setTabListener(listener));
        actionBar.addTab(actionBar.newTab().setText(getString(R.string.pager_category_a2i_teams)).setTabListener(listener));
        actionBar.addTab(actionBar.newTab().setText(getString(R.string.pager_category_pmo)).setTabListener(listener));
        actionBar.addTab(actionBar.newTab().setText(getString(R.string.pager_category_donors)).setTabListener(listener));
        actionBar.addTab(actionBar.newTab().setText(getString(R.string.pager_category_cabinet)).setTabListener(listener));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        viewPager = (ViewPager) findViewById(R.id.viewpager_categories);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            }
        };
        addActionBarTabs(tabListener);

        viewPager.setAdapter(new CategoriesPagerAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        /*TitlePageIndicator titlePageIndicator = (TitlePageIndicator) findViewById(R.id.titles);
        titlePageIndicator.setViewPager(viewPager);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_search:
                Intent contactPickIntent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(contactPickIntent, 1);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class CategoriesPagerAdapter extends FragmentStatePagerAdapter {

        public CategoriesPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new ContactsListFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
