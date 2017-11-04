package ilist.knn;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor Goulart de Oliveira
 */

public class KNN {
    
    private final List<Double> distancias;
    
    public KNN(){
        distancias = new ArrayList<>();
    }
    
    public void executar(List<Frequencia> frequencias, Frequencia frequencia){
        frequencias.forEach((freq) -> {
            distancias.add(calcularDistancia(freq, frequencia));
        });
    }
    
    private double calcularDistancia(Frequencia freqA, Frequencia freqB){
        Matematica matematica = new Matematica();
        List<Double> freqAuxiliar = new ArrayList<>();
        
        for(int pos = 0; pos < freqA.getFrequencia().length; pos++){
            int numA = freqA.getFrequencia()[pos];
            int numB = freqB.getFrequencia()[pos];
            
            freqAuxiliar.add(matematica.elevarQuadrado(matematica.subtracao(numA, numB)));
        }
        
        return matematica.raizQuadrada(matematica.somarNumeros(freqAuxiliar));
    }

    public List<Double> getDistancias() {
        return distancias;
    }
    
}
