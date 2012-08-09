package br.com.brdigital.model.entity;

import java.sql.SQLException;

import br.com.brdigital.control.dao.*;

public class Test {
	public static void main(String arg[]) {
		Beneficiado ben = new Beneficiado("Bruno Ramon", TipoSexo.M, "005");
		BeneficiadoDao dao = new BeneficiadoDao();
		dao.inserir(ben);

	}
}
