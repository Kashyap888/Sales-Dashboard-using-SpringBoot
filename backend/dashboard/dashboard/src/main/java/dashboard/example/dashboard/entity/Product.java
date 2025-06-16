package dashboard.example.dashboard.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;
    private int units;
    private int revenue;
    private LocalDate date;

    // Getters and setters
    public Long getId() { return id; }
    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }
    public int getUnits() { return units; }
    public void setUnits(int units) { this.units = units; }
    public int getRevenue() { return revenue; }
    public void setRevenue(int revenue) { this.revenue = revenue; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
