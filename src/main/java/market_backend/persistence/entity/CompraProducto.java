package market_backend.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table
public class CompraProducto {
    @EmbeddedId
    private CompraProductoPK id;

    private Integer cantidad;
    private Double total;
    private Boolean estado;
}
