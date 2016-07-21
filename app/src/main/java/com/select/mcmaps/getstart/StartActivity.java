package com.select.mcmaps.getstart;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    public static StartActivity button=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        setContentView(R.layout.activity_start);

        View view_statusbar = findViewById(R.id.view_statusbar);
        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) view_statusbar.getLayoutParams();
        Display display = getWindowManager().getDefaultDisplay();
        linearParams.height = getStatusBarHeight();
        linearParams.width = display.getWidth();
        view_statusbar.setLayoutParams(linearParams);
        Typeface ROBOTO_THIN = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        final TextView text_loader = (TextView) findViewById(R.id.text_loadertitle);
        text_loader.setTypeface(ROBOTO_THIN);
        text_loader.setAlpha(0);
        text_loader.animate()
                .alpha(1f)
                .setDuration(2500)
                .setListener(null).start();
        Animation loader_animA = AnimationUtils.loadAnimation(this, R.anim.loadertext_anim_a);
        loader_animA.setDuration(1250);
        loader_animA.setFillAfter(true);
        loader_animA.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(text_loader, "scaleX", 1f, 0.8f).setDuration(500);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(text_loader, "scaleY", 1f, 0.8f).setDuration(500);
                scaleX.start();
                scaleY.start();
                scaleX.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        Intent intent = new Intent(StartActivity.this, ConnectActivity.class);
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(StartActivity.this, text_loader, "text_loader");
                        startActivity(intent, options.toBundle());
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });

            }
                       });
        button = this;
        text_loader.startAnimation(loader_animA);

    }
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


}
