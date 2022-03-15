package com.example.challengecup;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by cnrobin on 17-8-1.
 * Just Enjoy It!!!
 */

public class AskForHelpAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<AskHelpItem> itemList;

    public AskForHelpAdapter(Context mContext, List itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_ask_help_item, parent, false);
        return new AskHelpItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((AskHelpItemHolder) holder).textView.setText(itemList.get(position).getContext());
        ((AskHelpItemHolder) holder).imageView.setImageResource(itemList.get(position).getSourceImg());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    static class AskHelpItemHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public View view;

        public AskHelpItemHolder(View itemView) {
            super(itemView);
            view = itemView;
            imageView = itemView.findViewById(R.id.iv_help_img);
            textView = itemView.findViewById(R.id.tv_help_context);
        }
    }
}
