package project.util;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileServiceTest {

    @Test
    void deveLerLinhasDoArquivo() throws IOException {
        Path arquivo = Files.createTempFile("teste", ".txt");

        Files.write(
                arquivo,
                List.of("ola mundo", "segunda linha")
        );

        List<String> resultado = FileService.readFile(arquivo.toString());

        assertEquals(
                List.of("ola mundo", "segunda linha"),
                resultado
        );

        Files.deleteIfExists(arquivo);
    }

    @Test
    void deveIgnorarLinhasVazias() throws IOException {
        Path arquivo = Files.createTempFile("teste", ".txt");

        Files.write(
                arquivo,
                List.of("ola", "", "mundo")
        );

        List<String> resultado = FileService.readFile(arquivo.toString());

        assertEquals(
                List.of("ola", "mundo"),
                resultado
        );

        Files.deleteIfExists(arquivo);
    }

    @Test
    void deveIgnorarLinhasComApenasEspacos() throws IOException {
        Path arquivo = Files.createTempFile("teste", ".txt");

        Files.write(
                arquivo,
                List.of("ola", "   ", "mundo")
        );

        List<String> resultado = FileService.readFile(arquivo.toString());

        assertEquals(
                List.of("ola", "mundo"),
                resultado
        );

        Files.deleteIfExists(arquivo);
    }

    @Test
    void deveRetornarListaVaziaQuandoArquivoNaoExiste() {
        List<String> resultado =
                FileService.readFile("arquivo-que-nao-existe.txt");

        assertTrue(resultado.isEmpty());
    }
}