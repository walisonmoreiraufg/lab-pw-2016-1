package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Curso {

  @Id
  private String codigo;

  private String nome;

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Curso() {
  }

  public Curso(String codigo, String nome) {
    super();
    this.codigo = codigo;
    this.nome = nome;
  }
}
