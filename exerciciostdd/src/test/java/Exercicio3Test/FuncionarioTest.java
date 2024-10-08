package Exercicio3Test;

import com.cauana.Exercicio3.Cargo;
import com.cauana.Exercicio3.Funcionario;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTest {

    private static Stream<Arguments> dadosParaTestes() {
        return Stream.of(
            Arguments.of("Alice", "alice@example.com", 3000.00, Cargo.DESENVOLVEDOR, true),
            Arguments.of("Bob", null, 3000.00, Cargo.DESENVOLVEDOR, false), // email nulo
            Arguments.of(null, "bob@example.com", 3000.00, Cargo.DBA, false), // nome nulo
            Arguments.of("Carlos", "carlos@example.com", -2000.00, Cargo.TESTADOR, false) // salário negativo
        );
    }

    @ParameterizedTest
    @MethodSource("dadosParaTestes")
    public void testFuncionario(String nome, String email, double salarioBase, Cargo cargo, boolean expectedResult) {
        if (expectedResult) {
            Funcionario funcionario = new Funcionario(nome, email, salarioBase, cargo);
            assertNotNull(funcionario);
            assertEquals(nome, funcionario.getNome());
            assertEquals(email, funcionario.getEmail());
            assertEquals(salarioBase, funcionario.getSalarioBase());
            assertEquals(cargo, funcionario.getCargo());
        }
    }

    private static Stream<Arguments> dadosParaTestesEquals() {
        return Stream.of(
            Arguments.of(new Funcionario("Alice", "alice@example.com", 3000.00, Cargo.DESENVOLVEDOR),
                         new Funcionario("Alice", "alice@example.com", 3000.00, Cargo.DESENVOLVEDOR), true),
            Arguments.of(new Funcionario("Alice", "alice@example.com", 3000.00, Cargo.DESENVOLVEDOR),
                         new Funcionario("Bob", "bob@example.com", 4000.00, Cargo.DBA), false)
        );
    }

}
