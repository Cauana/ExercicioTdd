package com.cauana.Exercicio2;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private final String name;
    private final int age;
    private final List<Email> emails;


}
