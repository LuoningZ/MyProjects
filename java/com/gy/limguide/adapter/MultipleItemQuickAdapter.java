package com.gy.limguide.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gy.limguide.R;
import com.gy.limguide.bean.MultipleItem;

import java.util.List;

public class MultipleItemQuickAdapter  extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultipleItemQuickAdapter(List<MultipleItem> data) {
        super(data);
        addItemType(MultipleItem.one, R.layout.layout_guide_item_one);
        addItemType(MultipleItem.two, R.layout.layout_guide_item_two);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {

        if (item.getItemType()==MultipleItem.two){
          helper.setText(R.id.title,item.getTitle());
          helper.setText(R.id.data,item.getData());
        }
    }
}
