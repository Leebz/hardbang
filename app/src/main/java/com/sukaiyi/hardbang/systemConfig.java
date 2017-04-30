package com.sukaiyi.hardbang;

import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.sukaiyi.hardbang.fragments.OnFragmentInteractionListener;

import cn.bmob.newim.BmobIM;
import cn.bmob.v3.BmobUser;

import static cn.bmob.newim.core.BmobIMClient.getContext;
import static com.sukaiyi.hardbang.R.id.container;


public class systemConfig extends AppCompatActivity {
    private BootstrapButton mExitBtn;
    private TextView mAboutUs;
    private TextView mCheckUpdate;
    private TextView mClearRadis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_config);

        mExitBtn = (BootstrapButton) findViewById(R.id.exit);
        mExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BmobUser user = BmobUser.getCurrentUser(getContext());
                if(user!=null){
                    BmobIM.getInstance().disConnect();
                    user.logOut(getContext());
                    System.exit(0);


                }
            }
        });
        mAboutUs = (TextView) findViewById(R.id.about_us);
        mAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(systemConfig.this,AboutUs.class);
                startActivity(intent);
                return;
            }
        });

        mCheckUpdate = (TextView) findViewById(R.id.check_update);
        mCheckUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(systemConfig.this,CheckUpdate.class);
                startActivity(intent);
                return;
            }
        });
        mClearRadis = (TextView) findViewById(R.id.clear_redis);
        mClearRadis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(systemConfig.this).setTitle("系统提示")//设置对话框标题

                        .setMessage("确认清除缓存？")//设置显示的内容

                        .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮

                            //此处加入真正清除缓存代码

                            @Override

                            public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件
                                // TODO Auto-generated method stub
                                //定义Toast显示时间属性
                                final int s = Toast.LENGTH_SHORT;
                                final int l = Toast.LENGTH_LONG;
                                //显示Toast显示内容属性
                                final String str = "已清除";

                                Toast t = Toast.makeText(getApplicationContext(), str, s);
                                //显示Toast
                                t.show();
                                return;

                            }

                        }).setNegativeButton("返回",new DialogInterface.OnClickListener() {//添加返回按钮



                    @Override

                    public void onClick(DialogInterface dialog, int which) {//响应事件

                        // TODO Auto-generated method stub

                        Log.i("alertdialog"," 请保存数据！");

                    }

                }).show();//在按键响应事件中显示此对话框
            }
        });


    }


}
