package com.example.patternproject.listitemscontent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.patternproject.R;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.highlight.ColorTheme;
import io.github.kbiakov.codeview.highlight.Font;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BubbleSortCodeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BubbleSortCodeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BubbleSortCodeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CodeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BubbleSortCodeFragment newInstance(String param1, String param2) {
        BubbleSortCodeFragment fragment = new BubbleSortCodeFragment();
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

        View view = inflater.inflate(R.layout.bubble_sort_fragment_code, container, false);
        CodeView bubbleCodeView = (CodeView) view.findViewById(R.id.bubblesort_codecontent);

        bubbleCodeView.setCode(getString(R.string.bubblesortcodecontent));
        bubbleCodeView.getOptions()
                .withLanguage("java")
                .withFont(Font.Consolas)
                .withTheme(ColorTheme.SOLARIZED_LIGHT)
                .withShadows();

        return view;
    }
}