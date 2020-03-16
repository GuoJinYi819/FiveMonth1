package com.bw.fivemonth1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.fivemonth1.R;
import com.bw.fivemonth1.bean.OrderBean;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 17:25
 * @Description: 用途：完成特定功能
 */
public class OrderGroupAdapter extends RecyclerView.Adapter<OrderGroupAdapter.MyViewHolder> {
    private List<OrderBean.OrderListBean> list = new ArrayList<>();
    private Context context;


    public OrderGroupAdapter(List<OrderBean.OrderListBean> list, Context context) {
        this.list.addAll( list );
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.item_order_group, parent, false );
        MyViewHolder myViewHolder = new MyViewHolder( view );
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OrderBean.OrderListBean orderListBean = list.get( position );
        String orderId = orderListBean.getOrderId();
        holder.tvOrderId.setText( orderId );

        List<OrderBean.OrderListBean.DetailListBean> detailList = orderListBean.getDetailList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( context );
        linearLayoutManager.setOrientation( RecyclerView.VERTICAL );
        holder.recyclerChild.setLayoutManager( linearLayoutManager );
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvOrderId;
        private RecyclerView recyclerChild;

        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            tvOrderId = itemView.findViewById( R.id.tvOrderId );
            recyclerChild = itemView.findViewById( R.id.recyclerChild );
        }
    }
}
