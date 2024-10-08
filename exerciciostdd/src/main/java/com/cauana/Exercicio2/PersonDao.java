package com.cauana.Exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PersonDao {
    
    public List<String> isValidToInclude(Person p) {
        List<String> errors = new ArrayList<>();
        
        if (!isValidName(p.getName())) {
            errors.add("O nome deve ser composto por pelo menos 2 partes e deve conter apenas letras.");
        }
        
        if (p.getAge() < 1 || p.getAge() > 200) {
            errors.add("A idade deve estar no intervalo [1, 200].");
        }
        
        if (p.getEmails().isEmpty() || !isValidEmails(p.getEmails())) {
            errors.add("A pessoa deve ter pelo menos um email associado e o email deve ter um formato válido.");
        }
        
        return errors;
    }
    
    private boolean isValidName(String name) {
        String[] parts = name.split(" ");
        return parts.length >= 2 && name.matches("[a-zA-Z ]+");
    }

    private boolean isValidEmails(List<Email> emails) {
        Pattern emailPattern = Pattern.compile("^[^@]+@[^@]+\\.[^@]+$");
        for (Email email : emails) {
            if (!emailPattern.matcher(email.getEmail()).matches()) {
                return false;
            }
        }
        return true;
    }
}
