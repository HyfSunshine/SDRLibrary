package com.sdr.sdrlib.ui.lazyfragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sdr.lib.base.BaseFragment;
import com.sdr.sdrlib.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HyFun on 2018/11/06.
 * Email:775183940@qq.com
 */

@SuppressLint("ValidFragment")
public class LazyFragment extends BaseFragment {
    private String title;

    public LazyFragment(String title) {
        this.title = title;
    }

    @BindView(R.id.lazy_fragment_swipe)
    SwipeRefreshLayout swipe;
    @BindView(R.id.lazy_fragment_textview)
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lazy_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        if (isVisible) {

        }
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        // 加载数据
        swipe.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipe.setRefreshing(false);
                textView.setText(title);
            }
        }, 1000);
    }
}
