package com.bw.fivemonth1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.fivemonth1.R;
import com.bw.fivemonth1.bean.OrderBean;
import com.bw.fivemonth1.net.ImageUtil;
import com.bw.fivemonth1.net.SpUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 17:25
 * @Description: 用途：完成特定功能
 */
public class OrderChildAdapter extends RecyclerView.Adapter<OrderChildAdapter.MyViewHolder> {
    private List<OrderBean.OrderListBean.DetailListBean> list = new ArrayList<>();
    private Context context;


    public OrderChildAdapter(List<OrderBean.OrderListBean.DetailListBean> detailList, Context context) {
        this.list.addAll( detailList );
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.item_order_child, parent, false );
        MyViewHolder myViewHolder = new MyViewHolder( view );
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OrderBean.OrderListBean.DetailListBean detailListBean = list.get( position );
        String commodityName = detailListBean.getCommodityName();
        holder.tvName.setText( commodityName );

        String commodityPic = detailListBean.getCommodityPic();
        String[] split = commodityPic.split( "," );

        ImageUtil instance = ImageUtil.getInstance();
        instance.setImg( split[0],holder.ivPic );

        int commodityPrice = detailListBean.getCommodityPrice();
        holder.tvPrice.setText( "￥ "+commodityPrice );
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPic;
        private TextView tvName;
        private TextView tvPrice;

        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            ivPic = itemView.findViewById( R.id.ivPic );
            tvName = itemView.findViewById( R.id.tvName );
            tvPrice = itemView.findViewById( R.id.tvPrice );
        }
    }
}
