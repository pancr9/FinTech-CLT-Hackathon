package herapheri.com.fintech.Controller;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import herapheri.com.fintech.R;

public class TabbarActivity extends AppCompatActivity {

    public PagerAdapter pagerAdapter;
    public TabLayout tabLayout;
    ViewPager mViewPager;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbar);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FragmentManager fragmentManager = getSupportFragmentManager();
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        setTitle("Test");
        pagerAdapter = new PagerAdapter(
                fragmentManager);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Lend It");
        setUpTablayout();
        setSupportActionBar(toolbar);

    }


    public void setUpTablayout() {
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                final InputMethodManager imm = (InputMethodManager) getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mViewPager.getWindowToken(), 0);

            }

            @Override
            public void onPageScrolled(int position, float offset, int offsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mViewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"));
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            if (i == 0) {
                //tabLayout.getTabAt(0).setIcon(R.drawable.pin);
                tabLayout.getTabAt(0).setText("Home");
            }
            if (i == 1) {
                // tabLayout.getTabAt(1).setIcon(R.drawable.settings);
                tabLayout.getTabAt(1).setText("Requests");
            }
            if (i == 2) {
                tabLayout.getTabAt(2).setText("Account");

            }
            if (i == 3) {
                //tabLayout.getTabAt(2).setIcon(R.drawable.accountios2);
                tabLayout.getTabAt(3).setText("Lend");

            }
            mViewPager.setCurrentItem(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_exit:
                Toast.makeText(this, " Logout", Toast.LENGTH_SHORT)
                        .show();
                finish();
                break;
            // action with ID action_settings was selected

            default:
                break;
        }

        return true;
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {


        PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if (i == 0) {
                //fragment = new YurperFragment();
                Fragment fragment = new HomeFragment();
                Bundle args = new Bundle();
                // Our object is just an integer :-P
                fragment.setArguments(args);
                return fragment;

            }
            if (i == 1) {

                Fragment fragment = new RequestFragment();
                Bundle args = new Bundle();
                // Our object is just an integer :-P
                fragment.setArguments(args);
                return fragment;
            } else if (i == 2) {
                Fragment fragment = new AccountFragment();
                Bundle args = new Bundle();
                // Our object is just an integer :-P
                fragment.setArguments(args);
                return fragment;
            } else if (i == 3) {
                Fragment fragment = new LenderFragment();
                Bundle args = new Bundle();
                // Our object is just an integer :-P
                fragment.setArguments(args);
                return fragment;
            }
            return null;
        }


        @Override
        public int getCount() {
            return 4;
        }


    }
}


