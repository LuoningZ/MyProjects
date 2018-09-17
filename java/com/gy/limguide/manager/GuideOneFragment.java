package com.gy.limguide.manager;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gy.limguide.R;
import com.gy.limguide.activities.DetailsActivity;
import com.gy.limguide.adapter.MultipleItemQuickAdapter;
import com.gy.limguide.bean.MultipleItem;
import com.gy.limguide.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GuideOneFragment extends BaseFragment {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    MultipleItemQuickAdapter adapter;

    List<MultipleItem> datas=new ArrayList<>();
    @Override
    protected int onSetContentView() {
        return R.layout.layout_guide_one;
    }

    @Override
    protected void onInitData() {
        getDatas();
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new MultipleItemQuickAdapter(datas);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent=new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("url",datas.get(position).getUrl());
                startActivity(intent);
            }
        });
        recyclerview.setAdapter(adapter);
    }

    private void getDatas(){
        datas.add( getItem("究竟是什么特别的节日让40万游客蜂拥而至来到这个小镇？","August 14, 2018","https://www.0086.ie/single-post/2018/08/14/%E7%A9%B6%E7%AB%9F%E6%98%AF%E4%BB%80%E4%B9%88%E7%89%B9%E5%88%AB%E7%9A%84%E8%8A%82%E6%97%A5%E8%AE%A940%E4%B8%87%E6%B8%B8%E5%AE%A2%E8%9C%82%E6%8B%A5%E8%80%8C%E8%87%B3%E6%9D%A5%E5%88%B0%E8%BF%99%E4%B8%AA%E5%B0%8F%E9%95%87%EF%BC%9F"));
        datas.add(getItem("都柏林最著名雕塑之一Molly Malone马上就会说话啦！","August 19, 2018   罐子","https://www.0086.ie/single-post/2018/08/19/%E9%83%BD%E6%9F%8F%E6%9E%97%E6%9C%80%E8%91%97%E5%90%8D%E9%9B%95%E5%A1%91%E4%B9%8B%E4%B8%80Molly-Malone%E9%A9%AC%E4%B8%8A%E5%B0%B1%E4%BC%9A%E8%AF%B4%E8%AF%9D%E5%95%A6%EF%BC%81"));
        datas.add(getItem("如果来到爱尔兰没尝过这道菜，白瞎漂洋过海来了一趟","August 16, 2018   十酒","https://www.0086.ie/single-post/2018/08/16/%E5%A6%82%E6%9E%9C%E6%9D%A5%E5%88%B0%E7%88%B1%E5%B0%94%E5%85%B0%E6%B2%A1%E5%B0%9D%E8%BF%87%E8%BF%99%E9%81%93%E8%8F%9C%EF%BC%8C%E7%99%BD%E7%9E%8E%E6%BC%82%E6%B4%8B%E8%BF%87%E6%B5%B7%E6%9D%A5%E4%BA%86%E4%B8%80%E8%B6%9F "));
        datas.add(getItem("邀你一起玩转爱尔兰古董市场，本周日咱们不见不散！","August 16, 2018   十酒","https://www.0086.ie/single-post/2018/08/14/%E7%A9%B6%E7%AB%9F%E6%98%AF%E4%BB%80%E4%B9%88%E7%89%B9%E5%88%AB%E7%9A%84%E8%8A%82%E6%97%A5%E8%AE%A940%E4%B8%87%E6%B8%B8%E5%AE%A2%E8%9C%82%E6%8B%A5%E8%80%8C%E8%87%B3%E6%9D%A5%E5%88%B0%E8%BF%99%E4%B8%AA%E5%B0%8F%E9%95%87%EF%BC%9F"));
        datas.add(getItem("Wicklow海滩垃圾堆积如山，急需大家加入志愿者行列","July 8, 2018    继熙","https://www.0086.ie/single-post/2018/07/08/Wicklow%E6%B5%B7%E6%BB%A9%E5%9E%83%E5%9C%BE%E5%A0%86%E7%A7%AF%E5%A6%82%E5%B1%B1%EF%BC%8C%E6%80%A5%E9%9C%80%E5%A4%A7%E5%AE%B6%E5%8A%A0%E5%85%A5%E5%BF%97%E6%84%BF%E8%80%85%E8%A1%8C%E5%88%97"));
        datas.add(getItem("爱尔兰旅游局首席代表上演“冰与火之歌”,为爱岛“荧幕旅游”打Call","July 8, 2018","https://www.0086.ie/single-post/2018/07/08/%E7%88%B1%E5%B0%94%E5%85%B0%E6%97%85%E6%B8%B8%E5%B1%80%E9%A6%96%E5%B8%AD%E4%BB%A3%E8%A1%A8%E4%B8%8A%E6%BC%94%E2%80%9C%E5%86%B0%E4%B8%8E%E7%81%AB%E4%B9%8B%E6%AD%8C%E2%80%9D%E4%B8%BA%E7%88%B1%E5%B2%9B%E2%80%9C%E8%8D%A7%E5%B9%95%E6%97%85%E6%B8%B8%E2%80%9D%E6%89%93Call"));
        datas.add(getItem(" Facebook与爱尔兰警局最新合作——齐心协力寻找被拐儿童","June 28, 2018    ZhiYi","https://www.0086.ie/single-post/2018/06/28/Facebook%E4%B8%8E%E7%88%B1%E5%B0%94%E5%85%B0%E8%AD%A6%E5%B1%80%E6%9C%80%E6%96%B0%E5%90%88%E4%BD%9C%E2%80%94%E2%80%94%E9%BD%90%E5%BF%83%E5%8D%8F%E5%8A%9B%E5%AF%BB%E6%89%BE%E8%A2%AB%E6%8B%90%E5%84%BF%E7%AB%A5"));
        datas.add(getItem(" 一年一度的都柏林美食节又回来啦！这可是爱尔兰人最期待的节目之一！","June 14, 2018"," https://www.0086.ie/single-post/2018/06/14/%E4%B8%80%E5%B9%B4%E4%B8%80%E5%BA%A6%E7%9A%84%E9%83%BD%E6%9F%8F%E6%9E%97%E7%BE%8E%E9%A3%9F%E8%8A%82%E5%8F%88%E5%9B%9E%E6%9D%A5%E5%95%A6%EF%BC%81%E8%BF%99%E5%8F%AF%E6%98%AF%E7%88%B1%E5%B0%94%E5%85%B0%E4%BA%BA%E6%9C%80%E6%9C%9F%E5%BE%85%E7%9A%84%E8%8A%82%E7%9B%AE%E4%B9%8B%E4%B8%80%EF%BC%81"));
    }

    private MultipleItem getItem(String title,String data,String url){
        MultipleItem multipleItem=new MultipleItem(2);
        multipleItem.setTitle(title);
        multipleItem.setData(data);
        multipleItem.setUrl(url);
        return multipleItem;
    }
}
