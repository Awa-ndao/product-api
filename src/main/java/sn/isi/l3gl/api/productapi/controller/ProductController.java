package sn.isi.l3gl.api.productapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.isi.l3gl.core.productcore.model.Product;
import sn.isi.l3gl.core.productcore.service.ProductService;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @PutMapping("/{id}")
    public Product updateQuantity(@PathVariable Long id, @RequestParam Integer quantity) {
        return productService.updateQuantity(id, quantity);
    }

    @GetMapping("/low-stock/count")
    public long countLowStockProducts() {
        return productService.countLowStockProducts();
    }
}