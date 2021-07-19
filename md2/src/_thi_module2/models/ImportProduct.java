package _thi_module2.models;

public class ImportProduct extends Product {
    private int importPrice;
    private String province;
    private int tax;

    public int getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(int importPrice) {
        this.importPrice = importPrice;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public ImportProduct() {
    }

    public ImportProduct(int idProduct, int codeProduct, int price, int amount, String producer, int importPrice, String province, int tax) {
        super(idProduct, codeProduct, price, amount, producer);
        this.importPrice = importPrice;
        this.province = province;
        this.tax = tax;
    }

    @Override
    public String toString() {
        return super.toString()+ "importPrice=" + importPrice + "province=" + province + "tax=" + tax + "}";
    }
}
