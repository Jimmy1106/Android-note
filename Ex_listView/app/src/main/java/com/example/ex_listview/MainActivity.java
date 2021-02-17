package com.example.ex_listview;

// Implementing ListView with ListActivity.

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        buildBasicListView();
        buildCustomListView();
    }


    private void buildBasicListView() {

        String [] education_list = {"Doctor", "Master", "Bachelor", "Others"};

        // Get ListView object from view.
        ListView lv_education = getListView();

        // Create Adapter.
        ArrayAdapter<CharSequence> adpt_education = new ArrayAdapter<CharSequence>(
                this, android.R.layout.simple_list_item_1, education_list
        );

        // Combine Adapter and ListView.
        setListAdapter(adpt_education);

        // Register view obejct to listener.
        lv_education.setOnItemClickListener(lv_education_listener);

    }

    private OnItemClickListener lv_education_listener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Toast education msg on the screen

            String msg = ((TextView)view).getText().toString();
            Toast.makeText(
                    MainActivity.this,
                    "Your education: "+msg,
                    Toast.LENGTH_SHORT
            ).show();
        }
    };

    private void buildCustomListView() {
        // Build ListView with custom View layout.

        // Create string list for txtView.
        String [] education_list = {"Doctor", "Master", "Bachelor", "Others"};

        // Create img resource list for imgView.
        int [] imgView_id_list = {
                R.drawable.edu_doctor, R.drawable.edu_master, R.drawable.edu_bachelor,R.drawable.edu_others
        };

        // Create a map list to store ListView items.
        List<Map<String,Object>> map_list = new ArrayList<Map<String, Object>>();

        for (int i=0; i<education_list.length; i++){
            // Make each item that Adapter requires.

            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imgView", imgView_id_list[i]);
            item.put("txtView", education_list[i]);
            map_list.add(item);
        }

        // Build custom Adapter with SimpleAdapter.
        SimpleAdapter adpt_education = new SimpleAdapter(
                this,
                map_list,
                R.layout.list_item,
                new String[] {"imgView", "txtView"},
                new int[] {R.id.ivId_Edu,R.id.tvId_edu}
        );

        // Get ListView object.
        ListView lv_edu = getListView();

        // Combine Adapter and ListView.
        lv_edu.setAdapter(adpt_education);

        // Register view object to listener.
        lv_edu.setOnItemClickListener(lv_custom_edu_listener);
    }

    private OnItemClickListener lv_custom_edu_listener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Toast education msg on the screen

            String msg = ((TextView)view.findViewById(R.id.tvId_edu)).getText().toString();
            Toast.makeText(
                    MainActivity.this,
                    "Your education: "+msg,
                    Toast.LENGTH_SHORT
            ).show();
        }
    };

}