package mk.ukim.finki.emt.product.services;

import mk.ukim.finki.emt.product.domain.models.Product;
import mk.ukim.finki.emt.product.domain.models.ProductId;
import mk.ukim.finki.emt.product.services.forms.ProductForm;

import java.util.List;

public interface IProductService {
    Product findById(ProductId id);

    Product createProduct(ProductForm product);

    Product updateProduct(ProductId id, ProductForm product);

    void deleteProduct(ProductId id);

    List<Product> findAll();
}
