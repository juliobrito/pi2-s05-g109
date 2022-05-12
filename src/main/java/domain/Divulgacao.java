package domain;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Divulgacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String descricao;
    private int minutos_inicio, hora_inicio, dia_inicio, mes_inicio, ano_inicio;
    private int minutos_fim, hora_fim, dia_fim, mes_fim, ano_fim;
    //private String link_inscricao;
    //private String cod_promocao;

    public Divulgacao() {
    }

    public Divulgacao(String nome, String descricao,
                      int minutos_inicio, int hora_inicio, int dia_inicio, int mes_inicio, int ano_inicio,
                      int minutos_fim, int hora_fim, int dia_fim, int mes_fim, int ano_fim) {
        this.nome = nome;
        this.descricao = descricao;

        this.minutos_inicio = minutos_inicio;
        this.hora_inicio = hora_inicio;
        this.dia_inicio = dia_inicio;
        this.mes_inicio = mes_inicio;
        this.ano_inicio = ano_inicio;

        this.minutos_fim = minutos_fim;
        this.hora_fim = hora_fim;
        this.dia_fim = dia_fim;
        this.mes_fim = mes_fim;
        this.ano_fim = ano_fim;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getMinutos_inicio() {
        return minutos_inicio;
    }

    public void setMinutos_inicio(int minutos_inicio) {
        this.minutos_inicio = minutos_inicio;
    }

    public int getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(int hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getDia_inicio() {
        return dia_inicio;
    }

    public void setDia_inicio(int dia_inicio) {
        this.dia_inicio = dia_inicio;
    }

    public int getMes_inicio() {
        return mes_inicio;
    }

    public void setMes_inicio(int mes_inicio) {
        this.mes_inicio = mes_inicio;
    }

    public int getAno_inicio() {
        return ano_inicio;
    }

    public void setAno_inicio(int ano_inicio) {
        this.ano_inicio = ano_inicio;
    }

    public int getMinutos_fim() {
        return minutos_fim;
    }

    public void setMinutos_fim(int minutos_fim) {
        this.minutos_fim = minutos_fim;
    }

    public int getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(int hora_fim) {
        this.hora_fim = hora_fim;
    }

    public int getDia_fim() {
        return dia_fim;
    }

    public void setDia_fim(int dia_fim) {
        this.dia_fim = dia_fim;
    }

    public int getMes_fim() {
        return mes_fim;
    }

    public void setMes_fim(int mes_fim) {
        this.mes_fim = mes_fim;
    }

    public int getAno_fim() {
        return ano_fim;
    }

    public void setAno_fim(int ano_fim) {
        this.ano_fim = ano_fim;
    }

    @Override
    public String toString() {
        return "Divulgacao{" +
                "id=" + id +
                ", nome='" + nome + '|' +
                ", descricao='" + descricao + '|' +
                ", minutos_inicio=" + minutos_inicio +
                ", hora_inicio=" + hora_inicio +
                ", dia_inicio=" + dia_inicio +
                ", mes_inicio=" + mes_inicio +
                ", ano_inicio=" + ano_inicio + '|' +
                ", minutos_fim=" + minutos_fim +
                ", hora_fim=" + hora_fim +
                ", dia_fim=" + dia_fim +
                ", mes_fim=" + mes_fim +
                ", ano_fim=" + ano_fim +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Divulgacao that = (Divulgacao) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
