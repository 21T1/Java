package com.example.model;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Rate implements Serializable {
    private String type;
    private String imageurl;
    private Bitmap bitmap;
    private String buyCash;
    private String buyTransfer;
    private String sellCash;
    private String sellTransfer;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getBuyCash() {
        return buyCash;
    }

    public void setBuyCash(String buyCash) {
        this.buyCash = buyCash;
    }

    public String getBuyTransfer() {
        return buyTransfer;
    }

    public void setBuyTransfer(String buyTransfer) {
        this.buyTransfer = buyTransfer;
    }

    public String getSellCash() {
        return sellCash;
    }

    public void setSellCash(String sellCash) {
        this.sellCash = sellCash;
    }

    public String getSellTransfer() {
        return sellTransfer;
    }

    public void setSellTransfer(String sellTransfer) {
        this.sellTransfer = sellTransfer;
    }

    public Rate(String type, String imageurl, String buyCash, String buyTransfer, String sellCash, String sellTransfer) {
        this.type = type;
        this.imageurl = imageurl;
        this.buyCash = buyCash;
        this.buyTransfer = buyTransfer;
        this.sellCash = sellCash;
        this.sellTransfer = sellTransfer;
    }

    public Rate() {
    }

    @Override
    public String toString() {
        return "Rate{" +
                "type='" + type + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", buyCash='" + buyCash + '\'' +
                ", buyTransfer='" + buyTransfer + '\'' +
                ", sellCash='" + sellCash + '\'' +
                ", sellTransfer='" + sellTransfer + '\'' +
                '}';
    }
}
