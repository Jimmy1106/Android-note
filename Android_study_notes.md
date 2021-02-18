---
title: 'Android study notes'
---




**Table of Contents**
===


[TOC]



**Basic Concept**
===
<span class="red">Description</span>

**AndroidManifest.xml**
---
- Declare **components** and **requirements** for the App.
- e.g. Minimum android SDK.
- Before launching a App component, System read the file to know App activitys.



**Build.gradle**
---
- **Project**
- **Module/app**

     
Note: Gradle can be thought as **Makefile of JAVA**.


**Activity lifecycle managing**
---
- **State**
    - Resumed
    - Paused
    - Stopped
- **Lifetime**
    - **Entire**: onCreate() --> onDestroy().
    - **Visible**: onStart() --> onStop().
    - **Foreground**: onResume() --> onPause().

![](https://i.imgur.com/UlXVdRp.png =500x680)
ref: [https://www.geeksforgeeks.org/activity-lifecycle-in-android-with-demo-app/](https://www.geeksforgeeks.org/activity-lifecycle-in-android-with-demo-app/)

Note: Store data to database when onPause() method called.


**First app building**
===

**Building Steps**
---
1.Prepare all the resources you need. (e.g.strings, icons...)
2.Set up view file (main.xml)
3.Set up Activity file (MainActivity.java)

Note: These steps can be thought as **MVC**. (Model, View, and Controller.)

**Intent-filter**
---
- A filter that enable other intents to reference.
- Enable other apps to access the **function** of **component**.
- e.g. **The activity of a camera app** requires a **photograph intent** that declared in its intent-filter.

<br>

**Exercise: [Android_UI_first_app](/Android_UI_first_app) [(views)](/Views/Android_UI_first_app)**

<br>




**User Interface**
===
A android app UI is composed of following objects:
- **View object** e.g. TextView, button, ...
- **ViewGroup object**: e.g. LinearLayout, ListView, ...

<br>


**LinearLayout**
---

- Basic LinearLayout building
    -
    main.xml
    ```xml=1
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <!--    Add more view content here-->

    </LinearLayout>
    ```
    onCreate method in MainActivity.java
    ```java=1
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); 
    }
    ```


- LinearLayout built without view file
    -
    onCreate method in MainActivity.java
    ```JAVA=1
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
        
        // Display the view on screen.
        this.addContentView(l_layout, layout_param);

    }
    ```
    
    Note: We should pass the pointer "this" as an argument whenever constructing a View or ViewGroup object.

**Button**
---
- Building steps
    - 
    1. Create button object.
    2. Build button listner.
    3. Register button to listener


- Create buttton and register it to listener
    - 
    ```java=1
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); 
        
        Button bt_confirm = (Button)findViewById(R.id.button);
        bt_confirm.setOnClickListener(bt_listener);
    }
    ```
- Build Button listener
    - 
    ```java=1
    private OnClickListener bt_listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            buttonEvent();
        }
    };
    ```
    
<br>

**Exercise: [ex_MVC_Button_toast](/ex_MVC_Button_toast) [(views)](/Views/ex_MVC_Button_toast)** 

<br>

<span class='red'>**Intent**</span>
---
- Basic intent class usage
    -
    ```java=1
    Intent intent = new Intent();
            intent.setClass(MainActivity.this, anotherActivity.class );
            startActivity(intent);
    ```

<br>

**Exercise: [ex_basic_startActivity](/ex_basic_startActivity) [(views)](/Views/ex_basic_startActivity)** 

**Exercise: [Ex_activity_bundle](/Ex_activity_bundle) [(views)](/Views/Ex_activity_bundle)** 

**Exercise: [Ex_radio_button](/Ex_radio_button) [(views)](/Views/Ex_radio_button)** 

<br>


<span class='red'>**Adapter**</span>
---

<br>

**Exercise: [Ex_spinner](/Ex_spinner) [(views)](/Views/Ex_spinner)** 

<br> 

    
<span class='red'>**ListView**</span>
---
- Custom ListView
    -
    
- SimpleAdapter
    - 
    ```java
    // Build custom Adapter with SimpleAdapter.
    SimpleAdapter adpt_education = new SimpleAdapter(
            this,
            map_list,
            R.layout.list_item,
            new String[] {"imgView", "txtView"},
            new int[] {R.id.ivId_Edu,R.id.tvId_edu}
    );
    ```
    [Advanced doc](https://www.geeksforgeeks.org/simpleadapter-in-android-with-example/)
    
<br>

**Exercise: [Ex_listView](/Ex_listView) [(views)](/Views/Ex_listView)** 

<br> 

<span class='red'>**RecyclerView**</span>
---
- FirebaseRecyclerAdapter
    - 

<br>

**Exercise: [Ex_FirebaseRecycleradapter](/Ex_FirebaseRecycleradapter) [(views)](/Views/Ex_FirebaseRecycleradapter)** 

<br> 

**Exercises**
===
- [Android_UI_first_app](/Android_UI_first_app)
- [ex_MVC_Button_toast](/ex_MVC_Button_toast)
- [ex_basic_startActivity](/ex_basic_startActivity)
- [Ex_activity_bundle](/Ex_activity_bundle)
- [Ex_radio_button](/Ex_radio_button)
- [Ex_spinner](/Ex_spinner)
- [Ex_listView](/Ex_listView)
- [Ex_FirebaseRecycleradapter](/Ex_FirebaseRecycleradapter)


**Useful links for Development**
===
- [Set up console log in debug mode](https://stackoverflow.com/questions/16780294/how-to-print-to-the-console-in-android-studio)



<style>
.blue {
  color: blue;
}
.red {
  color: red;
}
</style>