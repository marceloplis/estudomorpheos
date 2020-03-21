package br.com.morpheos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TbUsuarioSistema")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
public class UsuarioEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioEntity(){		
		this.unidade = new UnidadeAtendimentoEntity();
		this.perfil = new PerfilAcessoEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_usuario")
	@Column(name="idUsuarioSistema")
	private Long idUsuario;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="username")
	private String username;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="email")
	private String email;
	
	@Column
	private String fone;
	
	@Column
	private String admin;
	
	//Por padrão o usuário é criado como bloqueado para forçá-lo a trocar a senha
	@Column(name="flSenhaTemporaria")
	private boolean flSenhaTemporaria;
	
	//Por padrão o usuário é criado como ativo, o Admin terá poder de desativá-lo
	@Column(name="flAtivo")
	private boolean flAtivo;
	
	@OneToOne
	@JoinColumn(name = "idUnidadePesquisa", referencedColumnName = "idUnidadePesquisa")
	private UnidadeAtendimentoEntity unidade;

	@OneToOne
	@JoinColumn(name = "idPerfil", referencedColumnName = "idperfilacesso")
	private PerfilAcessoEntity perfil;
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFone() {
		return fone;
	}
	
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public String getAdmin() {
		return admin;
	}
	
	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public boolean isFlSenhaTemporaria() {
		return flSenhaTemporaria;
	}

	public void setFlSenhaTemporaria(boolean flSenhaTemporaria) {
		this.flSenhaTemporaria = flSenhaTemporaria;
	}

	public boolean isFlAtivo() {
		return flAtivo;
	}

	public void setFlAtivo(boolean flAtivo) {
		this.flAtivo = flAtivo;
	}

	public UnidadeAtendimentoEntity getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidadeAtendimentoEntity unidade) {
		this.unidade = unidade;
	}
	
	public PerfilAcessoEntity getPerfil() {
		return perfil;
	}
	
	public void setPerfil(PerfilAcessoEntity perfil) {
		this.perfil = perfil;
	}
	
	
}
