package com.example.vnpchallenge.model;

import java.io.Serializable;

public class Order implements Serializable {
    private int id;
    private String fromAddress;
    private String toAddress;
    private long pickupTime;
    private String receiverName;
    private String receiverNumber;
    private double packageWeight;
    private double sizeW;
    private double sizeL;
    private double sizeH;
    private String note;
    private double fee;
    private int type;

    public Order(int id,
                 String fromAddress,
                 String toAddress,
                 long pickupTime,
                 String receiverName,
                 String receiverNumber,
                 double packageWeight,
                 double sizeW,
                 double sizeL,
                 double sizeH,
                 String note,
                 double fee,
                 int type) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public long getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(long pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverNumber() {
        return receiverNumber;
    }

    public void setReceiverNumber(String receiverNumber) {
        this.receiverNumber = receiverNumber;
    }

    public double getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(double packageWeight) {
        this.packageWeight = packageWeight;
    }

    public double getSizeW() {
        return sizeW;
    }

    public void setSizeW(double sizeW) {
        this.sizeW = sizeW;
    }

    public double getSizeL() {
        return sizeL;
    }

    public void setSizeL(double sizeL) {
        this.sizeL = sizeL;
    }

    public double getSizeH() {
        return sizeH;
    }

    public void setSizeH(double sizeH) {
        this.sizeH = sizeH;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", pickupTime=" + pickupTime +
                ", receiverName='" + receiverName + '\'' +
                ", receiverNumber='" + receiverNumber + '\'' +
                ", packageWeight=" + packageWeight +
                ", sizeW=" + sizeW +
                ", sizeL=" + sizeL +
                ", sizeH=" + sizeH +
                ", note='" + note + '\'' +
                ", fee=" + fee +
                ", type=" + type +
                '}';
    }


}
