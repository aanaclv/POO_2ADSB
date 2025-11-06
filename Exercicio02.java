import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número para ler a tabuada: ");
        int numero = scanner.nextInt();

        String nomeArquivo = "tabuada_" + numero + ".txt";

        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            System.out.println("Arquivo " + nomeArquivo + " não encontrado!");
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                System.out.println("Conteúdo da tabuada de " + numero + ":");
                System.out.println("--------------------------------");

                String linha;
                while ((linha = reader.readLine()) != null) {
                    System.out.println(linha);
                }

            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
