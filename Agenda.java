import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agenda {
    private List<Contatinho> contatinhos;

    public Agenda() {
        this.contatinhos = new ArrayList<>();
    }

    public void addContatinho(Contatinho contatinho) {
        contatinhos.add(contatinho);
        System.out.println("Contato adicionado: " + contatinho.getNome());
    }

    public void ordenarLista() {
        Collections.sort(contatinhos, (c1, c2) -> c1.getNome().compareToIgnoreCase(c2.getNome()));
        System.out.println("Lista ordenada por nome!");
    }

    public void salvarLista() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("contatos.txt"))) {
            ordenarLista();

            for (Contatinho contatinho : contatinhos) {
                writer.println(contatinho.toString());
            }

            System.out.println("Lista de contatos salva com sucesso em contatos.txt!");

        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public Contatinho lerContatinhoPorNome(String nomeBuscado) {
        try (BufferedReader reader = new BufferedReader(new FileReader("contatos.txt"))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split("#");

                if (dados.length == 4) {
                    String nome = dados[0];

                    if (nome.equalsIgnoreCase(nomeBuscado)) {
                        return new Contatinho(nome, dados[1], dados[2], dados[3]);
                    }
                }
            }

            System.out.println("Contato com nome '" + nomeBuscado + "' não encontrado.");
            return null;

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        agenda.addContatinho(new Contatinho("Maria Silva", "maria@gmail.com", "8399999999", "Amiga"));
        agenda.addContatinho(new Contatinho("Carlos Souza", "carlos@gmail.com", "8398888888", "Trabalho"));
        agenda.addContatinho(new Contatinho("Ana Costa", "ana@gmail.com", "8397777777", "Família"));
        agenda.addContatinho(new Contatinho("João Victor", "victor@gmail.com", "839888888", "Professor"));

        agenda.salvarLista();

        System.out.println("\n=== Testando busca de contatos ===");
        Contatinho encontrado = agenda.lerContatinhoPorNome("João Victor");

        if (encontrado != null) {
            System.out.println("Contato encontrado:");
            System.out.println("Nome: " + encontrado.getNome());
            System.out.println("Email: " + encontrado.getEmail());
            System.out.println("Telefone: " + encontrado.getTelefone());
            System.out.println("Categoria: " + encontrado.getCategoria());
        }
    }
}
