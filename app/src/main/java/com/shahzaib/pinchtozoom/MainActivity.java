package com.shahzaib.pinchtozoom;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ScaleGestureDetector.OnScaleGestureListener {

    ScaleGestureDetector scaleGestureDetector;
    TextView scaleTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scaleTV = findViewById(R.id.scaleTV);
        scaleGestureDetector = new ScaleGestureDetector(this, this);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        return true;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        SHOW_LOG("onScaleBegin");
        return true;
    }

    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        float scaleFactor = detector.getScaleFactor();
        if (scaleFactor > 1) {
            SHOW_LOG("Zoom Out");
            scaleTV.setText("Zoom Out");
        } else {
            SHOW_LOG("Zoom In");
            scaleTV.setText("Zoom In");
        }
        return true;
    }


    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {
        SHOW_LOG("onScaleEnd");
        scaleTV.setText("");
    }


    private void SHOW_LOG(String message) {
        Log.i("123456", message);
    }
}
