package br.com.terceiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.terceira.conexao.MinhaConexao;
import br.com.terceiro.interfaces.IUsuarioDAO;
import br.com.terceiro.models.Usuario;
import br.com.terceiro.parser.UsuarioParser;
import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UsuarioDAO implements IUsuarioDAO {

	private Connection cn;

	public UsuarioDAO() {
		this.cn = MinhaConexao.getInstance();
	}

	@Override
	public Usuario buscarUsuario(Long id) {
		Usuario usuario = null;
		try {
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM tb_usuario where idt = ? ");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			usuario = UsuarioParser.rsToUsuario(rs);
		} catch (Exception e) {
			System.err.println(e.toString());
		} finally {
			return usuario;
		}
	}

	@Override
	public List<Usuario> buscarUsuariosPorParteDoNome(String nome) {
		List<Usuario> usuarios = new ArrayList<>();
		try {
			PreparedStatement ps = cn
					.prepareStatement("SELECT * FROM " + " tb_usuario where nme_usuario like CONCAT('%',?,'%') ");
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			usuarios = UsuarioParser.rsToListUsuario(rs);
		} catch (Exception e) {
			System.err.println(e.toString());
		} finally {
			return usuarios;
		}
	}

	@Override
	public Boolean verificarUsuarioESenha(String usuario, String senha) {
		Boolean retorno = false;
		try {
			PreparedStatement ps = cn
					.prepareStatement("SELECT * FROM tb_usuario where usr_usuario = ? and pwd_usuario = MD5(?)");
			ps.setString(1, usuario);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				retorno = true;
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		} finally {
			return retorno;
		}
	}

	@Override
	public Integer deletarUsuario(Long id) {
		Integer i = 0;
		try {
			this.cn.setAutoCommit(false);
			PreparedStatement ps = cn.prepareStatement("DELETE FROM tb_usuario where idt  = ?");
			ps.setLong(1, id);
			i = ps.executeUpdate();
			this.cn.commit();

		} catch (Exception e) {
			this.cn.rollback();
			System.err.println(e.toString());
		} finally {
			return i;
		}

	}

	@Override
	public List<Usuario> buscarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		try {
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM tb_usuario ");

			ResultSet rs = ps.executeQuery();
			usuarios = UsuarioParser.rsToListUsuario(rs);
		} catch (Exception e) {
			System.err.println(e.toString());
		} finally {
			return usuarios;
		}
	}

	@Override
	public Integer editarUsuario(Usuario u) {
		Integer i = 0;
		try {
			this.cn.setAutoCommit(false);
			PreparedStatement ps = cn
					.prepareStatement("UPDATE tb_usuario set nme_usuario = ? , usr_usuario = ? where idt = ? ");
			ps.setString(1, u.getNmeUsuario());
			ps.setString(2, u.getUsrUsuario());
			ps.setLong(3, u.getIdt());
			i = ps.executeUpdate();
			this.cn.commit();

		} catch (Exception e) {
			this.cn.rollback();
			System.err.println(e.toString());
		} finally {
			return i;
		}
	}

	@Override
	public Integer cadastrarUsuario(Usuario u, String senha) {
		Integer i = null;
		try {

			ResultSet keys = null;
			this.cn.setAutoCommit(false);
			PreparedStatement ps = cn.prepareStatement(
					"INSERT into  tb_usuario(nme_usuario,usr_usuario,pwd_usuario)  " + " VALUES(?,?,MD5(?)) ",
					RETURN_GENERATED_KEYS);
			ps.setString(1, u.getNmeUsuario());
			ps.setString(2, u.getUsrUsuario());
			ps.setString(3, senha);
			i = ps.executeUpdate();
			keys = ps.getGeneratedKeys();
			if (keys.next()) {
				i = keys.getInt(1);
			}
			this.cn.commit();

		} catch (Exception e) {
			this.cn.rollback();
			System.err.println(e.toString());
			i = 0;
		} finally {
			return i;
		}
	}

}
