package com.example.patternproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;



public class PatternlistAdapter extends RecyclerView.Adapter<PatternlistAdapter.ViewHolder>{

    private static final String TAG = "PatternlistAdapter";

    private ArrayList<String> mPatternNames = new ArrayList<>();
    private ArrayList<Integer> mPatternImages = new ArrayList<>();
    private Context mContext;
    private OnItemListener mOnItemListener;

    public PatternlistAdapter(ArrayList<String> mPatternImageNames, ArrayList<Integer> mPatternImages, Context mContext, OnItemListener onItemListener) {
        this.mPatternNames = mPatternImageNames;
        this.mPatternImages = mPatternImages;
        this.mContext = mContext;
        this.mOnItemListener = onItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_patternlistitem, parent, false);
        ViewHolder holder = new ViewHolder(view, mOnItemListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mPatternImages.get(position))
                .into(holder.image);

        holder.imageName.setText(mPatternNames.get(position));

        if(position % 2 == 0){
            holder.patternListLayout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.recyclerViewItem));

        }

      /*  holder.patternListLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "clicked on " + mPatternNames.get(position));
                Toast.makeText(mContext, mPatternNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mPatternNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView imageName;
        RelativeLayout patternListLayout;

        OnItemListener onItemListener;


        public ViewHolder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            patternListLayout = itemView.findViewById(R.id.patternlist_layout);
            this.onItemListener = onItemListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClicked(getAdapterPosition());
        }
    }

    public interface OnItemListener {
        void onItemClicked(int position);
    }
}
