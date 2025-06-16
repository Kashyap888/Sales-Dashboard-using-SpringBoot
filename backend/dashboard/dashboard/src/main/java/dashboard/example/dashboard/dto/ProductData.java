package dashboard.example.dashboard.dto;

public class ProductData {
    public String product;
    public int units;
    public int revenue;
    public String date;

    public ProductData(String product, int units, int revenue, String date) {
        this.product = product;
        this.units = units;
        this.revenue = revenue;
        this.date = date;
        }
}