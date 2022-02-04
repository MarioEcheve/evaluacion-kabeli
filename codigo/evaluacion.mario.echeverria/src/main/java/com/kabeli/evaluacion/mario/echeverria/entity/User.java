package com.kabeli.evaluacion.mario.echeverria.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Integer idUser;

	@Size(min = 3, message = "Debe tener minimo 3 caracteres")
	@Column(name = "name", length = 150, nullable = false)
	private String name;

	@Size(min = 4, message = "Debe tener minimo 4 caracteres")
	@Pattern(regexp = "^(?:[a-z]*[A-Z][a-z]+|[a-z]+[A-Z][a-z]*)(?=(.*[0-9]{2})).{4,}$", message = "El formato ingresado no es el correcto, 1 mayuscula, letras minisculas, 2 o mas numeros.")
	@Column(name = "password", length = 100, nullable = false)
	private String password;
	
	@Pattern(regexp = "^([a-zA-Z0-9_.+-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$", message = "El formato ingresado no es el correcto.")
	@Column(name = "email", unique = true, length = 100)
	private String email;

	@NotNull
	@Column(name = "created", nullable = false)
	private Date created;

	@Column(name = "modified", nullable = true)
	private Date modified;

	@Column(name = "last_login", nullable = false)
	private Date lastLogin;

	@Column(name = "isactive", nullable = false)
	private Boolean isactive;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user", referencedColumnName = "id_user")
	private Set<Phone> phones;

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}
}
