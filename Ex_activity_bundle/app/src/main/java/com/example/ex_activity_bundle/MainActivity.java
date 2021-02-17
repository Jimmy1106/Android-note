package com.example.ex_activity_bundle;


// Pass data to subActivity with Bundle

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup view on screen.
        buildView();
    }

    private void buildView(){

        // Create button listener.
        //  1. Register our button to listener.
        //  2. Implementing onClick() method.
        Button bt_confirm = (Button)findViewById(R.id.button);
        bt_confirm.setOnClickListener(bt_listener);

        // Create OkKeyListener to confine input to name/sex.
        EditText et_sex = (EditText)findViewById(R.id.editTextTextPersonName3);
        et_sex.setOnKeyListener(et_sex_listener);
    }

    private View.OnClickListener bt_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            DisplayWelcomeMessageOnToast();
            logingEvent();
        }
    };

    private void logingEvent() {
        // Check if Login info got,
        // if true, jump to LogSucActivity by intent
        // else, Display toast message that prompt user to input Login info.

        EditText et_name = (EditText)findViewById(R.id.editTextTextPersonName2);
        EditText et_sex = (EditText)findViewById(R.id.editTextTextPersonName3);

        String s_et_name = et_name.getText().toString();
        String s_et_sex = et_sex.getText().toString();

        if ((!(s_et_name.equals(""))) && (s_et_sex.equals("male") || s_et_sex.equals(("female")))){

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
        EditText et_name = (EditText)findViewById(R.id.editTextTextPersonName2);
        EditText et_sex = (EditText)findViewById(R.id.editTextTextPersonName3);

        // Construct intent to open LogSucActivity.
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, LogSucActivity.class );

        // Construct bundle to pass data
        Bundle bundle = new Bundle();
        bundle.putString("user_name", et_name.getText().toString());
        bundle.putString("user_sex", et_sex.getText().toString());
        intent.putExtras(bundle);

        startActivity(intent);
    }


    private View.OnKeyListener et_sex_listener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            // If the event we want appears, returning true.

            EditText et_sex = (EditText)findViewById(R.id.editTextTextPersonName3);
            String s_et_sex = et_sex.getText().toString();

            // If user press enter, checking the correction of input text.
            if(event.getAction() == KeyEvent.ACTION_DOWN &&
                    keyCode == KeyEvent.KEYCODE_ENTER){
                if(!(s_et_sex.equals("male") || s_et_sex.equals("female"))){
                    Toast.makeText(MainActivity.this, "Incorrect input...Try 'male' or 'female.", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
            else return false;
        }
    };

    private void DisplayWelcomeMessageOnToast(){
        // Get required view object as variable
        EditText et_name = (EditText)findViewById(R.id.editTextTextPersonName2);
        EditText et_sex = (EditText)findViewById(R.id.editTextTextPersonName3);

        String s_et_name = et_name.getText().toString();
        String s_et_sex = et_sex.getText().toString();
        String s_toast;

        // Create toast to display welcome-message on screen.
        if (s_et_sex.equals("male")) s_toast = "Hello, Mr. "+s_et_name+"!";
        else if  (s_et_sex.equals("female")) s_toast = "Hello, Ms. "+s_et_name+"!";
        else s_toast = "Hello, somebody!";

        // Make toast-text on MainActivity
        Toast.makeText( MainActivity.this,
                s_toast,
                Toast.LENGTH_SHORT
        ).show();
    }

}