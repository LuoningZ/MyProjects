package com.gy.limguide.manager;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class GuideTwoFragment extends BaseFragment {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    MultipleItemQuickAdapter adapter;

    List<MultipleItem> datas=new ArrayList<>();

    @Override
    protected int onSetContentView() {
        return R.layout.layout_guide_two;
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
                startActivity(intent);
            }
        });

        recyclerview.setAdapter(adapter);
    }

    private void getDatas(){

        datas.add(getItem("租房公告","2017年10月18日","https://www.0086.ie/discussion/fang-wu-zhao-zu/zu-fang-gong-gao"));
        datas.add(getItem("想要租房？新岛民宿可以给你一个温暖的家","2017年10月25日","https://www.0086.ie/discussion/fang-wu-zhao-zu/xiang-yao-zu-fang-xin-dao-min-su-ke-yi-gei-ni-yi-ge-wen-nuan-de-jia"));
        datas.add(getItem("Maynooth 附近双人间出租","2018.8.5","https://www.0086.ie/discussion/fang-wu-zhao-zu/maynooth-fu-jin-shuang-ren-jian-chu-zu"));
        datas.add(getItem("【短租】都柏林一区一个月短租","2018.8.17"," https://www.0086.ie/discussion/fang-wu-zhao-zu/duan-zu-du-bo-lin-yi-qu-yi-ge-yue-duan-zu"));
        datas.add(getItem("找房找不到？先来个短租吧！","2018.8.16","https://www.0086.ie/discussion/fang-wu-zhao-zu/zhao-fang-zhao-bu-dao-xian-lai-ge-duan-zu-ba"));
        datas.add(getItem("Newbridge 有一个干净舒适的双人间出租","2018.7.27","https://www.0086.ie/discussion/fang-wu-zhao-zu/newbridge-you-yi-ge-gan-jing-shu-gua-de-shuang-ren-jian-chu-zu"));

    }

    private MultipleItem getItem(String title,String data,String url){
        MultipleItem multipleItem=new MultipleItem(2);
        multipleItem.setTitle(title);
        multipleItem.setData(data);
        multipleItem.setUrl(url);
        return multipleItem;
    }
}
