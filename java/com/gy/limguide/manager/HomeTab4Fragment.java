package com.gy.limguide.manager;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.gy.limguide.R;
import com.gy.limguide.activities.LoginActivity;
import com.gy.limguide.fragment.BaseTitleFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeTab4Fragment extends BaseTitleFragment {


    @BindView(R.id.name)
    TextView name;

    @Override
    protected int onSetContentView() {
        return R.layout.fragment_home_tab4;
    }

    @Override
    protected void onInitData() {

        setTitle(0,"我的信息Account",0);

    }

    @OnClick({
            R.id.login_out
    })
    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.login_out:
                Intent intent=new Intent(getContext(), LoginActivity.class);
                startActivityForResult(intent,200);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==200){
            String aaa=data.getStringExtra("name");
            name.setText(aaa);
        }
    }
}
