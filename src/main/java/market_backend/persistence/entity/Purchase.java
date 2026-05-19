package market_backend.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "compras")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_compra")
    private Integer IdCompra;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;

    private String estado;

}
