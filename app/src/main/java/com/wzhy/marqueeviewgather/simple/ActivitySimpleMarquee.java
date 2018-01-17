package com.wzhy.marqueeviewgather.simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.wzhy.marqueeviewgather.R;

import java.util.ArrayList;

import static android.R.attr.start;

public class ActivitySimpleMarquee extends AppCompatActivity {

    private ViewFlipper mNoticeScrollerVf;
    private ArrayList<String> mNoticeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_marquee);

        initData();

        initView();

        startFlipping();

    }

    private void initData() {
        mNoticeList = new ArrayList<>();
        mNoticeList.add("定风波--苏轼");
        mNoticeList.add("莫听穿林打雨声，何妨吟啸且徐行。");
        mNoticeList.add("竹杖芒鞋轻胜马，谁怕，一蓑烟雨任平生。");
        mNoticeList.add("料峭春寒吹酒醒，微冷，山头斜照却相迎。");
        mNoticeList.add("回首向来萧瑟处，归去，也无风雨也无晴。");
    }

    private void initView() {
        mNoticeScrollerVf = (ViewFlipper) findViewById(R.id.vf_notice_scroller);
        mNoticeScrollerVf.setInAnimation(this, R.anim.anim_notice_in);
        mNoticeScrollerVf.setOutAnimation(this, R.anim.anim_notice_out);
        mNoticeScrollerVf.setFlipInterval(1600);
    }

    private void startFlipping() {
        for (String notice : mNoticeList) {
            LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.layout_notice_simple, null);
            TextView noticeTv = (TextView) layout.getChildAt(1);
            noticeTv.setText(notice);
            mNoticeScrollerVf.addView(layout);
        }

        mNoticeScrollerVf.startFlipping();
    }


}
