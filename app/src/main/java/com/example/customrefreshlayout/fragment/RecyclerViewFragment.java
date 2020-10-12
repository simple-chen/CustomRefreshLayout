package com.example.customrefreshlayout.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customrefreshlayout.R;
import com.example.customrefreshlayout.adapter.FruitAdapter;
import com.example.customrefreshlayout.view.CustomRefreshRecyclerLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by chenlp
 * @date 2020/10/10
 * @describe
 */
public class RecyclerViewFragment extends Fragment {

    private Context mContext;
    private FruitAdapter mFruitAdapter;
    private List<String> mFruitList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private CustomRefreshRecyclerLayout mCustomRefreshLayout;

    public RecyclerViewFragment(Context context) {
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_pager_recycler, container, false);
        initView(view);
        initFruitData();
        mFruitAdapter.addFruitData(mFruitList);
        initListener();
        return view;
    }


    private void initListener() {
        mCustomRefreshLayout.setOnRefreshListener(new CustomRefreshRecyclerLayout.OnRefreshListener() {
            @Override
            public void downRefresh() {
                mFruitList.add(0, "下拉刷新的pig");
                mFruitAdapter.addFruitData(mFruitList);
            }

            @Override
            public void upRefresh() {
                mFruitList.add("上拉加载的banana");
                mFruitAdapter.addFruitData(mFruitList);
                mRecyclerView.scrollToPosition(mFruitList.size() - 1);
                mFruitAdapter.notifyDataSetChanged();
            }
        });
    }


    private void initView(View view) {
        mCustomRefreshLayout = view.findViewById(R.id.refresh_recycler_layout);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        mFruitAdapter = new FruitAdapter();
        mRecyclerView.setAdapter(mFruitAdapter);
    }

    private void initFruitData() {
        for (int i = 0; i < 50; i++) {
            mFruitList.add("apple");
        }
    }
}
