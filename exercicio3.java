package lista13_pob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Exercicio3 {
    public static void main(String[] args) {
        Path caminho = Path.of("produtos.csv");

        try {
            List<String> linhas = Files.readAllLines(caminho);
            double valorGlobal = 0.0;

            for (int i = 1; i < linhas.size(); i++) {
                String linha = linhas.get(i);
                if (linha.isBlank()) continue;

                String[] campos = linha.split(",");
                int quantidade = Integer.parseInt(campos[1].trim());
                double precoUnitario = Double.parseDouble(campos[2].trim());

                double totalItem = quantidade * precoUnitario;
                valorGlobal += totalItem;
            }

            System.out.printf("Valor global do inventário: R$ %.2f\n", valorGlobal);
        } catch (IOException e) {
            System.out.println("Erro de I/O ao ler o CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro de formato numérico no arquivo: " + e.getMessage());
        }
    }
}
