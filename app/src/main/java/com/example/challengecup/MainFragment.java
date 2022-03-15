package com.example.challengecup;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

public class MainFragment extends Fragment {
    private ImageView recordImageView;
    private LinearLayout navigationLinearLayout;
    private LinearLayout askHelpLinearLayout;

    public static MainFragment newInstance(Bundle bundle) {
        MainFragment fragment = new MainFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //录音按钮的点击事件设置
        recordImageView = view.findViewById(R.id.iv_record);
        recordImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecordDialogFragment recordFragment = new RecordDialogFragment();
                recordFragment.show(getChildFragmentManager(), "test");
            }
        });

        //导航软件点击事件设置
        navigationLinearLayout = view.findViewById(R.id.linear_navigation);
        navigationLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),NavigationActivity.class);
                startActivity(intent);
            }
        });

        navigationLinearLayout = view.findViewById(R.id.linear_ask_help);
        navigationLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),AskForHelpActivity.class);
                startActivity(intent);
            }
        });


    }
}
