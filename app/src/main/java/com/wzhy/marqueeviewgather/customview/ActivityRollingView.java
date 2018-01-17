package com.wzhy.marqueeviewgather.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.wzhy.marqueeviewgather.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityRollingView extends AppCompatActivity {

    private RollingView mRollingNoticeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rolling_view);

        mRollingNoticeView = (RollingView) findViewById(R.id.rolling_notice_view);
// 初始化号外列表
        List<String> haowaiArray = new ArrayList<>();
        haowaiArray.add("[母婴天地] 买尿不湿送婴儿手口湿巾");
        haowaiArray.add("[利民商店] 满100免费配送");
        haowaiArray.add("[果之家] 泰国金枕榴莲8元/kg");
        haowaiArray.add("[户外运动] 户外运动专业装备搜集");
        haowaiArray.add("[天天特价] 只要9.9还包邮");
        haowaiArray.add("[尖端潮品] 折叠电动车");
        haowaiArray.add("[黑科技] 智能VR带你装13");
        haowaiArray.add("[旅行必备] 太阳能充电宝-永不断电");
        // 绑定数据
        mRollingNoticeView.setPageSize(2);
        mRollingNoticeView.setClickColor(0xff888888);
        mRollingNoticeView.setLeftDrawable(R.drawable.ic_photo_black_24dp);
        mRollingNoticeView.setRollingText(haowaiArray);
        mRollingNoticeView.setOnItemClickListener(new RollingView.onItemClickListener() {
            @Override
            public void onItemClick(TextView v) {

            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        mRollingNoticeView.resume();
    }
    @Override
    public void onPause() {
        super.onPause();
        mRollingNoticeView.pause();
    }
}
