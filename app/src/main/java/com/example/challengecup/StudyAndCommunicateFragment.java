package com.example.challengecup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudyAndCommunicateFragment extends Fragment {
    private List<Functions> functions;

    public StudyAndCommunicateFragment(List<Functions> functions) {
        this.functions = functions;
    }

    public StudyAndCommunicateFragment() {
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_study_communicate, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        StudyAndCommunicateAdapter studyAndCommunicateAdapter = new StudyAndCommunicateAdapter(functions,getContext());
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(studyAndCommunicateAdapter);
    }
}
