package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do documento", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "Tipo do documento", example = "Passaporte")
    private String tipoDocumento;

    @NotNull
    @Schema(description = "Descrição do documento", example = "Passaporte válido até 2025")
    private String descricao;

    @Temporal(TemporalType.DATE)
    @Schema(description = "Data de inclusão do documento", example = "2024-07-21")
    private Date dataInclusao;

    @Temporal(TemporalType.DATE)
    @Schema(description = "Data da última atualização do documento", example = "2024-07-21")
    private Date dataAtualizacao;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "beneficiario_id")
    @Schema(description = "Beneficiário associado ao documento")
    private Beneficiario beneficiario;

    public Documento() {}

    public Documento(Long id, String tipoDocumento, String descricao, Date dataInclusao, Date dataAtualizacao, Beneficiario beneficiario) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.descricao = descricao;
        this.dataInclusao = dataInclusao;
        this.dataAtualizacao = dataAtualizacao;
        this.beneficiario = beneficiario;
    }

    // Getters e Setters

   

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
	
	 @Override
	    public String toString() {
	        return "Documento [id=" + id + ", tipoDocumento=" + tipoDocumento + ", descricao=" + descricao
	                + ", dataInclusao=" + dataInclusao + ", dataAtualizacao=" + dataAtualizacao + "]";
	    }
}
