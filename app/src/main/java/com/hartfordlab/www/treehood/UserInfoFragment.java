package com.hartfordlab.www.treehood;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by librajrd on 8/3/14.
 */
public class UserInfoFragment extends Fragment{
    User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Bundle b = getArguments();
        user = (User) b.getSerializable("USER");

        View myInflatedView = inflater.inflate(R.layout.user_info_layout, container, false);
        Typeface roboto = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");


        return myInflatedView;
    }
}