package com.example.Product.services;

import com.example.Product.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final List<Product> listProduct = new ArrayList<>();

    public ProductService() {
        this.listProduct.add(new Product(1, "Sản phầm 1", "1.jpg", 29312));
        this.listProduct.add(new Product(2, "Sản phầm 2", "2.jpg", 124246));
    }
    
    public void addProduct(Product newProduct) {
        listProduct.add(newProduct);
    }
    
    public void deleteProduct(Product Product) {
        listProduct.remove(Product);
    }

    public List<Product> GetAll() {
        return listProduct;
    }

    public Product get(int id) {
        return listProduct.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void edit(Product editProduct) {
        Product find = listProduct.get(editProduct.getId());
        if (find != null) {
            find.setName(editProduct.getName());
            find.setImage(editProduct.getImage());
            find.setPrice(editProduct.getPrice());
        }
    }
    
    public List<Product> searchProducts(String query) {
        String cleanedQuery = query.trim();
        return listProduct.stream()
            .filter(product -> product.getPrice() == Integer.parseInt(cleanedQuery) || product.getId() == Integer.parseInt(cleanedQuery))
            .collect(Collectors.toList());
    }
}
