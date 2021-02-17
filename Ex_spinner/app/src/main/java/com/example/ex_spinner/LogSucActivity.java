package com.example.ex_spinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LogSucActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_suc);

        buildView();
    }

    private void buildView() {

        buildWelcomeMessage();
    }

    private void buildWelcomeMessage() {
        // Get data from bundle and Display it with TextView.

        // Get data with getExtras() method.
        Bundle bundle = this.getIntent().getExtras();
        String user_name = bundle.getString("user_name");
        String user_sex = bundle.getString("user_sex");

        // Say Hello to user with a  TextView.
        TextView tv_helloUser = (TextView)findViewById(R.id.tvIDHelloUser);

        if (user_sex.equals("male")) tv_helloUser.setText("Hello, Mr."+user_name+".");
        else if (user_sex.equals("female")) tv_helloUser.setText("Hello, Ms."+user_name+".");
        else tv_helloUser.setText("Hello, user.");

        // Build a button which allows user to set up personal information.
        Button bt_personal_info = (Button)findViewById(R.id.btId_personalInfo);
        bt_personal_info.setOnClickListener(bt_pInfo_listner);

    }

    private OnClickListener bt_pInfo_listner = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(LogSucActivity.this, PersonalInfo.class);
            startActivity(intent);
        }
    };
}