package br.com.terceira;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.terceira.conexao.MinhaConexao;

public class Principal {

	private static Connection cn = null;

	public static void main(String[] args) {

		cn = MinhaConexao.getInstance();

		try {
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM TB_USUARIO");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getLong("idt"));
				System.out.println(rs.getString("nme_usuario"));

			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
