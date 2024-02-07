package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public Product findById(String id);
    public Product update(Product product);
    public boolean delete(Product product);
    public List<Product> findAll();
}
