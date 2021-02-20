package com.example.helloword;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloword.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {

    private Button mBtnDialog1, mBtnDialog2, mBtnDialog3, mBtnDialog4, mBtnDialog5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mBtnDialog1 = findViewById(R.id.btn_dialog1);
        mBtnDialog2 = findViewById(R.id.btn_dialog2);
        mBtnDialog3 = findViewById(R.id.btn_dialog3);
        mBtnDialog4 = findViewById(R.id.btn_dialog4);
        mBtnDialog5 = findViewById(R.id.btn_dialog5);
        OnClick onClick = new OnClick();
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mBtnDialog5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答").setMessage("您今儿感觉咋样？")
                            .setIcon(R.drawable.official)
                            .setPositiveButton("棒极了", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "大吉");
                                }
                            })
                            .setNeutralButton("还不错", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "中吉");
                                }
                            })
                            .setNegativeButton("很糟糕 ", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "小吉");
                                }
                            }).show();
                    break;
                case R.id.btn_dialog2:
                    final String[] array2 = new String[]{"男", "女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("选择你的性别").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this, array2[which]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    final String[] array3 = new String[]{"男", "女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("请选择你的性别")
                            .setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, array3[which]);
                                    dialog.dismiss();
                                }
                            }).setCancelable(false).show();
                    break;
                case R.id.btn_dialog4:
                    final String[] array4 = new String[]{"唱歌","跳舞","游戏","电影","旅游","看书","听歌"};
                    boolean[] isSelected = new boolean[]{false,false,true,true,true,false,false};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择你的兴趣爱好").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(DialogActivity.this,array4[which]+":"+isChecked);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//
                        }
                    }).show();
                    break;
                case R.id.btn_dialog5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog,null);
                    EditText etUserName = view.findViewById(R.id.et_username);
                    EditText etPassWord = view.findViewById(R.id.et_password);
                    Button btnLogin = view.findViewById(R.id.btn_login);
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//
                        }
                    });
                    builder5.setTitle("请先登录").setView(view).show();
                    break;
            }
        }
    }

}

