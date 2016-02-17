package com.koudle.navigationbar;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by koudel on 16/2/17.
 */
public class SampleFragment extends Fragment {

    public final static String TAG = "SampleFragment";
    private static int index = 0 ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sample,null);
        TextView textView = (TextView) view.findViewById(R.id.sampleText);
        textView.setText(String.valueOf(index));
        index++;
        return view;
    }
}
