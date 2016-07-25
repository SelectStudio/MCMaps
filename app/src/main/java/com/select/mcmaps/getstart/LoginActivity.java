package com.select.mcmaps.getstart;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {
    private PackageManager pm;
    private PackageInfo pi;
    boolean isDone = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView text_main = (TextView) findViewById(R.id.text_main);
        if (checkBrowser("com.mojang.minecraftpe")) {
            if (ismcversion15()) {
                if (isloggedintoxbl()) {
                    isDone = true;
                    text_main.setText(getString(R.string.text_name_A)+getPlayerName()+getString(R.string.text_name_B));
                } else {
                    text_main.setText(getString(R.string.xbox_required));
                }
            } else {
                text_main.setText(getString(R.string.version_required));
            }
        } else {
            text_main.setText(getString(R.string.mc_required));
        }

    }

    public void slideOut(View view) {
        if (isDone) {
            Intent intent = new Intent(this, PolicyActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.in_silde, R.anim.out_silde);
            finish();
        } else {
            finish();
        }
    }

    public boolean checkBrowser(String packageName) {
        if (packageName == null || "".equals(packageName))
            return false;
        try {
            ApplicationInfo info = getPackageManager().getApplicationInfo(
                    packageName, PackageManager.GET_META_DATA);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private Boolean ismcversion15() {
        try {
            pm = this.getPackageManager();
            pi = pm.getPackageInfo("com.mojang.minecraftpe", 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String mcversiona = pi.versionName;
        String[] mcversionaa = mcversiona.split("\\.");
        int mcversionb = 15;
        if (Integer.valueOf(mcversionaa[1]) == mcversionb) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean isloggedintoxbl() {

        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/games/com.mojang/minecraftpe/options.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String hasopened = null;
            String temp = null;
            String s = "";

            try {
                while ((temp = br.readLine()) != null) {
                    s += temp + "\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] ss = s.split("\n");
            hasopened = ss[15];
            if (hasopened.equals("game_haseverloggedintoxbl:1")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            showsnackbar(e.toString());
            return false;
        }
    }

    private void showsnackbar(String p0) {
        View sv = (LinearLayout) findViewById(R.id.layout_bottom);
        Snackbar.make(sv, p0, Snackbar.LENGTH_LONG).show();
    }
    private String getPlayerName(){
        File file = new File(Environment.getExternalStorageDirectory() + "/games/com.mojang/minecraftpe/options.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String hasopened = null;
            String temp = null;
            String s = "";

            try {
                while ((temp = br.readLine()) != null) {
                    s += temp + "\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] ss = s.split("\n");
            hasopened = ss[0];
            String[] nameList = hasopened.split(":");
            return nameList[1];
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}