package com.example.helloword.jump;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloword.R;
import com.example.helloword.util.ToastUtil;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mBtnJump = findViewById(R.id.jump);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式跳转 显式1
                Intent intent = new Intent(AActivity.this,BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","地表最酷文丽");
                bundle.putInt("number",88);
                intent.putExtras(bundle);
//                startActivity(intent);
                startActivityForResult(intent,0);


                //显式 2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

                //显式3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"com.example.helloword.jump.BActivity");
//                startActivity(intent);

//                //显式4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"com.example.helloword.jump.BActivity"));
//                startActivity(intent);

//                //隐式
//                Intent intent = new Intent();
//                intent.setAction("com.exmple.test.BActivity");
//                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("title"), Toast.LENGTH_LONG).show();
    }
}
