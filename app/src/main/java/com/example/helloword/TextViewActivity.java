package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    private TextView mTv4,mTv5,mTv6;
//    private TextView mtV5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        mTv4 = (TextView) findViewById(R.id.tv_4);
        mTv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中划线
        mTv4.getPaint().setAntiAlias(true);//去除锯齿

        mTv5 = (TextView) findViewById(R.id.tv_5);
        mTv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线

        mTv6 = (TextView) findViewById(R.id.tv_6);
        mTv6.setText(Html.fromHtml("<u>地表最酷文丽</u>"));
    }
}