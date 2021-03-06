package com.example.jitendra.overlay3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jitendra.overlay3.showcaseviewlib.GuideView;


public class MainActivity extends AppCompatActivity {

    private GuideView mGuideView;
    private GuideView.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View view1 = findViewById(R.id.view1);
        final View view2 = findViewById(R.id.view2);
        final View view3 = findViewById(R.id.view3);
        final View view4 = findViewById(R.id.view4);
        final View view5 = findViewById(R.id.view5);


        builder = new GuideView.Builder(MainActivity.this)
                .setTitle("Guide Title Text")
                .setContentText("Guide Description Text\n .....Guide Description Text\n .....Guide Description Text .....")
                .setGravity(GuideView.Gravity.center)
                .setDismissType(GuideView.DismissType.outside)
                .setTargetView(view1)
                .setGuideListener(new GuideView.GuideListener() {
                    @Override
                    public void onDismiss(View view) {
                        switch (view.getId()){
                            case R.id.view1:
                                builder.setTargetView(view2).build();
                                break;
                            case R.id.view2:
                                builder.setTargetView(view3).build();
                                break;
                            case R.id.view3:
                                builder.setTargetView(view4).build();
                                break;
                            case R.id.view4:
                                builder.setTargetView(view5).build();
                                break;
                            case R.id.view5:
                                return;
                        }
                        mGuideView = builder.build();
                        mGuideView.show();
                    }
                });

        mGuideView = builder.build();
        mGuideView.show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}
