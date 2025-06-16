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
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        for (Product p : products) {
            labels.add(p.getDate().toString());
            data.add(p.getRevenue());
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
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        for (Product p : products) {
            labels.add(p.getProduct());
            data.add(p.getRevenue());
        }
        return new ChartData(labels, data);
    }

    @GetMapping("/products")
    public List<Product> getTopProducts(
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        if (from != null && to != null) {
            return productRepository.findByDateBetween(from, to);
        } else {
            return productRepository.findAll();
        }
    }
}
