package com.ama.hungrypenguin.ui;

/**
 * Created by archanaiyer on 2/21/16.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.ama.hungrypenguin.R;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


        // -----------Start animation --------------------------------//
        ImageView imageView = (ImageView) findViewById(R.id.image);

        final RotateAnimation rotateAnim = new RotateAnimation(-15, 15,
                RotateAnimation.RELATIVE_TO_PARENT, 0.5f,
                RotateAnimation.RELATIVE_TO_PARENT, 0.5f);

        rotateAnim.setDuration(1000);
        rotateAnim.setFillAfter(true);

        final RotateAnimation rotateAnim1 = new RotateAnimation(25, -25,
                RotateAnimation.RELATIVE_TO_PARENT, 0.5f,
                RotateAnimation.RELATIVE_TO_PARENT, 0.5f);

        rotateAnim1.setDuration(1000);
        rotateAnim1.setFillAfter(true);

        AnimationSet a = new AnimationSet(false);
        a.addAnimation(rotateAnim);
        a.addAnimation(rotateAnim1);
        imageView.startAnimation(a);

        // -----------End animation --------------------------------//

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreen.this, SampleActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}