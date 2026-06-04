package market_backend.persistence.mappers;

import market_backend.domain.Category;
import market_backend.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
        @org.mapstruct.Mapping(source = "idCategoria", target = "categoryId"),
        @org.mapstruct.Mapping(source = "categoria", target = "category"),
        @org.mapstruct.Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);

}
