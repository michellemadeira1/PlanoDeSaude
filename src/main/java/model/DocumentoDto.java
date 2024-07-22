package model;

import java.util.Date;



public class DocumentoDto {
	
	private Long id;
    private String tipoDocumento;
    private String descricao;
    private Date dataInclusao;
    private Date dataAtualizacao;
    private BeneficiarioDto beneficiario;
	
	
    public DocumentoDto() {}
	
   
	public DocumentoDto(Long id, String tipoDocumento, String descricao, Date dataInclusao, Date dataAtualizacao,
			BeneficiarioDto beneficiario) {
		super();
		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.descricao = descricao;
		this.dataInclusao = dataInclusao;
		this.dataAtualizacao = dataAtualizacao;
		this.beneficiario = beneficiario;
	}


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


	public BeneficiarioDto getBeneficiario() {
		return beneficiario;
	}


	public void setBeneficiario(BeneficiarioDto beneficiario) {
		this.beneficiario = beneficiario;
	}


	

    // Construtores, getters e setters
}
