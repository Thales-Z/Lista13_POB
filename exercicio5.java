package lista13_pob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class Exercicio5 {
    public static void main(String[] args) {
        Path origem = Path.of("clientes_bruto.txt");
        Path destino = Path.of("clientes_padronizado.txt");

        try (Stream<String> linhas = Files.lines(origem)) {
            List<String> tratados = linhas
                    .map(String::trim)
                    .filter(l -> !l.isBlank())
                    .map(l -> l.substring(0, 1).toUpperCase() + l.substring(1).toLowerCase())
                    .toList();

            Files.write(destino, tratados, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Arquivo padronizado gerado com sucesso em " + destino);
        } catch (IOException e) {
            System.out.println("Erro ao processar os arquivos: " + e.getMessage());
        }
    }
}
