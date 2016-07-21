package com.select.mcmaps.getstart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void slideOut(View view){
        Intent intent = new Intent(this,PolicyActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.in_silde,R.anim.out_silde);
        finish();
    }
}