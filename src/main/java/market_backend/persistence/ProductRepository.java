package market_backend.persistence;

import market_backend.persistence.crud.ProductoCrudRepository;
import market_backend.persistence.entity.Producto;

import java.util.List;

public class ProductRepository {

    private ProductoCrudRepository productCrudRepository;
    public List<Producto> getAll(){
        return (List<Producto>) productCrudRepository.findAll();
    }
}
