package com.example.patternproject;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListItemActivity extends AppCompatActivity {

    private static final String TAG = "ListItemActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Activity created");
    }
}
