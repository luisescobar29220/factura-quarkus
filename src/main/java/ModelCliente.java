import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cliente")
public class ModelCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rucC;
    private String nameC;
    private String emailC;
    private String celular;
    private String direccionC;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRucC() {
        return rucC;
    }

    public void setRucC(String rucC) {
        this.rucC = rucC;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    public String getEmailC() {
        return emailC;
    }

    public void setEmailC(String emailC) {
        this.emailC = emailC;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccionC() {
        return direccionC;
    }

    public void setDireccionC(String direccionC) {
        this.direccionC = direccionC;
    }

    @Override
    public String toString() {
        return "ModelCliente{" +
                "id=" + id +
                ", rucC=" + rucC +
                ", nameC='" + nameC + '\'' +
                ", emailC='" + emailC + '\'' +
                ", celular='" + celular + '\'' +
                ", direccionC='" + direccionC + '\'' +
                '}';
    }
    //  Constructor vacío obligatorio
    public ModelCliente() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ModelCliente that = (ModelCliente) o;
        return Objects.equals(id, that.id) && Objects.equals(rucC, that.rucC) && Objects.equals(nameC, that.nameC) && Objects.equals(emailC, that.emailC) && Objects.equals(celular, that.celular) && Objects.equals(direccionC, that.direccionC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rucC, nameC, emailC, celular, direccionC);
    }
}
