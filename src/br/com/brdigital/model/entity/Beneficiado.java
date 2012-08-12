package br.com.brdigital.model.entity;

public class Beneficiado {
	private int idBeneficiado;
	private String nome;
	private String apelido;
	private TipoSexo genero;
	private String conjugue;
	private String rg;
	private String cpf;
	private String profissao;
	
	private Endereco endereco;
	
	private Contato contato;
	
	/**
	 * @param idBeneficiado
	 * @param nome
	 * @param apelido
	 * @param genero
	 * @param conjugue
	 * @param rg
	 * @param cpf
	 * @param profissao
	 * @param endereco
	 */
	public Beneficiado(int idBeneficiado, String nome, String apelido,
			TipoSexo genero, String conjugue, String rg, String cpf,
			String profissao, Endereco endereco) {
		super();
		this.idBeneficiado = idBeneficiado;
		this.nome = nome;
		this.apelido = apelido;
		this.genero = genero;
		this.conjugue = conjugue;
		this.rg = rg;
		this.cpf = cpf;
		this.profissao = profissao;
		this.endereco = endereco;
	}
	/**
	 * @param idBeneficiado
	 * @param nome
	 * @param apelido
	 * @param genero
	 * @param conjugue
	 * @param rg
	 * @param cpf
	 * @param profissao
	 */
	public Beneficiado(String nome, String apelido,
			TipoSexo genero, String conjugue, String rg, String cpf,
			String profissao) {
		super();
		this.idBeneficiado = idBeneficiado;
		this.nome = nome;
		this.apelido = apelido;
		this.genero = genero;
		this.conjugue = conjugue;
		this.rg = rg;
		this.cpf = cpf;
		this.profissao = profissao;
	}
	/**
	 * @param idBeneficiado
	 * @param nome
	 * @param apelido
	 * @param genero
	 * @param conjugue
	 * @param cpf
	 */
	public Beneficiado(String nome, String apelido,
			TipoSexo genero, String conjugue, String cpf) {
		super();
		this.nome = nome;
		this.apelido = apelido;
		this.genero = genero;
		this.conjugue = conjugue;
		this.cpf = cpf;
	}
	/**
	 * @param idBeneficiado
	 * @param nome
	 * @param genero
	 * @param conjugue
	 * @param cpf
	 */
	public Beneficiado(String nome, TipoSexo genero,
			String conjugue, String cpf) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.conjugue = conjugue;
		this.cpf = cpf;
	}
	/**
	 * @param idBeneficiado
	 * @param nome
	 * @param genero
	 * @param cpf
	 */
	public Beneficiado(String nome, TipoSexo genero,
			String cpf) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.cpf = cpf;
	}
	/**
	 * 
	 */
	public Beneficiado() {
		super();
	}
	/**
	 * @return the contato
	 */
	public Contato getContato() {
		return contato;
	}
	/**
	 * @param contato the contato to set
	 */
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	/**
	 * @return the idBeneficiado
	 */
	public int getIdBeneficiado() {
		return idBeneficiado;
	}
	/**
	 * @param idBeneficiado the idBeneficiado to set
	 */
	public void setIdBeneficiado(int idBeneficiado) {
		this.idBeneficiado = idBeneficiado;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the apelido
	 */
	public String getApelido() {
		return apelido;
	}
	/**
	 * @param apelido the apelido to set
	 */
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	/**
	 * @return the genero
	 */
	public TipoSexo getGenero() {
		return genero;
	}
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(TipoSexo genero) {
		this.genero = genero;
	}
	/**
	 * @return the conjugue
	 */
	public String getConjugue() {
		return conjugue;
	}
	/**
	 * @param conjugue the conjugue to set
	 */
	public void setConjugue(String conjugue) {
		this.conjugue = conjugue;
	}
	/**
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}
	/**
	 * @param rg the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the profissao
	 */
	public String getProfissao() {
		return profissao;
	}
	/**
	 * @param profissao the profissao to set
	 */
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result
				+ ((conjugue == null) ? 0 : conjugue.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + idBeneficiado;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((profissao == null) ? 0 : profissao.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beneficiado other = (Beneficiado) obj;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (conjugue == null) {
			if (other.conjugue != null)
				return false;
		} else if (!conjugue.equals(other.conjugue))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (genero != other.genero)
			return false;
		if (idBeneficiado != other.idBeneficiado)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (profissao == null) {
			if (other.profissao != null)
				return false;
		} else if (!profissao.equals(other.profissao))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Beneficiado [idBeneficiado=");
		builder.append(idBeneficiado);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", apelido=");
		builder.append(apelido);
		builder.append(", genero=");
		builder.append(genero);
		builder.append(", conjugue=");
		builder.append(conjugue);
		builder.append(", rg=");
		builder.append(rg);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", profissao=");
		builder.append(profissao);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", contato=");
		builder.append(contato);
		builder.append("]");
		return builder.toString();
	}	
	
}
