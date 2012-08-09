package br.com.brdigital.model.entity;

public enum TipoSexo {
	 M ("Masculino")
	,F ("Feminino");
	
	private String sexo;

	/**
	 * @param sexo
	 */
	private TipoSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
