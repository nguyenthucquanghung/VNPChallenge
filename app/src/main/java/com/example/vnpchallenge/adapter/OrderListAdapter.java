package com.example.vnpchallenge.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vnpchallenge.R;
import com.example.vnpchallenge.base.Constant;
import com.example.vnpchallenge.model.Order;
import com.example.vnpchallenge.screen.OrderDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderListViewholder> {
    private static final String TAG = "OrderListAdapter";

    public List<Order> orders;
    private Context context;

    public OrderListAdapter(List<Order> orders, Context context) {
        this.orders = orders;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderListViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                                .inflate(R.layout.order_item_view, viewGroup, false);
        return new OrderListViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderListViewholder viewholder, int i) {
        viewholder.setData(orders.get(i));
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class OrderListViewholder extends RecyclerView.ViewHolder {

        TextView tvToName, tvToAddress, tvFee;
        View view;

        public OrderListViewholder(@NonNull View itemView) {
            super(itemView);

            view = itemView;
            tvToName = itemView.findViewById(R.id.tv_to_name);
            tvToAddress = itemView.findViewById(R.id.tv_to_address);
            tvFee = itemView.findViewById(R.id.tv_fee);
        }

        public void setData(final Order order) {
            tvToName.setText(order.getReceiverName());
            tvToAddress.setText(order.getToAddress());
            tvFee.setText("Pending...");

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, OrderDetailActivity.class);
                    intent.putExtra(Constant.ORDER_INTENT, order);
                    context.startActivity(intent);
                }
            });
        }
    }
}

