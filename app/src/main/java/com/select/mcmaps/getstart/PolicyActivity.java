package com.select.mcmaps.getstart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PolicyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
    }
    public void slideOut(View view){
        Intent intent = new Intent(this,DoneActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.in_silde,R.anim.out_silde);
        finish();
    }
}
