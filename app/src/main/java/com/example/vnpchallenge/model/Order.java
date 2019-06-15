package com.example.vnpchallenge.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "orders")
public class Order {
    @PrimaryKey(autoGenerate = true)
    private long id;
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

    @Ignore
    public Order(long id,
                 String fromAddress,
                 String toAddress,
                 Date pickupTime,
                 String receiverName,
                 String receiverNumber,
                 float packageWeight,
                 float sizeW,
                 float sizeL,
                 float sizeH,
                 String note,
                 float fee,
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
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

    public float getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(float packageWeight) {
        this.packageWeight = packageWeight;
    }

    public float getSizeW() {
        return sizeW;
    }

    public void setSizeW(float sizeW) {
        this.sizeW = sizeW;
    }

    public float getSizeL() {
        return sizeL;
    }

    public void setSizeL(float sizeL) {
        this.sizeL = sizeL;
    }

    public float getSizeH() {
        return sizeH;
    }

    public void setSizeH(float sizeH) {
        this.sizeH = sizeH;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
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
                "id=" + id +
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
