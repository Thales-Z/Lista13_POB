package lista13_pob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Exercicio4 {
    public static void main(String[] args) {
        Path pasta = Path.of("src");

        try (Stream<Path> stream = Files.walk(pasta)) {
            long somaTamanhos = stream
                    .filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".java"))
                    .mapToLong(p -> {
                        try {
                            long tamanho = Files.size(p);
                            System.out.println("Arquivo: " + p + " | Tamanho: " + tamanho + " bytes");
                            return tamanho;
                        } catch (IOException e) {
                            return 0L;
                        }
                    })
                    .sum();

            System.out.println("Soma total do tamanho dos arquivos Java: " + somaTamanhos + " bytes");
        } catch (IOException e) {
            System.out.println("Erro na varredura do diretório: " + e.getMessage());
        }
    }
}
