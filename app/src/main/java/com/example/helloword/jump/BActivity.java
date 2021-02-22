package com.example.helloword.jump;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloword.R;

public class BActivity extends AppCompatActivity {

    private TextView mTvTitle;
    private Button mBtnFinish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mTvTitle = findViewById(R.id.tv_title);
        mBtnFinish = findViewById(R.id.btn_finish);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int number = bundle.getInt("number");

        mTvTitle.setText(name+","+number);

        mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putString("title","Hero is back !");
                intent.putExtras(bundle1);
                setResult(AActivity.RESULT_OK,intent);
                finish();
            }
        });

    }
}
