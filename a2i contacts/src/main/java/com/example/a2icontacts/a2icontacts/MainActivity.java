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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.a2icontacts.helper.CSVReader;
import com.example.a2icontacts.helper.DbManager;
import com.example.a2icontacts.model.Team;

import java.util.List;


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

    private void populateDb() {
        /*if (!Utility.isDbCreated(this)) {
            CSVReader csvReader = new CSVReader(this);
            csvReader.insertEntities();
            Utility.storeDbOperation(this);
        }*/
        CSVReader csvReader = new CSVReader(this);
        csvReader.insertEntities();

        List<Team> teams = DbManager.getInstance().getAllTeams();
        for (Team t : teams) {
            Log.e("Team: ", t.get_name());
        }
       /*java.util.List<SubTeam> subTeams = DbManager.getInstance().getAllSubTeams();
            for (SubTeam t : subTeams) {
                Log.e("SubTeam: ", t.get_name());
            }

            List<A2IContact> a2IContacts = DbManager.getInstance().getAllA2IContacts();
            for (A2IContact t : a2IContacts) {
                Log.e("Contact : ", t.getName());
        }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DbManager.init(this);
        // populateDb();

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
    public void onBackPressed() {

        if (viewPager.getCurrentItem() == 1) {
            if (getSupportFragmentManager().getBackStackEntryCount() > 0)
                getSupportFragmentManager().popBackStackImmediate();
            else finish();
        } else
            finish();
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
            switch (position) {
                case 0:
                    return new ContactsListFragment();
                case 1:
                    return new TransitionFragment();
                default:
                    return new ContactsListFragment();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
