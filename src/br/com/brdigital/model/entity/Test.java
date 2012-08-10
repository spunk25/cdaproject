package br.com.brdigital.model.entity;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import br.com.brdigital.control.dao.*;

public class Test {
	public static void main(String arg[]) {
		Beneficiado ben = new Beneficiado("Bruno Ramon", TipoSexo.Masculino, "005");
		BeneficiadoDao dao = new BeneficiadoDao();
		Vector<Beneficiado> lista = dao.buscarTodos();
		Iterator i = lista.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
