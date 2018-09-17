package com.gy.limguide.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gy.limguide.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.login)
    Button login;

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.passsword)
    EditText passsword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.layout_login_activity);
        ButterKnife.bind(this);

    }

     @OnClick({
             R.id.login
     } )
    @Override
    public void onClick(View view) {
         switch (view.getId()){
             case R.id.login:
                 String origin = name.getText().toString();
                 String destination = passsword.getText().toString();
                 if (origin.isEmpty()) {
                     Toast.makeText(this, "Please enter email!", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if (destination.isEmpty()) {
                     Toast.makeText(this, "Please enter password!", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 Intent intent=new Intent();
                 intent.putExtra("name",origin);
                 setResult(200,intent);
                 finish();
                 break;
         }
    }
}
