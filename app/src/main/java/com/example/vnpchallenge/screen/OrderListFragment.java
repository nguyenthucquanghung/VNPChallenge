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

import com.amazonaws.amplify.generated.graphql.ListOrderssQuery;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers;
import com.apollographql.apollo.GraphQLCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.vnpchallenge.MainActivity;
import com.example.vnpchallenge.R;
import com.example.vnpchallenge.adapter.OrderListAdapter;
import com.example.vnpchallenge.database.DatabaseManager;
import com.example.vnpchallenge.model.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Nonnull;

public class OrderListFragment extends Fragment {
    private static final String TAG = "OrderListFragment";

    RecyclerView rcvOrderList;
    List<Order> orders = new ArrayList<>();
    OrderListAdapter adapter;

    private AWSAppSyncClient mAWSAppSyncClient;

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

        mAWSAppSyncClient = AWSAppSyncClient.builder()
                .context(getContext())
                .awsConfiguration(new AWSConfiguration(getContext()))
                .build();

        rcvOrderList = view.findViewById(R.id.rcv_orders);
        adapter = new OrderListAdapter(orders, getContext());
        rcvOrderList.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvOrderList.setAdapter(adapter);
        getContext().registerReceiver(broadcastReceiver, new IntentFilter("add_order"));
    }

    @Override
    public void onResume() {
        super.onResume();
        runQuery();
    }


    private void renderData() {
        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                OrderListAdapter adapter = new OrderListAdapter(orders, getContext());
                rcvOrderList.setLayoutManager(new LinearLayoutManager(getContext()));
                rcvOrderList.setAdapter(adapter);
            }
        });
    }

    public void runQuery(){
        mAWSAppSyncClient.query(ListOrderssQuery.builder().build())
                .responseFetcher(AppSyncResponseFetchers.CACHE_AND_NETWORK)
                .enqueue(OrderssCallback);
    }

    private GraphQLCall.Callback<ListOrderssQuery.Data> OrderssCallback = new GraphQLCall.Callback<ListOrderssQuery.Data>() {
        @Override
        public void onResponse(@Nonnull Response<ListOrderssQuery.Data> response) {
            Log.i("Results", response.data().listOrderss().items().toString());
            adapter.orders.clear();
            for (ListOrderssQuery.Item item : response.data().listOrderss().items())
                if (item.owner().equals(MainActivity.userID)) {
                    Order order = new Order(
                            1,
                            item.fromAddress(),
                            item.toAddress(),
                            Long.parseLong(item.pickupTime()),
                            item.receiverName(),
                            item.receiverNumber(),
                            item.packageWeight(),
                            item.sizeW(),
                            item.sizeL(),
                            item.sizeH(),
                            item.note(),
                            item.fee(),
                            item.type()
                    );
                    adapter.orders.add(order);
                }
            OrderListFragment.this.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter.notifyDataSetChanged();
                }
            });
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("ERROR", e.toString());
            adapter = new OrderListAdapter(orders, getContext());
            rcvOrderList.setLayoutManager(new LinearLayoutManager(getContext()));
            rcvOrderList.setAdapter(adapter);
        }
    };

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            runQuery();
        }
    };

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
            },1500);
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        getContext().unregisterReceiver(broadcastReceiver);
    }
}
