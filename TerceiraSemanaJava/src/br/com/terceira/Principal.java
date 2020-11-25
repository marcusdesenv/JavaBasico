package br.com.terceira;

import br.com.terceiro.dao.UsuarioDAO;
import br.com.terceiro.models.Usuario;

public class Principal {

	public static void main(String[] args) {

		UsuarioDAO dao = new UsuarioDAO();
		Usuario u = new Usuario();
		u.setNmeUsuario("Marcus Vinicius");
		u.setUsrUsuario("usuario.teste");
		u.setIdt(dao.cadastrarUsuario(u, "123").longValue());
		dao.verificarUsuarioESenha(u.getUsrUsuario(), "123");
		u.setNmeUsuario("Teste");
		dao.editarUsuario(u);
		u = dao.buscarUsuario(u.getIdt());
		System.out.print(u.getNmeUsuario());



	}

}
