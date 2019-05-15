package com.sdr.lib.base;

import android.support.v4.widget.SwipeRefreshLayout;

/**
 * Created by HyFun on 2018/11/06.
 * Email:775183940@qq.com
 */

abstract class BaseSimpleFragment extends AbstractFragment implements SwipeRefreshLayout.OnRefreshListener {

    @Override
    public void onRefresh() {

    }

    /**
     * 获取title
     *
     * @return
     */
    public String getFragmentTitle() {
        return "";
    }
}