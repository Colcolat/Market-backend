package mx.edu.tecdesoftware.market_backend.persistence.crud;

import mx.edu.tecdesoftware.market_backend.persistence.entity.CompraProducto;
import mx.edu.tecdesoftware.market_backend.persistence.entity.CompraProductoPK;
import org.springframework.data.repository.CrudRepository;

public interface CompraProductoCrudRepository extends CrudRepository<CompraProducto, CompraProductoPK> {

    //Eliminar los detalles de compra que referencian a un producto
    void deleteByIdIdProducto(Integer idProducto);
}
