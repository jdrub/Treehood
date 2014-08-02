package com.hartfordlab.www.treehood;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by will on 8/2/14.
 */
    public class StartActivity extends Activity {
        public static Context appContext;

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);

//ActionBar gets initiated
            ActionBar actionbar = getActionBar();
//Tell the ActionBar we want to use Tabs.
            actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//initiating both tabs and set text to it.
            ActionBar.Tab PlayerTab = actionbar.newTab().setText("Fragment A");
            ActionBar.Tab StationsTab = actionbar.newTab().setText("Fragment B");
            ActionBar.Tab ThirdTab = actionbar.newTab().setText("Fragment C");

//create the two fragments we want to use for display content
            Fragment PlayerFragment = new AFragment();
            Fragment StationsFragment = new BFragment();
            Fragment ThirdFragment = new CFragment();

//set the Tab listener. Now we can listen for clicks.
            PlayerTab.setTabListener(new MyTabsListener(PlayerFragment));
            StationsTab.setTabListener(new MyTabsListener(StationsFragment));
            ThirdTab.setTabListener(new MyTabsListener(ThirdFragment));

//add the two tabs to the actionbar
            actionbar.addTab(PlayerTab);
            actionbar.addTab(StationsTab);
            actionbar.addTab(ThirdTab);
        }

    public static class AFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.afragment, container, false);
        }

    }

    public static class BFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.bfragment, container, false);
        }

    }

    public static class CFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.cfragment, container, false);
        }

    }


}

