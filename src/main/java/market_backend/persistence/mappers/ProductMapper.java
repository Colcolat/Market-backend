package market_backend.persistence.mappers;

import market_backend.domain.Product;
import market_backend.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses= CategoryMapper.class)
public interface ProductMapper {
    @Mappings({
        @org.mapstruct.Mapping(source = "idProducto", target = "productId"),
        @org.mapstruct.Mapping(source = "nombre", target = "name"),
        @org.mapstruct.Mapping(source = "idCategoria", target = "categoryId"),
        @org.mapstruct.Mapping(source = "precioVenta", target = "price"),
        @org.mapstruct.Mapping(source = "cantidadStock", target = "stock"),
        @org.mapstruct.Mapping(source = "estado", target = "active")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);


    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product prdocut);
}
