package com.example.ex_activity_bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//public class LogSucActivity extends Activity {
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

    }
}