package market_backend.persistence.crud;

import market_backend.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoriaOrderByNombreAsc(Integer idCategoria);
    List<Producto> findByCantidadStockLessThanAndEstado(Integer cantidad, Boolean estado);
}
