import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número para gerar a tabuada: ");
        int numero = scanner.nextInt();

        String nomeArquivo = "tabuada_" + numero + ".txt";

        try {

            PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo));

            System.out.println("Gerando tabuada e salvando no arquivo: " + nomeArquivo);

            for (int i = 1; i <= 10; i++) {
                int resultado = numero * i;
                String linha = numero + " x " + i + " = " + resultado;
                writer.println(linha);
                System.out.println(linha);
            }

            writer.close();
            System.out.println("Tabuada salva com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo: " + e.getMessage());
        }

        scanner.close();
    }
}
