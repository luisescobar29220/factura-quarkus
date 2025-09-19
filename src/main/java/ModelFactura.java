import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "factura")
public class ModelFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate createF;

    private Double totalF;

    // Relación con Producto
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ModelProducto producto;

    // Relación con Factura
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ModelCliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreateF() {
        return createF;
    }

    public void setCreateF(LocalDate createF) {
        this.createF = createF;
    }

    public Double getTotalF() {
        return totalF;
    }

    public void setTotalF(Double totalF) {
        this.totalF = totalF;
    }
<<<<<<< HEAD
    public void setCliente(ModelCliente cliente) {
        this.cliente = cliente;
    }

    public void setProducto(ModelProducto producto) {
        this.producto = producto;
    }
=======
>>>>>>> 01a66660be94b083f99cdfd2dc5801f957b6f604

    public ModelFactura(Long id, LocalDate createF, Double totalF) {
        this.id = id;
        this.createF = createF;
        this.totalF = totalF;
    }
    // 🔥 Constructor vacío obligatorio
    public ModelFactura() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ModelFactura that = (ModelFactura) o;
        return Objects.equals(id, that.id) && Objects.equals(createF, that.createF) && Objects.equals(totalF, that.totalF) && Objects.equals(producto, that.producto) && Objects.equals(cliente, that.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createF, totalF, producto, cliente);
    }
}
