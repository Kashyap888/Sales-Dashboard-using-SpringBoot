package dashboard.example.dashboard.repository;

import dashboard.example.dashboard.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can add custom queries here if needed
    List<Product> findByDateBetween(LocalDate from, LocalDate to);
}
