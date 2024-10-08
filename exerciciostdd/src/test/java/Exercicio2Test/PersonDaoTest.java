package Exercicio2Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.cauana.Exercicio2.Email;
import com.cauana.Exercicio2.Person;
import com.cauana.Exercicio2.PersonDao;
import com.cauana.Exercicio3.Cargo;
import com.cauana.Exercicio3.Funcionario;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonDaoTest {

    static Stream<org.junit.jupiter.params.provider.Arguments> providePersonsForValidation() {
        Email validEmail = new Email("teste@exemplo.com");
        Email invalidEmail = new Email("invalid-email");

        return Stream.of(
            org.junit.jupiter.params.provider.Arguments.of(
                new Person("John Doe", 25, List.of(validEmail)), 
                Collections.emptyList()
            ),

            org.junit.jupiter.params.provider.Arguments.of(
                new Person("John", 25, List.of(validEmail)), 
                List.of("O nome deve ser composto por pelo menos 2 partes e deve conter apenas letras.")
            ),

            org.junit.jupiter.params.provider.Arguments.of(
                new Person("John Doe", 300, List.of(validEmail)), 
                List.of("A idade deve estar no intervalo [1, 200].")
            ),

            org.junit.jupiter.params.provider.Arguments.of(
                new Person("John Doe", 25, List.of(invalidEmail)), 
                List.of("A pessoa deve ter pelo menos um email associado e o email deve ter um formato válido.")
            ),

            org.junit.jupiter.params.provider.Arguments.of(
                new Person("John Doe", 25, Collections.emptyList()), 
                List.of("A pessoa deve ter pelo menos um email associado e o email deve ter um formato válido.")
            )
        );
    }

    @ParameterizedTest
    @MethodSource("providePersonsForValidation")
    public void testValidPerson(Person person, List<String> expectedErrors) {
        PersonDao personDAO = new PersonDao();
        List<String> errors = personDAO.isValidToInclude(person);
        assertEquals(expectedErrors, errors);
    }

}
