package com.select.mcpeone.mainlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.select.mcpeone.mainlist.adapters.MainAdapter;
import com.select.mcpeone.mainlist.classes.ListType;
import com.select.mcpeone.mainlist.classes.MainBean;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<MainBean> list_main=new ArrayList<MainBean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.list_main);
        recyclerView.setHasFixedSize(true);
        list_main.add(new MainBean("test","test","http://upload.ikanchai.com/2015/1106/1446789919433.gif","http://upload.ikanchai.com/2015/1106/1446789919433.gif", ListType.LIST_INFO));
        list_main.add(new MainBean("http://upload.ikanchai.com/2015/1106/1446789919433.gif",ListType.LIST_PIC));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MyApplication.getCtx());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        MainAdapter adapter=new MainAdapter(list_main);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
