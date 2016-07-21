package com.select.mcmaps.getstart;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ConnectActivity extends AppCompatActivity {
public static ConnectActivity button = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        button=this;
        Typeface ROBOTO_THIN = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Thin.ttf");
        final TextView text_loader = (TextView) findViewById(R.id.text_loadertext);
        TextView up_loader = (TextView) findViewById(R.id.text_loader);
        text_loader.setTypeface(ROBOTO_THIN);
        up_loader.setTypeface(ROBOTO_THIN);
        FloatingActionButton fab= (FloatingActionButton) findViewById(R.id.fab);
        fab.setScaleX(0f);
        fab.setScaleY(0f);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideOut();
            }
        });
        final View view_bottom=findViewById(R.id.view_bottom);
        final View view_navigation=findViewById(R.id.view_navigation);
        LinearLayout.LayoutParams linearParams;
        linearParams = (LinearLayout.LayoutParams) view_bottom.getLayoutParams();
        Display display = getWindowManager().getDefaultDisplay();
        linearParams.height = display.getHeight()*2/10;
        linearParams.width = display.getWidth();
        view_bottom.setLayoutParams(linearParams);
        linearParams = (LinearLayout.LayoutParams) view_navigation.getLayoutParams();
        linearParams.height = getNavigationBarHeight();
        view_navigation.setLayoutParams(linearParams);
        final View view_bg=findViewById(R.id.view_background);
        ViewTreeObserver view_viewTreeObserver= view_bg.getViewTreeObserver();
        view_viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Animator animator=createAnimation(view_bg,false,500);
               view_bg.setVisibility(View.VISIBLE);
                animator.start();
                animator.addListener(new Animator.AnimatorListener() {
                    public void onAnimationStart(Animator animator) {}
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        finishStart();
                        TextView up_loader = (TextView) findViewById(R.id.text_loader);
                        TextView text_welcome = (TextView) findViewById(R.id.text_welocme);
                        TextView text_developer = (TextView) findViewById(R.id.text_developed_by);
                        up_loader.setVisibility(View.VISIBLE);
                        text_welcome.setVisibility(View.VISIBLE);
                        text_developer.setVisibility(View.VISIBLE);
                        up_loader.animate()
                                .alpha(1f)
                                .setDuration(500)
                                .setListener(null).start();
                        text_welcome.animate()
                                .alpha(1f)
                                .setDuration(500)
                                .setListener(null).start();
                        text_developer.animate()
                                .alpha(1f)
                                .setDuration(500)
                                .setListener(null).start();
                        FloatingActionButton fab= (FloatingActionButton) findViewById(R.id.fab);
                        ObjectAnimator scaleX = ObjectAnimator.ofFloat(fab, "scaleX", 0f, 1f).setDuration(500);
                        ObjectAnimator scaleY = ObjectAnimator.ofFloat(fab, "scaleY", 0f, 1f).setDuration(500);
                        scaleX.start();
                        scaleY.start();

                    }
                    public void onAnimationCancel(Animator animator) {}
                    public void onAnimationRepeat(Animator animator) {
                    }
                });

            }
        });
    }
    public Animator createAnimation(View view, Boolean open, int time) {

        Animator animator;

        if (open) {
            animator = ViewAnimationUtils.createCircularReveal(
                    view,
                    view.getWidth() / 2,
                    view.getHeight() / 2,
                    view.getWidth(),
                    0);
        } else {
            animator = ViewAnimationUtils.createCircularReveal(
                    view,
                    view.getWidth() / 2,
                    view.getHeight() / 2,
                    0,
                    view.getWidth());
        }

        animator.setInterpolator(new DecelerateInterpolator());
        animator.setDuration(time);
        return animator;
    }

    public void finishStart(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(0);
                    StartActivity.button.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void finishText(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                          TextView text_loader = (TextView) findViewById(R.id.text_loadertext);
                           text_loader.setVisibility(View.GONE);
                       }
                   });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public int getNavigationBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    @Override
    public void onBackPressed() {
        finish();
    }
    public void slideOut(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.in_silde,R.anim.out_silde);
        finish();
    }
}
