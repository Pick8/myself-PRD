package com.example.circleofclass.acrivityManager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 佩强 on 2017/11/21.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

}
