package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        product.setProductId(String.valueOf(UUID.randomUUID()));
        productData.add(product);
        return product;
    }

    public Product update(Product product) {
        for (int i = 0; i < productData.size(); i++) {
            Product current = productData.get(i);
            if (current.getProductId().equals(product.getProductId())) {
                return productData.set(i, product);
            }
        }
        return null;
    }

    public boolean delete(Product product) {
        return productData.remove(product);
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }
}
