package com.cauana.Exercicio3;

public class CalculadoraSalario {

    public static double calcularSalarioLiquido(Funcionario funcionario) {
        double salarioBase = funcionario.getSalarioBase();
        double desconto = 0.0;

        switch (funcionario.getCargo()) {
            case DESENVOLVEDOR:
                desconto = salarioBase >= 3000.00 ? 0.20 : 0.10;
                break;
            case DBA:
                desconto = salarioBase >= 2000.00 ? 0.25 : 0.15;
                break;
            case TESTADOR:
                desconto = salarioBase >= 2000.00 ? 0.25 : 0.15;
                break;
            case GERENTE:
                desconto = salarioBase >= 5000.00 ? 0.30 : 0.20;
                break;
        }
        return salarioBase - (salarioBase * desconto);
    }
}
