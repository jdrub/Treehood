package com.hartfordlab.www.treehood;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ChallengeDetailsFragment extends Fragment {
    User user;
    Challenge challenge;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Bundle b = getArguments();
        final Challenge challenge = (Challenge)b.getSerializable("CHALLENGE");

        user = (User)b.getSerializable("USER");

        View myInflatedView = inflater.inflate(R.layout.challenge_details_layout,container,false);
        Typeface roboto = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");

        ((TextView)myInflatedView.findViewById(R.id.title)).setText(challenge.getName().toString());
        ((TextView)myInflatedView.findViewById(R.id.description)).setText(challenge.getDescription());

        Button button = (Button)myInflatedView.findViewById(R.id.accept_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Challenge clone = challenge.clone();
                clone.setProgress(Challenge.IN_PROGRESS);

                user.addChallenge(clone);

                Toast.makeText(container.getContext(), "Challenge Added!", Toast.LENGTH_SHORT).show();

                getActivity().getFragmentManager().popBackStack();            }
        });

        return myInflatedView;
    }

}
