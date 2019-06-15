package com.example.vnpchallenge.model;

import java.util.Date;

public class Order {
    private String fromAddress;
    private String toAddress;
    private Date pickupTime;
    private String receiverName;
    private String receiverNumber;
    private float packageWeight;
    private float sizeW;
    private float sizeL;
    private float sizeH;
    private String note;
    private float fee;
    private int type;

    public Order(String fromAddress, String toAddress, Date pickupTime, String receiverName, String receiverNumber, float packageWeight, float sizeW, float sizeL, float sizeH, String note, float fee, int type) {
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.pickupTime = pickupTime;
        this.receiverName = receiverName;
        this.receiverNumber = receiverNumber;
        this.packageWeight = packageWeight;
        this.sizeW = sizeW;
        this.sizeL = sizeL;
        this.sizeH = sizeH;
        this.note = note;
        this.fee = fee;
        this.type = type;
    }
}
