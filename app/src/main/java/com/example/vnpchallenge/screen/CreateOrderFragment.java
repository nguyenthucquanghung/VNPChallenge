package com.example.vnpchallenge.screen;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vnpchallenge.R;
import com.example.vnpchallenge.model.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateOrderFragment extends Fragment {

    EditText edtFromAddress;
    TextView tvDate;
    EditText edtReceiverName;
    EditText edtToAdress;
    EditText edtToNumber;
    RadioGroup rgType;
    EditText sizeL;
    EditText sizeR;
    EditText sizeH;
    EditText edtWeight;
    EditText edtNote;
    Button btnCreate;

    public CreateOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindData();

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fromAddress = edtFromAddress.getText().toString();
                Date date = new Date();
                try {
                    date = new SimpleDateFormat("dd/MM/yyy").parse(tvDate.getText().toString());
                } catch (Exception e) {
                    e.toString();
                }
                String toName = edtReceiverName.getText().toString();
                String toAddress= edtToAdress.getText().toString();
                String toNumber = edtToNumber.getText().toString();
                Integer type = rgType.getCheckedRadioButtonId();
                float hSize = Float.valueOf(sizeH.getText().toString());
                float rSize = Float.valueOf(sizeR.getText().toString());
                float lSize = Float.valueOf(sizeL.getText().toString());
                float weight = Float.valueOf(edtWeight.getText().toString());
                String note = edtNote.getText().toString();

                Order order = new Order(fromAddress, toAddress, date.getTime(), toName, toNumber, weight, rSize, lSize, hSize, note, rSize*hSize*lSize,type);
                if (checkValidate(order)) {
                    postData(order);
                } else {
                    Toast.makeText(getContext(), "Please fill all the required fields.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date = new Date(System.currentTimeMillis());
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), dateSetListener, 2019, date.getMonth(), date.getDay());
                datePickerDialog.show();
            }
        });
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            tvDate.setText(dayOfMonth+"/"+(month+1)+"/"+year);
        }
    };

    private Boolean checkValidate(Order order) {
        return true;
    }

    private void postData(Order order) {
    }

    private void bindData() {
        edtFromAddress = getView().findViewWithTag(R.id.edt_from_address);
        tvDate = getView().findViewById(R.id.tv_date);
        edtReceiverName = getView().findViewById(R.id.edt_receiver_name);
        edtToAdress = getView().findViewById(R.id.edt_to_address);
        edtToNumber = getView().findViewById(R.id.edt_to_number);
        rgType = getView().findViewById(R.id.rg_type);
        sizeH = getView().findViewById(R.id.size_h);
        sizeL = getView().findViewById(R.id.size_l);
        sizeR = getView().findViewById(R.id.size_r);
        edtWeight = getView().findViewById(R.id.edt_weight);
        edtNote = getView().findViewById(R.id.edt_note);
        btnCreate = getView().findViewById(R.id.btn_create);
    }

}
