package com.example.helloword;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloword.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    private Button mBtnToast1, mBtnToast2, mBtnToast3, mBtnToast4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mBtnToast1 = (Button) findViewById(R.id.btn_toast_1);
        mBtnToast2 = (Button) findViewById(R.id.btn_toast_2);
        mBtnToast3 = (Button) findViewById(R.id.btn_toast_3);
        mBtnToast4 = (Button) findViewById(R.id.btn_toast_4);
        Onclick onclick = new Onclick();
        mBtnToast1.setOnClickListener(onclick);
        mBtnToast2.setOnClickListener(onclick);
        mBtnToast3.setOnClickListener(onclick);
        mBtnToast4.setOnClickListener(onclick);
    }

    class Onclick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_toast_1:
                    Toast.makeText(getApplicationContext(),"Toast",Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_toast_2:
                    Toast toastCenter = Toast.makeText(getApplicationContext(),"居中Toast",Toast.LENGTH_LONG);
                    toastCenter.setGravity(Gravity.CENTER,0,0);
                    toastCenter.show();
                    break;
                case R.id.btn_toast_3:
                    Toast toastCustom = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View view = inflater.inflate(R.layout.layout_toast,null);
                    ImageView imageView = view.findViewById(R.id.iv_toast);
                    TextView textView = view.findViewById(R.id.tv_toast);
                    imageView.setImageResource(R.drawable.icon_pay);
                    textView.setText("支付成功！");
                    toastCustom.setView(view);
                    toastCustom.setDuration(Toast.LENGTH_LONG);
                    toastCustom.show();
                    break;
                case R.id.btn_toast_4:
                    ToastUtil.showMsg(getApplicationContext(),"包装过的Toast");
                    break;
            }
        }
    }
}
