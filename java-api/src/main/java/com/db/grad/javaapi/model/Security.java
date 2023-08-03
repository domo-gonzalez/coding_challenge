package com.db.grad.javaapi.model;
import javax.persistence.*;

@Entity
@Table(name = "security")
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "coupon_percent")
    private Double coupon_percent;

    @Column(name = "bond_currency")
    private String bond_currency;

    @Column(name = "cusip")
    private String cusip;

    @Column(name = "face_value_mn")
    private int face_value_mn;

    @Column(name = "isin")
    private String isin;

    @Column(name = "issuer_name")
    private String issuer_name;

    @Column(name = "bond_maturity_date")
    private String bond_maturity_date;

    @Column(name = "status")
    private String status;

    @Column(name = "type")
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getCoupon_percent() {
        return coupon_percent;
    }

    public void setCoupon_percent(Double coupon_percent) {
        this.coupon_percent = coupon_percent;
    }

    public String getBond_currency() {
        return bond_currency;
    }

    public void setBond_currency(String bond_currency) {
        this.bond_currency = bond_currency;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public int getFace_value_mn() {
        return face_value_mn;
    }

    public void setFace_value_mn(int face_value_mn) {
        this.face_value_mn = face_value_mn;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getIssuer_name() {
        return issuer_name;
    }

    public void setIssuer_name(String issuer_name) {
        this.issuer_name = issuer_name;
    }

    public String getBond_maturity_date() {
        return bond_maturity_date;
    }

    public void setBond_maturity_date(String bond_maturity_date) {
        this.bond_maturity_date = bond_maturity_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Security{" +
                "id=" + id +
                ", coupon_percent=" + coupon_percent +
                ", bond_currency='" + bond_currency + '\'' +
                ", cusip='" + cusip + '\'' +
                ", face_value_mn=" + face_value_mn +
                ", isin='" + isin + '\'' +
                ", issuer_name='" + issuer_name + '\'' +
                ", bond_maturity_date='" + bond_maturity_date + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
