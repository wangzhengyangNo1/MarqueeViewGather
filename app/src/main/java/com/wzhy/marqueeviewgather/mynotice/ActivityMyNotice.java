package com.wzhy.marqueeviewgather.mynotice;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wzhy.marqueeviewgather.R;

public class ActivityMyNotice extends AppCompatActivity {

    private MyNoticeView mNoticeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notice);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.hide();
        }

        mNoticeView = (MyNoticeView) findViewById(R.id.my_notice_view);
        mNoticeView.startScroll();

    }
}
