/**
 * 
 */
package pe.banca.empresa.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


/**
 * @author vector
 *
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable{

  private static final long serialVersionUID = 7401548380514451401L;
  
  public Empresa() {}
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "name")
  String name;

  @NotNull
  @Email
  @Column(name = "email")
  String email;

  @Column(name = "empresa_number")
  String empresaNumber;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getEmpresaNumber() {
	return empresaNumber;
  }

  public void setEmpresaNumber(String empresaNumber) {
	this.empresaNumber = empresaNumber;
  }

@Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((empresaNumber == null) ? 0 : empresaNumber.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Empresa other = (Empresa) obj;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (empresaNumber == null) {
      if (other.empresaNumber != null)
        return false;
    } else if (!empresaNumber.equals(other.empresaNumber))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "empresa [id=" + id + ", name=" + name + ", email=" + email + ", empresaNumber=" + empresaNumber + "]";
  }
  
  


}
