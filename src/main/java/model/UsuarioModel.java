package model;

public class UsuarioModel {

    private Long id;
    private String nome;
    private String email;

    // INSERT
    public UsuarioModel(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // SELECT
    public UsuarioModel(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // get&set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
