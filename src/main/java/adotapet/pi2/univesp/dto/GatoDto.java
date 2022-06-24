package adotapet.pi2.univesp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class GatoDto {


    @NotBlank
    @Size(max = 20)
    private String porte;

    private int idade;

    @NotBlank
    @Size(max = 20)
    private String vacina;

    @NotBlank
    @Size(max = 20)
    private String saude;

    @NotBlank
    @Size(max = 20)
    private String cuidado_especial;

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
