package com.hartfordlab.www.treehood;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.TabActivity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by will on 8/2/14.
 */
    public class StartActivity extends Activity {
        public static Context appContext;
        User user;

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);

            User user = (User)getIntent().getSerializableExtra("USER");


//ActionBar gets initiated
            ActionBar actionbar = getActionBar();
//Tell the ActionBar we want to use Tabs.
            actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            actionbar.setDisplayShowHomeEnabled(false);
            actionbar.setDisplayShowTitleEnabled(false);
//initiating both tabs and set text to it.

            TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 4, 0, 0); //left,top,right,bottom


            TextView t = (TextView) findViewById(R.id.standard_tabs);
            t.setTextSize(20);
            t.setLayoutParams(params);

            TextView t2 = (TextView) findViewById(R.id.standard_tabs2);
            t2.setTextSize(30);
            TextView t3 = (TextView) findViewById(R.id.standard_tabs3);
            t3.setTextSize(20);
            t3.setLayoutParams(params);


            t.setText("Challenge");
            t2.setText("Me");
            t3.setText("Rank");

            ActionBar.Tab PlayerTab = actionbar.newTab()
                    .setCustomView(t);
            ActionBar.Tab StationsTab = actionbar.newTab()
                    .setCustomView(t2);
            ActionBar.Tab ThirdTab = actionbar.newTab()
                    .setCustomView(t3);

            actionbar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
            actionbar.setStackedBackgroundDrawable(getResources().getDrawable(
                    R.drawable.tab_bg));



//create the two fragments we want to use for display content
            Fragment PlayerFragment = new AFragment();
            Bundle args = new Bundle();
            args.putSerializable("USER", user);
            PlayerFragment.setArguments(args);

            Fragment StationsFragment = new BFragment();
            StationsFragment.setArguments(args);

            Fragment ThirdFragment = new CFragment();
            ThirdFragment.setArguments(args);

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

        DataManager dataManager;
        User user;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            dataManager = new DataManager();
            dataManager.generateData();

            user = (User)getArguments().getSerializable("USER");

            View myInflatedView = inflater.inflate(R.layout.afragment,container,false);


            final ArrayList<Challenge> challenges = dataManager.getChallenges();
            Typeface roboto = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Black.ttf");

            TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
            params.setMargins(22, 0, 22, 25); //left,top,right,bottom



            for(int j = 0; j < 2; j++) {
                for (int i = 0; i < challenges.size(); i++) {
                    LinearLayout layout = (LinearLayout) myInflatedView.findViewById(R.id.linear_layout);
                    final Button textView = new Button(container.getContext());
                    textView.setText(challenges.get(i).getName());
                    textView.setGravity(Gravity.CENTER_HORIZONTAL);
                    textView.setGravity(Gravity.CENTER_VERTICAL);
                    textView.setWidth(500);
                    textView.setTextColor(Color.parseColor("#259900"));
                    textView.setBackgroundColor(Color.parseColor("#ffffff"));
                    textView.setTypeface(roboto);
                    textView.setTextSize(20);
                    textView.setLayoutParams(params);
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //start a new activity/fragment to view the challenge

                            // Create new fragment and transaction
                            Fragment newFragment = new ChallengeDetailsFragment();
                            Bundle args = new Bundle();
                            args.putSerializable("CHALLENGE",
                                    dataManager.getChallenge(textView.getText().toString()));
                            args.putSerializable("USER",user);

                            newFragment.setArguments(args);

                            FragmentTransaction transaction = getFragmentManager().beginTransaction();

                            // Replace whatever is in the fragment_container view with this fragment,
                            // and add the transaction to the back stack
                            transaction.replace(R.id.fragment_container, newFragment);
                            transaction.addToBackStack(null);

                            // Commit the transaction
                            transaction.commit();


                        }
                    });

                    layout.addView(textView);
                }
            }

            return myInflatedView;
        }

    }

    public static class BFragment extends Fragment {
        User user;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment

            user = (User)getArguments().getSerializable("USER");

            View myInflatedView = inflater.inflate(R.layout.bfragment, container, false);
            Typeface roboto = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");

            TextView t = ((TextView)myInflatedView.findViewById(R.id.name));
            t.setTypeface(roboto);
            t.setText(user.getName());


            TextView t2 = ((TextView)myInflatedView.findViewById(R.id.scorein));
            t2.setTypeface(roboto);
            t2.setText((new Integer(user.getScore())).toString());

            TextView t3 = ((TextView)myInflatedView.findViewById(R.id.treename));
            t3.setTypeface(roboto);
            t3.setText(user.getTreeName());

            for(Challenge c: user.getChallenges()){
                LinearLayout l = (LinearLayout)myInflatedView.findViewById(R.id.challenges);
                TextView textView = new TextView(container.getContext());
                textView.setText(c.getName());
                textView.setTypeface(roboto);
                textView.setTextSize(15);
                //TODO: add margins/padding
                l.addView(textView);
            }

            return myInflatedView;
        }

    }

    public static class CFragment extends Fragment {
        User user;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //TODO: pass in an already instantiated DataManager,
            DataManager dataManager = new DataManager();
            dataManager.generateData();

            View myInflatedView = inflater.inflate(R.layout.cfragment, container, false);

            user = (User)getArguments().getSerializable("USER");
            Typeface roboto = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");
            ArrayList<User> adjacentUsers = dataManager.getTree(user.getTreeName()).getUsers();

            //sort users in my tree (adjacentUsers)
            Collections.sort(adjacentUsers);

            LinearLayout l = (LinearLayout)myInflatedView.findViewById(R.id.linear_layout_c);
            TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
            params.setMargins(22, 0, 22, 25); //left,top,right,bottom

            for(User u: adjacentUsers){

                System.out.println("j_: username: " + u.getName());
                Button textView = new Button(container.getContext());
                textView.setText(u.getName() + ": " + Integer.valueOf(u.getScore()));
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setTypeface(roboto);
                textView.setWidth(500);
                textView.setTextColor(Color.parseColor("#259900"));
                textView.setBackgroundColor(Color.parseColor("#ffffff"));
                textView.setTextSize(20);
                textView.setLayoutParams(params);

                l.addView(textView);

            }

            return myInflatedView;
        }

    }


}

