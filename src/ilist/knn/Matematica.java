package ilist.knn;

import java.util.List;

/**
 *
 * @author Igor Goulart de Oliveira
 */

public class Matematica {
    
    public double subtracao(int numeroA, int numeroB){
        return numeroA - numeroB;
    }
    
    public double elevarQuadrado(double numero){
        return Math.pow(numero, 2);
    }
    
    public double somarNumeros(List<Double> numeros){
        double soma = 0;
        for(double numero : numeros){
            soma += numero;
        }
        return soma;
    }
    
    public double raizQuadrada(double numero){
        return Math.sqrt(numero);
    }
    
}
