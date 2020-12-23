package me.relex.circleindicator.sample.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import me.relex.circleindicator.CircleIndicator2;
import me.relex.circleindicator.sample.R;
import me.relex.circleindicator.sample.SampleRecyclerAdapter;

public class RecyclerViewFragment extends Fragment {

    private SampleRecyclerAdapter mAdapter;

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample_recycler_view, container, false);
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mAdapter = new SampleRecyclerAdapter(5);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);

        // CircleIndicator2 for RecyclerView
        CircleIndicator2 indicator = view.findViewById(R.id.indicator);
        indicator.attachToRecyclerView(recyclerView, pagerSnapHelper);

        // Scroll To Position
        layoutManager.scrollToPosition(2);

        // Observe Data Change
        mAdapter.registerAdapterDataObserver(indicator.getAdapterDataObserver());
        view.findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mAdapter.add();
            }
        });
        view.findViewById(R.id.remove).setOnClickListener(v -> {
            mAdapter.remove();
        });
    }
}
