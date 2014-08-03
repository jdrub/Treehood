package com.hartfordlab.www.treehood;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
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




    public static class AFragment extends Fragment{
        DataManager dataManager;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            dataManager = new DataManager();
            dataManager.generateData();

            View myInflatedView = inflater.inflate(R.layout.afragment,container,false);

            final ArrayList<Challenge> challenges = dataManager.getChallenges();
            Typeface roboto = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");

            TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
            params.setMargins(22, 15, 22, 15); //left,top,right,bottom

            for(int j = 0; j < 2; j++) {
                for (int i = 0; i < challenges.size(); i++) {
                    LinearLayout layout = (LinearLayout) myInflatedView.findViewById(R.id.linear_layout);
                    final Button textView = new Button(container.getContext());
                    textView.setText(challenges.get(i).getName());
                    textView.setGravity(Gravity.CENTER);
                    textView.setTextColor(Color.parseColor("#259900"));
                    textView.setBackgroundColor(Color.parseColor("#ffffff"));
                    textView.setTypeface(roboto);
                    textView.setTextSize(24);
                    //textView.setBackgroundResource(R.drawable.custom_bg);
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

