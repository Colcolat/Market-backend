package market_backend.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table
public class CompraProducto {
    @EmbeddedId
    private CompraProductoPK id;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;

    private Integer cantidad;
    private Double total;
    private Boolean estado;
}
