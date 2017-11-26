package com.example.circleofclass.acrivityManager;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 佩强 on 2017/11/21.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);//根据传入的Activity来删除
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activities.clear();
    }

}
