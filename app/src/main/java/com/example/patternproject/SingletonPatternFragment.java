package com.example.patternproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.patternproject.listfragments.CodeFragment;
import com.example.patternproject.listfragments.ExampleFragment;
import com.example.patternproject.listfragments.ExplainFragment;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SingletonPatternFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingletonPatternFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private ExplainFragment explainFragment;
    private CodeFragment codeFragment;
    private ExampleFragment exampleFragment;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SingletonPatternFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SingletonPatternFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SingletonPatternFragment newInstance(String param1, String param2) {
        SingletonPatternFragment fragment = new SingletonPatternFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bubble_sort, container, false);

        viewPager = view.findViewById(R.id.fragmentviewpager);
        tabLayout = view.findViewById(R.id.fragmenttablayout);

        explainFragment = new ExplainFragment();
        codeFragment =  new CodeFragment();
        exampleFragment = new ExampleFragment();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager(), 0);

        viewPager.setAdapter(viewPagerAdapter);


        viewPagerAdapter.addFragment(explainFragment, "Erklärung");
        viewPagerAdapter.addFragment(codeFragment, "Code");
        viewPagerAdapter.addFragment(exampleFragment, "Beispiel");



        viewPagerAdapter.notifyDataSetChanged();
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_chat_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_code_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_remove_red_eye_24);

        TextView header = (TextView)view.findViewById(R.id.list_item_header_text);
        header.setText(R.string.singletonPatternHeader);


        // Inflate the layout for this fragment
        return view;
    }
}