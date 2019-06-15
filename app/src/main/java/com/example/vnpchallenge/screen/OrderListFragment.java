package com.example.vnpchallenge.screen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vnpchallenge.R;
import com.example.vnpchallenge.adapter.OrderListAdapter;
import com.example.vnpchallenge.database.DatabaseManager;
import com.example.vnpchallenge.model.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderListFragment extends Fragment {
    private static final String TAG = "OrderListFragment";

    RecyclerView rcvOrderList;
    List<Order> orders = new ArrayList<>();
    OrderListAdapter adapter;

    public OrderListFragment () {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rcvOrderList = view.findViewById(R.id.rcv_orders);

        getData();

        adapter = new OrderListAdapter(orders, getContext());
        rcvOrderList.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvOrderList.setAdapter(adapter);

        getContext().registerReceiver(receiver, new IntentFilter("update_order"));
    }

    private void getData() {
        orders = DatabaseManager.getInstance(getContext()).getListOrder();
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    adapter.orders = DatabaseManager.getInstance(getContext()).getListOrder();
                    adapter.notifyDataSetChanged();
                }
            },1000);
        }
    };
}
