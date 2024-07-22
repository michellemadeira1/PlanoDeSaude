package model;

import java.util.Date;
import java.util.List;

public class BeneficiarioDto {
    private Long id;
    private String nome;
    private String telefone;
    private Date dataNascimento;
    private Date dataInclusao;
    
    public BeneficiarioDto() {}
    public BeneficiarioDto(Long id, String nome, String telefone, Date dataNascimento, Date dataInclusao,
			Date dataAtualizacao, List<DocumentoDto> documentos) {
		
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.dataInclusao = dataInclusao;
		this.dataAtualizacao = dataAtualizacao;
		this.documentos = documentos;
	}
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
	public List<DocumentoDto> getDocumentos() {
		return documentos;
	}
	public void setDocumentos(List<DocumentoDto> documentos) {
		this.documentos = documentos;
	}
	private Date dataAtualizacao;
    private List<DocumentoDto> documentos;

    // Construtores, getters e setters
}

