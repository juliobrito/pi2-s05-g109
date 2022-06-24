package adotapet.pi2.univesp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "cachorro")
public class CachorroModel {

    @Id
    private int id;

    @Column(nullable = false, length = 20)
    private String porte;

    @Column(nullable = false, length = 20)
    private int idade;

    @Column(nullable = false, length = 20)
    private String vacina;

    @Column(nullable = false, length = 20)
    private String saude;

    @Column(nullable = false, length = 20)
    private String cuidado_especial;

    //@Column(nullable = false)
    //private String foto; //local com foto disponível

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public String getSaude() {
        return saude;
    }

    public void setSaude(String saude) {
        this.saude = saude;
    }

    public String getCuidado_especial() {
        return cuidado_especial;
    }

    public void setCuidado_especial(String cuidado_especial) {
        this.cuidado_especial = cuidado_especial;
    }
}
