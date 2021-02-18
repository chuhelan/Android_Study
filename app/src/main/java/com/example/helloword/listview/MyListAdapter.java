package com.example.helloword.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.helloword.R;

public class MyListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    MyListAdapter(Context context){
        this.mContext=context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContent;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
            holder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
//        给控件赋值
        holder.tvTitle.setText("这是标题");
        holder.tvTime.setText("2077-08-08");
        holder.tvContent.setText("这是内容");
        Glide.with(mContext).load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fa3.att.hudong.com%2F65%2F38%2F16300534049378135355388981738.jpg&refer=http%3A%2F%2Fa3.att.hudong.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1616223542&t=d0bee1cef5d0dc36c4ae88602ca0e2a3").into(holder.imageView);
        return convertView;
    }
}
