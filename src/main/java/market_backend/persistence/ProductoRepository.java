package market_backend.persistence;

import market_backend.domain.Product;
import market_backend.persistence.crud.ProductoCrudRepository;
import market_backend.persistence.entity.Producto;
import market_backend.persistence.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements market_backend.domain.repository.ProductRepository {

    @Autowired
    private ProductoCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    public Optional<List<Product>> getScarseProducts(int quantity){
        List<Producto> productos = productCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return Optional.of(productMapper.toProducts(productos));
    }

    public Optional<Product> getProduct(int productId){
        return productCrudRepository.findById(productId).map(product -> productMapper.toProduct(product));
    }

    public Product save(Product product){
        Producto producto = productMapper.toProducto(product);
        Producto saved = productCrudRepository.save(producto);
        return productMapper.toProduct(saved);
    }

    public void delete(int productId){
        productCrudRepository.deleteById(productId);
    }

}
