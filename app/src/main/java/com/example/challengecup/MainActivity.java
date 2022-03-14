package com.example.challengecup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Functions> studyFunctions;
    private List<Functions> communicateFunctions;
    ArrayList<Fragment> fragments;
    private ViewPager viewPager;
    public static final int PAGES = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studyFunctions = new ArrayList<>();
        communicateFunctions = new ArrayList<>();
        initStudyFunctions(studyFunctions);
        initCommunicateFunctions(communicateFunctions);
        viewPager = findViewById(R.id.viewpager);
        fragments = new ArrayList<>();
        initFragment();
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(PAGES);

    }

    private void initFragment() {
        fragments.add(new MainFragment());
        fragments.add(new StudyAndCommunicateFragment(studyFunctions));
        fragments.add(new StudyAndCommunicateFragment(communicateFunctions));
    }

    private void initStudyFunctions(List<Functions> list) {
        String[] studyFuncTitle = new String[]{"设置", "滴滴打车", "闹钟", "检测心率", "直播电台", "有声读物", "盲人教育", "盲人电影"};
        int[] studyFuncIconSource = new int[]{R.drawable.setting, R.drawable.taxi, R.drawable.alarm,
                R.drawable.heartrate, R.drawable.station, R.drawable.book, R.drawable.education, R.drawable.film};
        for (int i = 0; i < studyFuncTitle.length; i++) {
            list.add(new Functions(studyFuncTitle[i], studyFuncIconSource[i]));
        }
    }

    private void initCommunicateFunctions(List<Functions> list) {
        String[] communicateFuncTitle = new String[]{"亲人1", "亲人2", "朋友1", "朋友2", "QQ", "QQ视频", "微信聊天", "微信视频"};
        int[] communicateFuncIconSource = new int[]{R.drawable.contact, R.drawable.contact, R.drawable.contact,
                R.drawable.contact, R.drawable.qq, R.drawable.video, R.drawable.wechat, R.drawable.video};
        for (int i = 0; i < communicateFuncTitle.length; i++) {
            list.add(new Functions(communicateFuncTitle[i], communicateFuncIconSource[i]));
        }
    }
}