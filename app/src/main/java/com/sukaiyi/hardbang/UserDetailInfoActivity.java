package com.sukaiyi.hardbang;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.sukaiyi.hardbang.bean.Post;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobUser;

import static cn.bmob.newim.core.BmobIMClient.getContext;

public class UserDetailInfoActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mTypeName;
    private List<String> mTypeValue;
    private UserDetailInfoAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        BmobUser user = (BmobUser) bundle.get("user");
        setTitle(user.getUsername());

        initData();

        mRecyclerView = (RecyclerView)findViewById(R.id.user_detail_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new UserDetailInfoAdapter());
    }
    protected void initData(){
        mTypeName = new ArrayList<String>();
        mTypeName.add("昵称");
        mTypeName.add("真实姓名");
        mTypeName.add("性别");
        mTypeName.add("所有活动");
        mTypeName.add("学院");
        mTypeName.add("电话号码");
        mTypeName.add("电子邮箱");
        mTypeName.add("个性签名");

        mTypeValue = new ArrayList<String>();
        BmobUser user = BmobUser.getCurrentUser(getContext());
        mTypeValue.add(user.getUsername()==null?null:user.getUsername());
        mTypeValue.add("哈哈哈");
        mTypeValue.add("男");
        mTypeValue.add("");
        mTypeValue.add("计算机学院");
        mTypeValue.add("12929192");
        mTypeValue.add(user.getEmail());
        mTypeValue.add("THIS IS QIANMING~~");



    }
    class UserDetailInfoAdapter extends RecyclerView.Adapter<UserDetailInfoAdapter.MyViewHolder>{


        @Override
        public UserDetailInfoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder =
                    new MyViewHolder(LayoutInflater.from(
                            UserDetailInfoActivity.this).inflate(R.layout.user_detail_item,parent,
                            false));
            return holder;
        }

        @Override
        public void onBindViewHolder(UserDetailInfoAdapter.MyViewHolder holder, int position) {
            holder.mType.setText(mTypeName.get(position));
            holder.mTypeValue.setText(mTypeValue.get(position));

        }

        @Override
        public int getItemCount() {
            return mTypeName.size();
        }

        class MyViewHolder extends ViewHolder{
            View mRootView;
            TextView mType;
            TextView mTypeValue;
            public MyViewHolder(View view) {
                super(view);
                mType = (TextView)view.findViewById(R.id.itemtype);
                mTypeValue = (TextView)view.findViewById(R.id.typevalue);

            }

        }
    }
}


