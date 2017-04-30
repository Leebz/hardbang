package com.sukaiyi.hardbang;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 42910 on 2017/4/30.
 */

public class BaseApplication extends Application {



    public static List<Object> activitys = new ArrayList<Object>();
    private static BaseApplication instance;
    //获取单例模式中唯一的MyApplication实例
    public static BaseApplication getInstance() {
        if (instance == null)
            instance = new BaseApplication();
        return instance;
    }

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        if (!activitys.contains(activity))
            activitys.add(activity);
    }

    // 遍历所有Activity并finish
    public void destory() {

        for (Object activity : activitys) {
            ((Activity) activity).finish();
        }
        System.exit(0);
    }

}
