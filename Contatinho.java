public class Contatinho {
    private String nome;
    private String email;
    private String telefone;
    private String categoria;

    public Contatinho(String nome, String email, String telefone, String categoria) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.categoria = categoria;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nome + "#" + email + "#" + telefone + "#" + categoria;
    }
}
