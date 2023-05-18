package mk.ukim.finki.emt.product.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.emt.product.domain.exeption.ProductNotFound;
import mk.ukim.finki.emt.product.domain.models.Product;
import mk.ukim.finki.emt.product.domain.models.ProductId;
import mk.ukim.finki.emt.product.domain.repository.ProductRepository;
import mk.ukim.finki.emt.product.services.forms.ProductForm;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    @Override
    public Product findById(@NonNull ProductId id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFound(id.getId()));
    }

    @Override
    public Product createProduct(@NonNull ProductForm product) {
         var newProduct = new Product(product.getName(), product.getQuantity(), product.getPrice());
        return productRepository.saveAndFlush(newProduct);
    }

    @Override
    public Product updateProduct(@NonNull ProductId id, @NonNull ProductForm product) {
        var productToUpdate = findById(id);

        productToUpdate.updateProduct(product.getName(), product.getQuantity(), product.getPrice());

        return productRepository.saveAndFlush(productToUpdate);
    }

    @Override
    public void deleteProduct(@NonNull ProductId id) {
        productRepository.deleteById(id);
        productRepository.flush();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}