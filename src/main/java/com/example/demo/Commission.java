package com.example.demo;

import java.time.LocalDate;
import java.util.Date;

public class Commission {
    private LocalDate date;
    private String walletType;
    private String walletNumber;
    private String amount;
    private String comment;

    private String walletShortCode;

    public String getWalletShortCode() {
        return walletShortCode;
    }

    public void setWalletShortCode(String walletShortCode) {
        this.walletShortCode = walletShortCode;
    }

    public Commission() {
    }

    @Override
    public String toString() {
        return "Commission{" +
                "date=" + date +
                ", walletType='" + walletType + '\'' +
                ", walletNumber='" + walletNumber + '\'' +
                ", amount='" + amount + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public Commission(LocalDate date, String walletType, String walletNumber, String amount, String comment) {
        this.date = date;
        this.walletType = walletType;
        this.walletNumber = walletNumber;
        this.amount = amount;
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getWalletType() {
        return walletType;
    }

    public void setWalletType(String walletType) {
        this.walletType = walletType;
    }

    public String getWalletNumber() {
        return walletNumber;
    }

    public void setWalletNumber(String walletNumber) {
        this.walletNumber = walletNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
