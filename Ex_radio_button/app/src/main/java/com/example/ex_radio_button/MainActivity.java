package com.example.ex_radio_button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String s_sex = new String();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildView();

    }

    private void buildView() {

        // Register RadioGroup for listening which button user checks.
        RadioGroup rg_sex = (RadioGroup)findViewById(R.id.rgId_sex);
        rg_sex.setOnCheckedChangeListener(rg_sex_listner);

        // Register Button
        Button bt_confirm = (Button)findViewById(R.id.btId_confirm);
        bt_confirm.setOnClickListener(bt_listener);
    }

    private OnCheckedChangeListener rg_sex_listner = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            //Get sex info that input by user.
            if (checkedId==R.id.rbId_male) s_sex = "male";
            else s_sex = "female";
        }
    };

    private OnClickListener bt_listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            logingEvent();
        }
    };

    private void logingEvent() {
        // Check if Login info got,
        // if true, jump to LogSucActivity by intent
        // else, Display toast message that prompt user to input Login info.

        EditText et_name = (EditText)findViewById(R.id.editTextTextPersonName);

        String s_et_name = et_name.getText().toString();

        if ((!(s_et_name.equals(""))) && (s_sex.equals("male") || s_sex.equals(("female")))){

            passDataWithBundle();
        }
        else {
            // Make toast-text on MainActivity
            Toast.makeText( MainActivity.this,
                    "Login fail...Your input info may be incorrect",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    private void passDataWithBundle() {

        // Get data from EditText.
        EditText et_name = (EditText)findViewById(R.id.editTextTextPersonName);

        // Construct intent to open LogSucActivity.
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, LogSucActivity.class );

        // Construct bundle to pass data
        Bundle bundle = new Bundle();
        bundle.putString("user_name", et_name.getText().toString());
        bundle.putString("user_sex", s_sex);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}