package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "beneficiario")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do beneficiário", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "Nome do beneficiário", example = "João da Silva")
    private String nome;

    @NotNull
    @Schema(description = "Número de telefone do beneficiário", example = "+55 11 98765-4321")
    private String telefone;

    @Temporal(TemporalType.DATE)
    @Schema(description = "Data de nascimento do beneficiário", example = "1985-05-20")
    private Date dataNascimento;

    @Temporal(TemporalType.DATE)
    @Schema(description = "Data de inclusão do beneficiário no sistema", example = "2024-07-21")
    private Date dataInclusao;

    @Temporal(TemporalType.DATE)
    @Schema(description = "Data da última atualização das informações do beneficiário", example = "2024-07-21")
    private Date dataAtualizacao;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties
    @Schema(description = "Lista de documentos associados ao beneficiário")
    private List<Documento> documentos;

    public Beneficiario() {}

    public Beneficiario(Long id, @NotNull String nome, @NotNull String telefone, Date dataNascimento, Date dataInclusao,
                        Date dataAtualizacao, List<Documento> documentos) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataInclusao = dataInclusao;
        this.dataAtualizacao = dataAtualizacao;
        this.documentos = documentos;
    }

    // Getters e Setters

   

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
	
	 @Override
	    public String toString() {
	        return "Beneficiario [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", dataNascimento=" + dataNascimento
	                + ", dataInclusao=" + dataInclusao + ", dataAtualizacao=" + dataAtualizacao + "]";
	    }
}
