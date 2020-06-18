package com.example.patternproject;

import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.patternproject.listitemscontent.BubbleSortCodeFragment;
import com.example.patternproject.listitemscontent.BubbleSortExampleFragment;
import com.example.patternproject.listitemscontent.BubbleSortExplainFragment;
import com.google.android.material.tabs.TabLayout;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.Format;
import io.github.kbiakov.codeview.highlight.ColorTheme;
import io.github.kbiakov.codeview.highlight.Font;

import static android.provider.Settings.Secure.getString;

public class Helperclass {

    public static void setCodeView(View view, int codeViewId, String codeContent){
        CodeView bubbleCodeView = (CodeView) view.findViewById(codeViewId);

        bubbleCodeView.setCode(codeContent);
        bubbleCodeView.getOptions()
                .withLanguage("java")
                .withFont(Font.Consolas)
                .withTheme(ColorTheme.SOLARIZED_LIGHT)
                .withShadows()
                .withFormat(Format.Default.getCompact())
                .setAnimateOnHighlight(true);

    }

    public static <T> void setTabView(View view, FragmentManager fragmentManager, String headerString, T tab1, T tab2, T tab3){
        ViewPager viewPager;
        TabLayout tabLayout;

        viewPager = view.findViewById(R.id.fragmentviewpager);
        tabLayout = view.findViewById(R.id.fragmenttablayout);


        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(fragmentManager, 0);

        viewPager.setAdapter(viewPagerAdapter);


        viewPagerAdapter.addFragment((Fragment) tab1, "Erklärung");
        viewPagerAdapter.addFragment((Fragment) tab2, "Code");
        viewPagerAdapter.addFragment((Fragment) tab3, "Beispiel");



        viewPagerAdapter.notifyDataSetChanged();
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_chat_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_code_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_remove_red_eye_24);

        TextView header = (TextView)view.findViewById(R.id.list_item_header_text);
        header.setText(headerString);

    }

}
