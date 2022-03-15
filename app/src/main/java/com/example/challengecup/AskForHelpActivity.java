package com.example.challengecup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class AskForHelpActivity extends AppCompatActivity {
    List<AskHelpItem> askHelpItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_for_help);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        askHelpItemList = new ArrayList<>();
        AskForHelpAdapter adapter = new AskForHelpAdapter(this, askHelpItemList);
        initAskHelpItem(askHelpItemList);
        RecyclerView recyclerView = findViewById(R.id.recycler_ask_help);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void initAskHelpItem(List<AskHelpItem> askHelpItemList) {
        String helpContext[] = new String[]{"我是盲人，我需要帮助.我是盲人，我需要帮助.我是盲人，我需要帮助",
                "我是盲人，我需要过马路。我是盲人，我需要过马路。我是盲人，我需要过马路"
                , "我是盲人，我需要坐公交车。我是盲人，我需要坐公交车。我是盲人，我需要坐公交车。"
                , "我是盲人，我需要盲人手杖。我是盲人，我需要盲人手杖。我是盲人，我需要盲人手杖。"
                , "我是盲人，我需要吃东西。我是盲人，我需要吃东西。我是盲人，我需要吃东西。"};
        int imgSource[] = new int[]{R.drawable.askhelp, R.drawable.trafficlight, R.drawable.handhelper
                , R.drawable.bus, R.drawable.eat};
        for (int i = 0; i < helpContext.length; i++) {
            askHelpItemList.add(new AskHelpItem(helpContext[i], imgSource[i]));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return true;
    }
}