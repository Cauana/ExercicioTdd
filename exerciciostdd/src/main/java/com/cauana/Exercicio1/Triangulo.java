package com.cauana.Exercicio1;

public class Triangulo {
    private final int a;
    private final int b;
    private final int c;

    public Triangulo(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String tipo() {
        if (a <= 0 || b <= 0 || c <= 0) return "invalido";
        if (a + b <= c || a + c <= b || b + c <= a) return "invalido";

        if (a == b && b == c) return "equilátero";
        if (a == b || b == c || a == c) return "isósceles";
        return "escaleno";
    }
}
