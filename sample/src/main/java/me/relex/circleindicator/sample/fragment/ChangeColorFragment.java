package me.relex.circleindicator.sample.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.sample.SamplePagerAdapter;
import me.relex.circleindicator.sample.R;

public class ChangeColorFragment extends Fragment {

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample_change_color, container, false);
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ViewPager viewpager = view.findViewById(R.id.viewpager);
        CircleIndicator indicator = view.findViewById(R.id.indicator);
        viewpager.setAdapter(new SamplePagerAdapter());
        indicator.setViewPager(viewpager);
    }
}
