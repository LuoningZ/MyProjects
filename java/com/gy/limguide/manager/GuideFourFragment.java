package com.gy.limguide.manager;

import android.app.ProgressDialog;
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

public class GuideFourFragment extends BaseFragment {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    MultipleItemQuickAdapter adapter;

    List<MultipleItem> datas=new ArrayList<>();


    @Override
    protected int onSetContentView() {
        return R.layout.layout_guide_four;
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
      datas.add(getItem("二手公告","二手公告","https://www.0086.ie/discussion/er-shou-shi-chang/er-shou-gong-gao"));
      datas.add(getItem("出售2017年6月最新版L驾照中文翻译书","2017年10月27日"," https://www.0086.ie/discussion/er-shou-shi-chang/chu-shou-2017-nian-6-yue-zui-xin-ban-l-jia-zhao-zhong-wen-fan-yi-shu"));
      datas.add(getItem("出售宝宝和妈妈用品，有需要的请联系","2018.5.26","https://www.0086.ie/discussion/er-shou-shi-chang/chu-shou-bao-bao-he-ma-ma-yong-pin-you-xu-yao-de-qing-lian-xi"));
      datas.add(getItem("含泪甩卖西服和炒锅","2018.8.10","https://www.0086.ie/discussion/er-shou-shi-chang/han-lei-shuai-mai-xi-fu-he-chao-guo"));
      datas.add(getItem("熔岩灯、巧克力火锅、电饭煲温度传感器","2018.8.7","https://www.0086.ie/discussion/er-shou-shi-chang/rong-yan-deng-qiao-ke-li-huo-guo-dian-fan-bao-wen-du-chuan-gan-qi"));
      datas.add(getItem("含泪甩卖鱼缸及饰品","2018.7.27","https://www.0086.ie/discussion/er-shou-shi-chang/han-lei-shuai-mai-yu-gang-ji-shi-pin"));
    }

    private MultipleItem getItem(String title,String data,String url){
        MultipleItem multipleItem=new MultipleItem(2);
        multipleItem.setTitle(title);
        multipleItem.setData(data);
        multipleItem.setUrl(url);
        return multipleItem;
    }
}
