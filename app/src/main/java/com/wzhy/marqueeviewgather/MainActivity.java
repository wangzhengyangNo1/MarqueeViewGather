package com.wzhy.marqueeviewgather;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wzhy.marqueeviewgather.mynotice.ActivityMyNotice;
import com.wzhy.marqueeviewgather.simple.ActivitySimpleMarquee;
import com.wzhy.marqueeviewgather.customview.ActivityRollingView;

public class MainActivity extends AppCompatActivity {

    private Button mSimpleImplBtn;
    private Button mRollingNoticeBtn;
    private Button mNoticeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSimpleImplBtn = (Button) findViewById(R.id.btn_simple_impl);
        mRollingNoticeBtn = (Button) findViewById(R.id.btn_custom);
        mNoticeBtn = (Button) findViewById(R.id.btn_my_notice);

        mSimpleImplBtn.setOnClickListener(onClickListener);
        mRollingNoticeBtn.setOnClickListener(onClickListener);
        mNoticeBtn.setOnClickListener(onClickListener);

    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_simple_impl:
                    startActivity(ActivitySimpleMarquee.class);
                    break;
                case R.id.btn_custom:
                    startActivity(ActivityRollingView.class);
                    break;
                case R.id.btn_my_notice:
                    startActivity(ActivityMyNotice.class);
                    break;
            }

        }
    };


    private void startActivity(Class<? extends Activity> classOfActivity){
        startActivity(new Intent(this, classOfActivity));
    }
}
