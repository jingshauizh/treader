package com.example.testgridview.adapter;

/**
 * Created by jings on 2019/3/17.
 */

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.testgridview.R;
import com.example.testgridview.model.GridItem;
import com.example.testgridview.utils.TimeTools;
import java.util.List;

/**
 * Created by jihe on 16/8/23.
 */
public class BOSSQingwangTwoGridAdapter extends BossBaseAdapter {
    private Context context;
    private GridView mGv;

    private static int ROW_NUMBER = 2;
    private int selectedPos;
    private SparseArray<CountDownTimer> countDownCounters;

    public BOSSQingwangTwoGridAdapter(Context context, GridView gv) {
        this.context = context;
        this.mGv = gv;
        this.countDownCounters = new SparseArray<>();
    }

    public BOSSQingwangTwoGridAdapter(Context context, GridView gv, List<GridItem> pactionItems) {
        this.context = context;
        this.mGv = gv;
        this.actionItems = pactionItems;
        this.countDownCounters = new SparseArray<>();
    }

    @Override
    public int getCount() {
        if (null != actionItems) {
            return actionItems.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return actionItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView =
                LayoutInflater.from(context).inflate(R.layout.cell_item_qingwang_two, null);
            //holder.iv = (ImageView) convertView.findViewById(R.id.image);
            //设置显示图片
            //holder.iv.setBackgroundResource(actionItems.get(position).getImageId());
            holder.lv = convertView.findViewById(R.id.item_layout);
            holder.tv = (TextView) convertView.findViewById(R.id.text);
            holder.timeTv = (TextView) convertView.findViewById(R.id.tv_time);
            //设置标题
            holder.tv.setText(actionItems.get(position).getItemName());
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        if (actionItems.get(position).isSelected()) {
            holder.tv.setBackgroundColor(context.getResources().getColor(R.color.item_selected));
        } else {
            holder.tv.setBackground(context.getResources().getDrawable(R.drawable.transparent));
        }

        CountDownTimer countDownTimer = countDownCounters.get(holder.timeTv.hashCode());
        //将前一个缓存清除
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        long timer = actionItems.get(position).getExpirationTime();
        timer = timer - System.currentTimeMillis();

        if (timer > 0) {
            final int positionF = position;
            countDownTimer = new CountDownTimer(timer, 1000) {
                public void onTick(long millisUntilFinished) {
                    long number = millisUntilFinished / 1000;
                    holder.timeTv.setText("" + number);
                    Log.e("TAG",
                        actionItems.get(positionF).getItemName() + " :  " + millisUntilFinished);
                    //时间到了以后 跳到下一个
                    if (number <= 0) {
                        setSelectedItem(positionF + 1);
                    }
                }

                public void onFinish() {
                    holder.timeTv.setText("");
                }
            }.start();
            cancelAllTimer();
            countDownCounters.put(holder.timeTv.hashCode(), countDownTimer);
        } else {
            holder.timeTv.setText("");
        }
        return convertView;
    }

    class Holder {
        ImageView iv;
        TextView tv;
        TextView timeTv;
        LinearLayout lv;
    }

    public List<GridItem> getActionItems() {
        return actionItems;
    }

    public void setActionItems(List<GridItem> actionItems) {
        this.actionItems = actionItems;
        this.notifyDataSetChanged();
    }

    private void cancelAllTimer() {
        if (null == countDownCounters || countDownCounters.size() <= 0) {
            return;
        }
        for (int i = 0; i < countDownCounters.size(); i++) {
            int pos = countDownCounters.keyAt(i);
            CountDownTimer tCountDownTimer = countDownCounters.get(pos);
            if (null != tCountDownTimer) {
                tCountDownTimer.cancel();
            }
        }
    }
}