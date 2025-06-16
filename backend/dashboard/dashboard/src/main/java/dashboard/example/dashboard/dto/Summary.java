package dashboard.example.dashboard.dto;

public class Summary {
    public int totalSales;
    public int revenue;
    public int orders;
    public int avgOrder;

    public Summary(int totalSales, int revenue, int orders, int avgOrder) {
        this.totalSales = totalSales;
        this.revenue = revenue;
        this.orders = orders;
        this.avgOrder = avgOrder;
    }
}

