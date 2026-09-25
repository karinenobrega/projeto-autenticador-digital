package project.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashServiceTest {

    @Test
    void deveGerarHashParaUmTexto() {
        String resultado = HashService.generateHash("ola mundo");

        assertNotNull(resultado);
        assertEquals(40, resultado.length());
    }

    @Test
    void deveGerarMesmoHashParaMesmoTexto() {
        String primeiroHash = HashService.generateHash("ola mundo");
        String segundoHash = HashService.generateHash("ola mundo");

        assertEquals(primeiroHash, segundoHash);
    }

    @Test
    void deveGerarHashesDiferentesParaTextosDiferentes() {
        String primeiroHash = HashService.generateHash("ola");
        String segundoHash = HashService.generateHash("mundo");

        assertNotEquals(primeiroHash, segundoHash);
    }

    @Test
    void deveGerarHashParaStringVazia() {
        String resultado = HashService.generateHash("");

        assertNotNull(resultado);
        assertEquals(40, resultado.length());
    }
}