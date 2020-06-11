package com.example.patternproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;



public class PatternlistAdapter extends RecyclerView.Adapter<PatternlistAdapter.ViewHolder>{

    private static final String TAG = "PatternlistAdapter";

    private ArrayList<String> mPatternNames = new ArrayList<>();
    private ArrayList<Integer> mPatternImages = new ArrayList<>();
    private Context mContext;

    public PatternlistAdapter(ArrayList<String> mPatternImageNames, ArrayList<Integer> mPatternImages, Context mContext) {
        this.mPatternNames = mPatternImageNames;
        this.mPatternImages = mPatternImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_patternlistitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
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

        holder.patternListLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "clicked on " + mPatternNames.get(position));
                Toast.makeText(mContext, mPatternNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPatternNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView imageName;
        RelativeLayout patternListLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            patternListLayout = itemView.findViewById(R.id.patternlist_layout);
        }
    }
}
