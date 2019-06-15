package com.example.vnpchallenge.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vnpchallenge.R;
import com.example.vnpchallenge.model.Order;

import java.util.ArrayList;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderListViewholder> {
    private static final String TAG = "OrderListAdapter";

    private ArrayList<Order> orders;

    public OrderListAdapter(ArrayList<Order> orders) {
        this.orders = orders;
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

        TextView tvToName, tvToAddress, tvNote, tvFee;

        public OrderListViewholder(@NonNull View itemView) {
            super(itemView);

            tvToName = itemView.findViewById(R.id.tv_to_name);
            tvToAddress = itemView.findViewById(R.id.tv_to_address);
            tvNote = itemView.findViewById(R.id.tv_note);
            tvFee = itemView.findViewById(R.id.tv_fee);
        }

        public void setData(Order order) {
            tvToName.setText(order.getReceiverName());
            tvToAddress.setText(order.getToAddress());
            tvNote.setText(order.getNote());
            tvFee.setText(Float.toString(order.getFee()) + "vnd");
        }
    }
}

