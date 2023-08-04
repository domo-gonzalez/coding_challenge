package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trade")
public class Trade {
    @Id
    private long id;

    @Column(name = "trade_type")
    private String tradeType;

    @Column(name = "trade_currency")
    private String tradeCurrency;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "trade_settlement_date")
    private String tradeSettlementDate;

    @Column(name = "trade_status")
    private String tradeStatus;

    @Column(name = "trade_date")
    private String tradeDate;

//    @Column(name = "security_id")
//    private long securityId;

    @Column(name = "counter_party")
    private String counterParty;

    @Column(name = "book_name")
    private String bookName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(String tradeCurrency) {
        this.tradeCurrency = tradeCurrency;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getTradeSettlementDate() {
        return tradeSettlementDate;
    }

    public void setTradeSettlementDate(String tradeSettlementDate) {
        this.tradeSettlementDate = tradeSettlementDate;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

//    public long getSecurityId() {
//        return securityId;
//    }
//
//    public void setSecurityId(long securityId) {
//        this.securityId = securityId;
//    }

    public String getCounterParty() {
        return counterParty;
    }

    public void setCounterParty(String counterParty) {
        this.counterParty = counterParty;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", tradeType='" + tradeType + '\'' +
                ", tradeCurrency='" + tradeCurrency + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", tradeSettlementDate='" + tradeSettlementDate + '\'' +
                ", tradeStatus='" + tradeStatus + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
//                ", securityId=" + securityId +
                ", counterParty='" + counterParty + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
