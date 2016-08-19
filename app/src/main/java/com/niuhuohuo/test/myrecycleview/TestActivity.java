package com.niuhuohuo.test.myrecycleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qnhlli on 2016/8/19.
 */
public class TestActivity extends AppCompatActivity implements View.OnClickListener,ItemClickListener{
    private RecyclerView recyclerView;
    private TestAdapter testAdapter;
    private List<Integer> datas;
    private Button btn_test;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        recyclerView=(RecyclerView) findViewById(R.id.testRecyclerview);
        btn_test=(Button)findViewById(R.id.btn_test);
        btn_test.setOnClickListener(this);
        initVerticalRecyclerView();
    }
    private void initVerticalRecyclerView() {
        //2.创建一个垂直的线性布局(一个布局管理器layoutManager只能绑定一个Recyclerview)
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        //找到RecyclerView，并设置布局管理器
        recyclerView.setLayoutManager(layoutManager1);
        //3.取得数据集(此处，应根据不同的主题查询得不同的数据传入到 MyRecyclerCardviewAdapter中构建adapter)
        datas = new ArrayList<>();
        for (int i=0; i<5; i++){
            datas.add(i);
        }
        //4.创建adapter
        testAdapter = new TestAdapter(datas);
        //将RecyclerView组件绑定adapter
        recyclerView.setAdapter(testAdapter);
        testAdapter.setOnItemClickListener(TestActivity.this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        intent.setClass(TestActivity.this,AddActivity.class);
        startActivity(intent);
    }
    @Override
    public void OnItemClick(View v, int position) {
        Toast.makeText(this,"点击"+position,Toast.LENGTH_LONG).show();
        Intent intent=new Intent(TestActivity.this,ItemActivity.class);
        startActivity(intent);
    }
}
