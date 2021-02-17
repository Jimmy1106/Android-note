package com.example.ex_mvc_button_toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//public class MainActivity extends Activity {
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
    private OnClickListener bt_listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            DisplayWelcomeMessageOnToast();
        }
    };
    private OnKeyListener et_sex_listener = new OnKeyListener() {
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