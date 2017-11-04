package ilist.knn;

import java.util.List;

/**
 *
 * @author Igor Goulart de Oliveira
 */

public class Frequencia {
    
    private final Integer[] frequencia;
    private int local;
    
    public Frequencia(List<String> dicionario, List<String> palavras, int local){
        frequencia = new Integer[dicionario.size()];
        inicializarVetorFrequencia();
        gerarFrequencia(dicionario, palavras);
        this.local = local;
    }
    
    private void gerarFrequencia(List<String> dicionario, List<String> palavras){
        for(int pos = 0; pos < palavras.size(); pos++){
            if(dicionario.contains(palavras.get(pos))){
                frequencia[dicionario.indexOf(palavras.get(pos))]++;
            }
        }
    }

    public Integer[] getFrequencia() {
        return frequencia;
    }

    public int getLocal() {
        return local;
    }
    
    private void inicializarVetorFrequencia(){
        for(int pos = 0; pos < frequencia.length; pos++){
            frequencia[pos] = 0;
        }
    }
    
}
