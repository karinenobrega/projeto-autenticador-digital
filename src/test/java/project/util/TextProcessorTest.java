package project.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {

    @Test
    void deveSepararPalavrasPorEspaco() {
        String[] resultado = TextProcessor.splitWords("ola mundo");

        assertArrayEquals(
                new String[]{"ola", "mundo"},
                resultado
        );
    }

    @Test
    void deveIgnorarVariosEspacosEntrePalavras() {
        String[] resultado = TextProcessor.splitWords("ola   mundo");

        assertArrayEquals(
                new String[]{"ola", "mundo"},
                resultado
        );
    }

    @Test
    void deveRetornarUmaUnicaPalavra() {
        String[] resultado = TextProcessor.splitWords("ola");

        assertArrayEquals(
                new String[]{"ola"},
                resultado
        );
    }

    @Test
    void deveTratarStringVazia() {
        String[] resultado = TextProcessor.splitWords("");

        assertArrayEquals(
                new String[]{""},
                resultado
        );
    }
}