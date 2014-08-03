package com.hartfordlab.www.treehood;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ChallengeDetailsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Bundle b = getArguments();
        Challenge challenge = (Challenge)b.getSerializable("CHALLENGE");
        View myInflatedView = inflater.inflate(R.layout.challenge_details_layout,container,false);
        Typeface roboto = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");

        ((TextView)myInflatedView.findViewById(R.id.title)).setText(challenge.getName());
        ((TextView)myInflatedView.findViewById(R.id.description)).setText(challenge.getDescription());

        return myInflatedView;
    }

}
