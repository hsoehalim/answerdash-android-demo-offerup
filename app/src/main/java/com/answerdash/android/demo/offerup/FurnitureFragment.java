package com.answerdash.android.demo.offerup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.answerdash.android.sdk.AnswerDash;
import com.answerdash.android.sdk.AnswerDashButton;

public class FurnitureFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        AnswerDash.INSTANCE.setAppState(getActivity().getApplication(), "trust");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_furniture, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        final AnswerDashButton helpButton = (AnswerDashButton) view.findViewById(R.id.helpButton);
        helpButton.setBorderColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
        helpButton.setFillColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        helpButton.setFillColorSelected(ContextCompat.getColor(getContext(), R.color.colorPrimaryTransparent));
        helpButton.setIconColor(ContextCompat.getColor(getContext(), android.R.color.white));
    }
}
