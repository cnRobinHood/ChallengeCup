package com.example.challengecup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudyAndEducationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<StudyAndEducationItem> itemList;

    public StudyAndEducationAdapter(Context mContext, List itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_study_education, parent, false);
        return new StudyItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((StudyItemHolder) holder).titleView.setText(itemList.get(position).getTitle());
        ((StudyItemHolder) holder).contentView.setText(itemList.get(position).getContent());
        ((StudyItemHolder) holder).imageView.setImageResource(itemList.get(position).getImgSource());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    static class StudyItemHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleView;
        public TextView contentView;
        public View view;

        public StudyItemHolder(View itemView) {
            super(itemView);
            view = itemView;
            imageView = itemView.findViewById(R.id.iv_img);
            titleView = itemView.findViewById(R.id.tv_title);
            contentView = itemView.findViewById(R.id.tv_context);
        }
    }
}
