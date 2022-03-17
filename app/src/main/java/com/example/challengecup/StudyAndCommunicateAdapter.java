package com.example.challengecup;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudyAndCommunicateAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Functions> functions;
    private Context context;


    public StudyAndCommunicateAdapter(List<Functions> functions, Context context) {
        super();
        this.functions = functions;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ((ItemHolder) holder).itemText.setText(functions.get(position).getFuncName());
        switch (functions.get(position).getFuncName()) {
            case "滴滴打车":
                ((ItemHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, TaxiActivity.class);
                        context.startActivity(intent);
                    }
                });
                break;
            case "直播电台":
            case "有声读物":
            case "盲人教育":
            case "盲人电影":
                ((ItemHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, SoundAndEducationActivity.class);
                        intent.putExtra("title", functions.get(position).getFuncName());
                        context.startActivity(intent);
                    }
                });
                break;
            case "亲人1":
            case "亲人2":
            case "朋友1":
            case "朋友2":
                ((ItemHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        Uri data = Uri.parse("tel:" + "17623223423");
                        intent.setData(data);
                        context.startActivity(intent);
                    }
                });
                break;
            case "QQ":
            case "QQ视频":
                ((ItemHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent();
                        ComponentName cmp =new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.SplashActivity");
                        intent.setAction(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_LAUNCHER);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setComponent(cmp);
                        context.startActivity(intent);
                    }
                });
                break;
            case "微信聊天":
            case "微信视频":
                ((ItemHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        ComponentName cmp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
                        intent.setAction(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_LAUNCHER);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setComponent(cmp);
                        context.startActivity(intent);

                    }
                });
                break;


        }
        ((ItemHolder) holder).itemImg.setImageResource(functions.get(position).getFuncIconSource());
    }
    private void totianmao( String tbPath){

    }

    @Override
    public int getItemCount() {
        return functions.size();
    }

    static class ItemHolder extends RecyclerView.ViewHolder {
        TextView itemText;
        ImageView itemImg;

        public ItemHolder(View itemView) {
            super(itemView);
            itemImg = itemView.findViewById(R.id.icon_image);
            itemText = itemView.findViewById(R.id.icon_title);

        }
    }
}
