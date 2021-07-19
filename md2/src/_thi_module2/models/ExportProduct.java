package _thi_module2.models;

public class ExportProduct extends Product {
    private int exportPrice;
    private String country;

    public ExportProduct() {
    }

    public ExportProduct(int idProduct, int codeProduct, int price, int amount, String producer, int exportPrice, String country) {
        super(idProduct, codeProduct, price, amount, producer);
        this.exportPrice = exportPrice;
        this.country = country;
    }

    public int getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(int exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return super.toString() + "exportPrice=" + exportPrice + "country=" + country + "}";
    }
}
