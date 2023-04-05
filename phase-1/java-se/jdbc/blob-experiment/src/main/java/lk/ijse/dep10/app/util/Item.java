package lk.ijse.dep10.app.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;

public class Item implements Serializable {
    private int itemCode;
    private String description;
    private BigDecimal buyingPrice;
    private BigDecimal sellingPrice;
    private BigDecimal profit;
    private int stock;
    private Blob preview;

    public Item(int itemCode, String description, BigDecimal buyingPrice, BigDecimal sellingPrice, BigDecimal profit, int stock, Blob preview) {
        this.itemCode = itemCode;
        this.description = description;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.profit = profit;
        this.stock = stock;
        this.preview = preview;
    }

    public Item() {
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
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

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Blob getPreview() {
        return preview;
    }

    public void setPreview(Blob preview) {
        this.preview = preview;
    }
}
