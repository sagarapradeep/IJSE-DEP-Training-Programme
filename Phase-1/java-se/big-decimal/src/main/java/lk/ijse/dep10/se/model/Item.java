package lk.ijse.dep10.se.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable {
    private String code;
    private String description;
    private BigDecimal buyingPrice;
    private BigDecimal sellingPrice;
    int qty;

    public Item() {

    }

    public Item(String code, String description, BigDecimal buyingPrice, BigDecimal sellingPrice, int qty) {
        this.code = code;
        this.description = description;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.qty = qty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getProfit() {
        return sellingPrice.subtract(buyingPrice).setScale(2);
    }

    public BigDecimal getTotal() {
        return buyingPrice.multiply(new BigDecimal(qty)).setScale(2);

    }
    public BigDecimal getTotalProfit() {
        return getProfit().multiply(new BigDecimal(qty)).setScale(2);

    }

//    public BigDecimal getEstTotalProfit() {
//
//    }
}
