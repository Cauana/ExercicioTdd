package Exercicio3Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.cauana.Exercicio3.CalculadoraSalario;
import com.cauana.Exercicio3.Cargo;
import com.cauana.Exercicio3.Funcionario;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraSalarioTest {

    private static Stream<Arguments> dadosParaTestes() {
        return Stream.of(
            Arguments.of(new Funcionario("Alice", "alice@example.com", 2500.00, Cargo.DESENVOLVEDOR), 2250.00),
            Arguments.of(new Funcionario("Bob", "bob@example.com", 3000.00, Cargo.DESENVOLVEDOR), 2400.00),
            Arguments.of(new Funcionario("Carlos", "carlos@example.com", 1800.00, Cargo.DBA), 1530.00),
            Arguments.of(new Funcionario("Daniel", "daniel@example.com", 2000.00, Cargo.DBA), 1500.00),
            Arguments.of(new Funcionario("Evelyn", "evelyn@example.com", 1800.00, Cargo.TESTADOR), 1530.00),
            Arguments.of(new Funcionario("Fábio", "fabio@example.com", 2000.00, Cargo.TESTADOR), 1500.00),
            Arguments.of(new Funcionario("Gabriel", "gabriel@example.com", 4000.00, Cargo.GERENTE), 3200.00),
            Arguments.of(new Funcionario("Hugo", "hugo@example.com", 5000.00, Cargo.GERENTE), 3500.00),
            Arguments.of(new Funcionario("Irene", "irene@example.com", 2999.99, Cargo.DESENVOLVEDOR), 2699.99), 
            Arguments.of(new Funcionario("João", "joao@example.com", 3000.01, Cargo.DESENVOLVEDOR), 2400.00),
            Arguments.of(new Funcionario("Lucas", "lucas@example.com", 1999.99, Cargo.DBA), 1699.99), 
            Arguments.of(new Funcionario("Maria", "maria@example.com", 2000.01, Cargo.DBA), 1500.00), 
            Arguments.of(new Funcionario("Nina", "nina@example.com", 1999.99, Cargo.TESTADOR), 1699.99), 
            Arguments.of(new Funcionario("Oscar", "oscar@example.com", 2000.01, Cargo.TESTADOR), 1500.00), 
            Arguments.of(new Funcionario("Paula", "paula@example.com", 4999.99, Cargo.GERENTE), 3999.99), 
            Arguments.of(new Funcionario("Rafael", "rafael@example.com", 5000.01, Cargo.GERENTE), 3500.00) 
        );
    }

    @ParameterizedTest
    @MethodSource("dadosParaTestes")
    public void testCalculaSalarioLiquido(Funcionario funcionario, double salarioLiquidoEsperado) {
        double salarioLiquido = CalculadoraSalario.calcularSalarioLiquido(funcionario);
        assertEquals(salarioLiquidoEsperado, salarioLiquido, 0.01);
    }
}
