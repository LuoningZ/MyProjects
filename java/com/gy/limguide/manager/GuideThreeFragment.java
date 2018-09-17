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

public class GuideThreeFragment extends BaseFragment {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    MultipleItemQuickAdapter adapter;

    List<MultipleItem> datas=new ArrayList<>();

    @Override
    protected int onSetContentView() {
        return R.layout.layout_guide_three;
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

        datas.add(getItem("爱尔兰- 宜居绿岛","2018.8.13","https://www.0086.ie/discussion/liu-xue-yi-min/ai-er-lan-yi-ju-lu-dao"));
        datas.add(getItem("05年的学生4号签证信丢了区那申请新的","2018.5.24","https://www.0086.ie/discussion/liu-xue-yi-min/05-nian-de-xue-sheng-4-hao-qian-zheng-xin-diu-liao-qu-na-shen-qing-xin-de"));
        datas.add(getItem("留学爱尔兰的九大优势","2017.10.13","https://www.0086.ie/discussion/liu-xue-yi-min/liu-xue-ai-er-lan-de-jiu-da-you-shi"));
        datas.add(getItem(" 2017投资移民项目最后一期正在进行","2017.10.17","https://www.0086.ie/discussion/liu-xue-yi-min/2017-tou-zi-yi-min-xiang-mu-zui-hou-yi-qi-zheng-zai-jin-xing-jin-sheng-3-ge-ming-e"));
        datas.add(getItem("“移民界黑马”——爱尔兰","2018.8.12","https://www.0086.ie/discussion/liu-xue-yi-min/yi-min-jie-hei-ma-ai-er-lan"));

    }
    private MultipleItem getItem(String title,String data,String url){
        MultipleItem multipleItem=new MultipleItem(2);
        multipleItem.setTitle(title);
        multipleItem.setData(data);
        multipleItem.setUrl(url);
        return multipleItem;
    }
}
