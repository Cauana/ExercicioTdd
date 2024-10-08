package Exercicio1Test;

import com.cauana.Exercicio1.Triangulo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TrianguloTest {

    private static Stream<Arguments> dadosParaTestes() {
        return Stream.of(
            // Testes de triângulo inválido
            Arguments.of(-1, 2, 3, "invalido"), // Lado negativo
            Arguments.of(1, -2, 3, "invalido"), // Lado negativo
            Arguments.of(1, 2, -3, "invalido"), // Lado negativo
            Arguments.of(1, 1, 3, "invalido"), // Soma dos lados
            Arguments.of(1, 2, 3, "invalido"), // Soma dos lados
            Arguments.of(2, 3, 6, "invalido"), // Soma dos lados
            Arguments.of(0, 2, 3, "invalido"), // Lados zerados
            Arguments.of(2, 0, 3, "invalido"), // Lados zerados
            Arguments.of(2, 3, 0, "invalido"), // Lados zerados

            // Testes de triângulo equilátero
            Arguments.of(3, 3, 3, "equilátero"),

            // Testes de triângulo isósceles
            Arguments.of(3, 3, 2, "isósceles"),
            Arguments.of(2, 3, 3, "isósceles"),
            Arguments.of(3, 2, 3, "isósceles"),

            // Testes de triângulo escaleno
            Arguments.of(3, 4, 5, "escaleno"),
            Arguments.of(5, 6, 7, "escaleno")
        );
    }

    @ParameterizedTest
    @MethodSource("dadosParaTestes")
    public void testTriangulo(int a, int b, int c, String tipoEsperado) {
        Triangulo triangulo = new Triangulo(a, b, c);
        assertEquals(tipoEsperado, triangulo.tipo());
    }
}
