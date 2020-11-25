package br.com.terceiro.models;

public class Usuario {

	private Long idt;
	private String nmeUsuario;
	private String usrUsuario;

	public Usuario() {
		super();
	}

	public Usuario(Long idt, String nmeUsuario, String usrUsuario) {
		super();
		this.idt = idt;
		this.nmeUsuario = nmeUsuario;
		this.usrUsuario = usrUsuario;
	}

	public Long getIdt() {
		return idt;
	}

	public void setIdt(Long idt) {
		this.idt = idt;
	}

	public String getNmeUsuario() {
		return nmeUsuario;
	}

	public void setNmeUsuario(String nmeUsuario) {
		this.nmeUsuario = nmeUsuario;
	}

	public String getUsrUsuario() {
		return usrUsuario;
	}

	public void setUsrUsuario(String usrUsuario) {
		this.usrUsuario = usrUsuario;
	}

}
