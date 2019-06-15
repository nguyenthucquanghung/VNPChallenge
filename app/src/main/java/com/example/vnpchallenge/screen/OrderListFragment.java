package com.example.vnpchallenge.screen;

import android.os.Bundle;
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
import com.example.vnpchallenge.model.Order;

import java.util.ArrayList;
import java.util.Date;

public class OrderListFragment extends Fragment {
    private static final String TAG = "OrderListFragment";

    RecyclerView rcvOrderList;
    ArrayList<Order> orders = new ArrayList<>();

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

        OrderListAdapter adapter = new OrderListAdapter(orders);
        rcvOrderList.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvOrderList.setAdapter(adapter);
    }

    private void getData() {
        orders.add(new Order("Hanoi", "Hochiminh City",new Date(System.currentTimeMillis()),
                "Hung","0971423103", 5,2,3,4,"Birthday Gift",100000,1));
    }
}
