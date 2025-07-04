package dashboard.example.dashboard.controller;

import dashboard.example.dashboard.dto.*;
import dashboard.example.dashboard.entity.Product;
import dashboard.example.dashboard.repository.ProductRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DashboardController {

    private final ProductRepository productRepository;

    public DashboardController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/summary")
    public Summary getSummary(
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        List<Product> products = (from != null && to != null)
            ? productRepository.findByDateBetween(from, to)
            : productRepository.findAll();
        int totalSales = products.stream().mapToInt(Product::getUnits).sum();
        int revenue = products.stream().mapToInt(Product::getRevenue).sum();
        int orders = products.size();
        int avgOrder = orders > 0 ? revenue / orders : 0;
        return new Summary(totalSales, revenue, orders, avgOrder);
    }

    @GetMapping("/chart/line")
    public ChartData getLineChartData(
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        List<Product> products = (from != null && to != null)
            ? productRepository.findByDateBetween(from, to)
            : productRepository.findAll();

        // Group by date and sum revenue
        Map<LocalDate, Integer> dateToRevenue = new TreeMap<>();
        for (Product p : products) {
            dateToRevenue.merge(p.getDate(), p.getRevenue(), Integer::sum);
        }
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        for (Map.Entry<LocalDate, Integer> entry : dateToRevenue.entrySet()) {
            labels.add(entry.getKey().toString());
            data.add(entry.getValue());
        }
        return new ChartData(labels, data);
    }

    @GetMapping("/chart/bar")
    public ChartData getBarChartData(
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        List<Product> products = (from != null && to != null)
            ? productRepository.findByDateBetween(from, to)
            : productRepository.findAll();

        // Group by product and sum revenue
        Map<String, Integer> productToRevenue = new LinkedHashMap<>();
        for (Product p : products) {
            productToRevenue.merge(p.getProduct(), p.getRevenue(), Integer::sum);
        }
        List<String> labels = new ArrayList<>(productToRevenue.keySet());
        List<Integer> data = new ArrayList<>(productToRevenue.values());
        return new ChartData(labels, data);
    }

    @GetMapping("/products")
    public List<ProductData> getTopProducts(
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        List<Product> products = (from != null && to != null)
            ? productRepository.findByDateBetween(from, to)
            : productRepository.findAll();

        // Group by product and sum units and revenue
        Map<String, ProductData> productMap = new LinkedHashMap<>();
        for (Product p : products) {
            productMap.compute(p.getProduct(), (k, v) -> {
                if (v == null) {
                    return new ProductData(p.getProduct(), p.getUnits(), p.getRevenue(), null);
                } else {
                    v.units += p.getUnits();
                    v.revenue += p.getRevenue();
                    return v;
                }
            });
        }
        return new ArrayList<>(productMap.values());
    }
}
