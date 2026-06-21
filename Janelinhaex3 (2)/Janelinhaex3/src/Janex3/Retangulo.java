package Janex3;


public class Retangulo {

    private double base;
    private double altura;

    // 👇 CONSTRUTOR OBRIGATÓRIO
    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    public double calcularArea() {
        return base * altura;
    }
}
