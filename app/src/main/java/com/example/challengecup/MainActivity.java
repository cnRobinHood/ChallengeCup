package com.example.challengecup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

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
        checkReadPermission(Manifest.permission.CALL_PHONE, REQUEST_CALL_PERMISSION);
        checkReadPermission(Manifest.permission.CAMERA, REQUEST_CALL_PERMISSION);
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
        String[] studyFuncTitle = new String[]{"设置", "淘宝", "闹钟", "检测心率", "直播电台", "有声读物", "盲人教育", "盲人电影"};
        int[] studyFuncIconSource = new int[]{R.drawable.setting, R.drawable.taobao, R.drawable.alarm,
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
    public static final int REQUEST_CALL_PERMISSION = 10111; //拨号请求码

    /**
     * 判断是否有某项权限
     * @param string_permission 权限
     * @param request_code 请求码
     * @return
     */
    public boolean checkReadPermission(String string_permission,int request_code) {
        boolean flag = false;
        if (ContextCompat.checkSelfPermission(this, string_permission) == PackageManager.PERMISSION_GRANTED) {//已有权限
            flag = true;
        } else {//申请权限
            ActivityCompat.requestPermissions(this, new String[]{string_permission}, request_code);
        }
        return flag;
    }




    /**
     * 检查权限后的回调
     * @param requestCode 请求码
     * @param permissions  权限
     * @param grantResults 结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CALL_PERMISSION: //拨打电话
                if (permissions.length != 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {//失败
                    Toast.makeText(this, "请允许拨号权限", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}