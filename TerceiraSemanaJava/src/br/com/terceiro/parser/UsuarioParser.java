package br.com.terceiro.parser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.terceiro.models.Usuario;

public class UsuarioParser {

	public static Usuario rsToUsuario(ResultSet rs) {
		Usuario usuario = null;
		try {
			if (rs.next()) {
				usuario = new Usuario(rs.getLong("idt"), rs.getString("nme_usuario"), rs.getString("usr_usuario"));
			} else {
				
			}
		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {
			return usuario;
		}

	}

	public static ArrayList<Usuario> rsToListUsuario(ResultSet rs) {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		try {
			while (rs.next()) {
				usuarios.add(new Usuario(rs.getLong("idt"), rs.getString("nme_usuario"), rs.getString("usr_usuario")));
			}
		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {
			return usuarios;
		}
	}

}
