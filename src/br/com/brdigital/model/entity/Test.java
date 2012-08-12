package br.com.brdigital.model.entity;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import br.com.brdigital.control.dao.*;
import br.com.brdigital.control.general.TrataEntrada;

public class Test {
	public static void main(String arg[]) {
		Beneficiado ben = new Beneficiado("Bruno Ramon", TipoSexo.Masculino, "005");
		BeneficiadoDao dao = new BeneficiadoDao();
		List<Beneficiado> lista = dao.buscarTodos();
		Iterator i = lista.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
