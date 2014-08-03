package com.hartfordlab.www.treehood;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import static com.hartfordlab.www.treehood.R.color.TreeGreen;

/**
 * Created by will on 8/2/14.
 */
    public class StartActivity extends Activity {
        public static Context appContext;

        /** Called when the activity is first created. */
        @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);

//ActionBar gets initiated
            ActionBar actionbar = getActionBar();



//Tell the ActionBar we want to use Tabs.
            actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            actionbar.setDisplayShowHomeEnabled(false);
            actionbar.setDisplayShowTitleEnabled(false);
//initiating both tabs and set text to it.
            //ActionBar.Tab PlayerTab = actionbar.newTab();//.setText("Fragment A");
            //ActionBar.Tab StationsTab = actionbar.newTab();//.setText("Fragment B");
            //ActionBar.Tab ThirdTab = actionbar.newTab();//.setText("Fragment C");
            TextView t = (TextView) findViewById(R.id.standard_tabs);
            TextView t2 = (TextView) findViewById(R.id.standard_tabs2);
            TextView t3 = (TextView) findViewById(R.id.standard_tabs3);
            t.setText("Testing");
            t2.setText("Testing2");
            t3.setText("Testing3");

            ActionBar.Tab PlayerTab = actionbar.newTab()
                        .setCustomView(t);
            ActionBar.Tab StationsTab = actionbar.newTab()
                    .setCustomView(t2);
            ActionBar.Tab ThirdTab = actionbar.newTab()
                    .setCustomView(t3);

            actionbar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(TreeGreen)));
            actionbar.setStackedBackgroundDrawable(getResources().getDrawable(
                    R.drawable.tab_bg));

//create the two fragments we want to use for display content
            Fragment PlayerFragment = new AFragment();
            Fragment StationsFragment = new BFragment();
            Fragment ThirdFragment = new CFragment();

//set the Tab listener. Now we can listen for clicks.
            PlayerTab.setTabListener(new MyTabsListener(PlayerFragment));
            StationsTab.setTabListener(new MyTabsListener(StationsFragment));
            ThirdTab.setTabListener(new MyTabsListener(ThirdFragment));

//add the two tabs to the actionbar
            System.out.println(PlayerTab.toString() +"\t"+ StationsTab.toString() +"\t"+ ThirdTab.toString());
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

