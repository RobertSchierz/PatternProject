package com.example.patternproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.patternproject.listfragments.CodeFragment;
import com.example.patternproject.listfragments.ExampleFragment;
import com.example.patternproject.listfragments.ExplainFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class ListItemActivity extends FragmentActivity  {

    private static final String TAG = "ListItemActivity";

    private ArrayList<TutorialListItems> items = new ArrayList<TutorialListItems>();




    public ListItemActivity() {
        items.add(new TutorialListItems("Bubble Sort", new BubbleSortFragment()));
        items.add(new TutorialListItems("Singleton Pattern", new SingletonPatternFragment()));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listitem);




        Intent intent = getIntent();
        int position = intent.getIntExtra("itemPosition", 0);
        final String itemName = intent.getStringExtra("itemName");
        final AtomicBoolean isIn = new AtomicBoolean(false);

        items.forEach(new Consumer<TutorialListItems>() {
            @Override
            public void accept(TutorialListItems item) {
                if(item.itemName.equals(itemName)){
                    Fragment fragment = item.fragmentClass;
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction transaction = fm.beginTransaction();
                    transaction.replace(R.id.contentFragment, fragment);
                    transaction.commit();
                    isIn.set(true);

                }
            }
        });

        if(!isIn.get()){
            Toast.makeText(this, "Element existiert nicht", Toast.LENGTH_SHORT).show();
        }




        Log.d(TAG, "Activity created: " + position);
    }


}

class TutorialListItems{
    String itemName;
    Fragment fragmentClass;


    public TutorialListItems(String itemName, Fragment fragmentClass) {
        this.itemName = itemName;
        this.fragmentClass = fragmentClass;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Fragment getFragmentClass() {
        return fragmentClass;
    }

    public void setFragmentClass(Fragment fragmentClass) {
        this.fragmentClass = fragmentClass;
    }
}
