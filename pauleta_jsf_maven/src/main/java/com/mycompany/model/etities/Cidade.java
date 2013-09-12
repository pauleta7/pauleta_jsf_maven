package com.mycompany.model.etities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="cidade")
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdCidade",nullable=false)
    private Integer idCidade;
    @Column(name="Nome",length=80,nullable=false)
    private String nome;
    
    @OneToMany
    @ForeignKey(name="CidadeEndereco")
    private List<Endereco>enderecos;
    public Cidade() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.idCidade != null ? this.idCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (this.idCidade != other.idCidade && (this.idCidade == null || !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }
    
}
