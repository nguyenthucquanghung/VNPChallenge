package com.example.vnpchallenge.screen;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vnpchallenge.R;
import com.example.vnpchallenge.base.BaseActivity;
import com.example.vnpchallenge.base.Constant;
import com.example.vnpchallenge.model.Order;
import com.kofigyan.stateprogressbar.StateProgressBar;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderDetailActivity extends BaseActivity {
    Order order;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        order = (Order)getIntent().getSerializableExtra(Constant.ORDER_INTENT);
        setData(order);
    }

    @Override
    protected void setupUI() {
        ImageView ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setData(Order order) {
        TextView tvFromAddress = findViewById(R.id.tv_from_address_detail);
        TextView tvDate = findViewById(R.id.tv_date);
        TextView tvToName = findViewById(R.id.tv_to_name);
        TextView tvToAddress = findViewById(R.id.tv_to_address);
        TextView tvToNumber = findViewById(R.id.tv_to_number);
        TextView tvType = findViewById(R.id.tv_type);
        TextView tvSize = findViewById(R.id.tv_size);
        TextView tvWeight = findViewById(R.id.tv_weight);
        TextView tvNote = findViewById(R.id.tv_note);
        TextView tvFee = findViewById(R.id.tv_fee);

        String size = String.valueOf(order.getSizeW())
                + 'x' + order.getSizeL()
                + 'x' + order.getSizeH();
        String weight = order.getPackageWeight() + "KG";

        tvFromAddress.setText(order.getFromAddress());
        tvDate.setText(new SimpleDateFormat("MM/dd/yyyy").format(new Date(order.getPickupTime())));
        tvToName.setText(order.getReceiverName());
        tvToAddress.setText(order.getToAddress());
        tvToNumber.setText(order.getReceiverNumber());
        tvType.setText(getOrderTypeString(order));
        tvSize.setText(size);
        tvWeight.setText(weight);
        tvNote.setText(order.getNote());
        tvFee.setText(String.valueOf(order.getFee()));

        String[] descriptionData = {"Pending", "Process", "On delivery", "Complete"};

        StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.sp_status);
        stateProgressBar.setStateDescriptionData(descriptionData);
    }

    private String getOrderTypeString(Order order) {
        switch (order.getType()) {
            case 0:
                return "COD";
            case 1:
                return "EMS";
            case 2:
                return "Normal";
        }
        return "Normal";
    }
}
