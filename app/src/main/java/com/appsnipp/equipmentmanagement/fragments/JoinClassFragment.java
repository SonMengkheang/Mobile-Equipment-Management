package com.appsnipp.equipmentmanagement.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.appsnipp.equipmentmanagement.LoginActivity;
import com.appsnipp.equipmentmanagement.MainActivity;
import com.appsnipp.equipmentmanagement.R;

public class JoinClassFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_joinclass, container, false);
    }
}
