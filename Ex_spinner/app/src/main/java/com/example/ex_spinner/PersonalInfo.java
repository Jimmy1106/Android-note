package com.example.ex_spinner;


import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PersonalInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info);

        buildView();

    }

    private void buildView() {
        // Build Education spinner for user's basic information.

        // First get spinner object from view.
        Spinner sp_education = (Spinner)findViewById(R.id.spId_education);

        // Create String array for Adapter constructing.
        String [] s_educations = { "Doctor", "Master", "Bachelor", "Others" };

        // Construct an Adapter. (ArrayAdapter)
        ArrayAdapter<String> adpt_education = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                s_educations
        );

        // Set up spinner dropdown-format.
        adpt_education.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Combine AdapterView (spinner) and Adapter.
        sp_education.setAdapter(adpt_education);

        // Register spinner to the listener.
        sp_education.setOnItemSelectedListener(sp_education_listener);
    }

    private OnItemSelectedListener sp_education_listener = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            // Store selected item with a string variable.
            // And display selected item on the spinner or personal-info page.
            // Or toast selected item on the screen.

//            String s_selected_education = parent.getSelectedItem().toString();
//
//            Toast.makeText( PersonalInfo.this,
//                    "Your education: "+s_selected_education,
//                    Toast.LENGTH_LONG
//            ).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
