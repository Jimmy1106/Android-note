package com.example.android_ui_first_app;

import android.os.Bundle;
import android.app.Activity;
import android.text.Layout;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Construct layout param,
        // and set height and width.
        LayoutParams layout_param;
        layout_param = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        // Create layout object, and then
        // set orientation of the layout.
        LinearLayout l_layout = new LinearLayout(this);
        l_layout.setOrientation(LinearLayout.VERTICAL);

        // Set the layout params of all the components below.
        LayoutParams l_param_small_component;
        l_param_small_component = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        // Construct a TextView object, And
        // add it to the object "l_layout" by a addView() method.
        TextView tv_name = new TextView(this);
        tv_name.setText("Name: ");
        l_layout.addView(tv_name, l_param_small_component);

        // Construct a EditText object.
        EditText et_name = new EditText(this);
        l_layout.addView(et_name, l_param_small_component);


        TextView tv_sex = new TextView(this);
        tv_sex.setText("Sex: ");
        l_layout.addView(tv_sex, l_param_small_component);


        EditText et_sex = new EditText(this);
        l_layout.addView(et_sex, l_param_small_component);


        // Construct a Button that users can press whenever finishing info typing.
        Button bt_confirm = new Button(this);
        bt_confirm.setText("Confirm");
        l_layout.addView(bt_confirm, l_param_small_component);


        this.addContentView(l_layout, layout_param);
    }
}