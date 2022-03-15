package com.example.challengecup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SoundAndEducationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_and_education);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        TextView titleTextView = findViewById(R.id.tv_title);
        titleTextView.setText(title);
        RecyclerView recyclerView = findViewById(R.id.recycler_study_education);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        StudyAndEducationAdapter adapter = new StudyAndEducationAdapter(this, initData(title));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private List<StudyAndEducationItem> initData(String title) {
        List<StudyAndEducationItem> studyAndEducationItems = new ArrayList<>();
        String titles[];
        String contents[];
        int imgSources[];
        switch (title) {
            case "盲人电影":
                titles = new String[]{"今天搞按摩", "今天搞按摩", "今天搞按摩", "今天搞按摩",
                        "今天搞按摩", "今天搞按摩", "今天搞按摩", "今天搞按摩"};
                contents = new String[]{"今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了"
                        , "今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了"};
                imgSources = new int[]{R.drawable.sex, R.drawable.sex, R.drawable.sex,
                        R.drawable.sex, R.drawable.sex, R.drawable.sex, R.drawable.sex, R.drawable.sex};
                break;
            case "直播电台":
                titles = new String[]{"今天搞按摩", "今天搞按摩", "今天搞按摩", "今天搞按摩",
                        "今天搞按摩", "今天搞按摩", "今天搞按摩", "今天搞按摩"};
                contents = new String[]{"今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了"
                        , "今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了"};
                imgSources = new int[]{R.drawable.sex, R.drawable.sex, R.drawable.sex,
                        R.drawable.sex, R.drawable.sex, R.drawable.sex, R.drawable.sex, R.drawable.sex};
                break;

            case "盲人教育":
                titles = new String[]{"今天搞按摩", "今天搞按摩", "今天搞按摩", "今天搞按摩",
                        "今天搞按摩", "今天搞按摩", "今天搞按摩", "今天搞按摩"};
                contents = new String[]{"今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了"
                        , "今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了"};
                imgSources = new int[]{R.drawable.sex, R.drawable.sex, R.drawable.sex,
                        R.drawable.sex, R.drawable.sex, R.drawable.sex, R.drawable.sex, R.drawable.sex};
                break;
            case "有声读物":
                titles = new String[]{"今天搞按摩", "今天搞按摩", "今天搞按摩", "今天搞按摩",
                        "今天搞按摩", "今天搞按摩", "今天搞按摩", "今天搞按摩"};
                contents = new String[]{"今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了"
                        , "今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了", "今天按摩搞舒服了"};
                imgSources = new int[]{R.drawable.sex, R.drawable.sex, R.drawable.sex,
                        R.drawable.sex, R.drawable.sex, R.drawable.sex, R.drawable.sex, R.drawable.sex};
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + title);
        }
        for (int i = 0; i < titles.length; i++) {
            studyAndEducationItems.add(new StudyAndEducationItem(titles[i], contents[i], imgSources[i]));
        }
        return studyAndEducationItems;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return true;
    }
}