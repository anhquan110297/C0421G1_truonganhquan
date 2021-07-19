package _thi_module2.models;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private int idProduct;
    private int codeProduct;
    private int price;
    private int amount;
    private String producer;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(int codeProduct) {
        this.codeProduct = codeProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Product() {
    }

    public Product(int idProduct, int codeProduct, int price, int amount, String producer) {
        this.idProduct = idProduct;
        this.codeProduct = codeProduct;
        this.price = price;
        this.amount = amount;
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", codeProduct=" + codeProduct +
                ", price=" + price +
                ", amount=" + amount +
                ", producer='" + producer;

    }
}
