import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "producto")
public class ModelProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreP;
    private Double precioP;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public Double getPrecioP() {
        return precioP;
    }

    public void setPrecioP(Double precioP) {
        this.precioP = precioP;
    }

    public ModelProducto(Long id, String nombreP, Double precioP) {
        this.id = id;
        this.nombreP = nombreP;
        this.precioP = precioP;
    }

    @Override
    public String toString() {
        return "ModelProducto{" +
                "id=" + id +
                ", nombreP='" + nombreP + '\'' +
                ", precioP=" + precioP +
                '}';
    }
    //  Constructor vacío obligatorio
    public ModelProducto() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ModelProducto that = (ModelProducto) o;
        return Objects.equals(id, that.id) && Objects.equals(nombreP, that.nombreP) && Objects.equals(precioP, that.precioP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreP, precioP);
    }
}

