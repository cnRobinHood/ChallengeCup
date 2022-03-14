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

public class StudyAndCommunicateAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Functions> functions;
    private Context context;


    public StudyAndCommunicateAdapter(List<Functions> functions,Context context) {
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ItemHolder) holder).itemText.setText(functions.get(position).getFuncName());
        ((ItemHolder) holder).itemImg.setImageResource(functions.get(position).getFuncIconSource());
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
