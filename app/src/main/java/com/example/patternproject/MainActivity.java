package com.example.patternproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mPatternNames = new ArrayList<>();
    private ArrayList<Integer> mPatternImagePaths = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "oncreate started.");

        initImageBitmaps();


    }

    private void initImageBitmaps(){

        mPatternNames.add("Pattern");
        mPatternImagePaths.add(R.drawable.pattern);

        mPatternNames.add("Bubble Sort");
        mPatternImagePaths.add(R.drawable.algorithm);

        mPatternNames.add("Insertion Sort");
        mPatternImagePaths.add(R.drawable.algorithm);

        mPatternNames.add("Selection Sort");
        mPatternImagePaths.add(R.drawable.algorithm);

        mPatternNames.add("Merge Sort");
        mPatternImagePaths.add(R.drawable.algorithm);

        mPatternNames.add("Heapsort Sort");
        mPatternImagePaths.add(R.drawable.algorithm);

        mPatternNames.add("Quicksort Sort");
        mPatternImagePaths.add(R.drawable.algorithm);



        initPatternRecyclerView();
    }

    private void initPatternRecyclerView(){
        Log.d(TAG, "init Patternlist");

        RecyclerView recyclerView = findViewById(R.id.patternlist_recyclerview);
        PatternlistAdapter adapter = new PatternlistAdapter(mPatternNames, mPatternImagePaths, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}