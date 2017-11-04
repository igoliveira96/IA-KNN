package ilist.knn;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor Goulart de Oliveira
 */

public class Dicionario {
    
    private final List<String> dicionario;
    private final String arquivoStopWords = "stopwords.txt";
    private List<String> stopWords;
    
    public Dicionario(){
        dicionario = new ArrayList<>();
        carregarStopWords();
    }
    
    private void carregarStopWords(){
        Arquivo arquivo = new Arquivo();
        stopWords = arquivo.lerArquivo(arquivoStopWords);
    }
    
    public void adicionarPalavras(String texto){
        String[] soPalavras = somentePalavras(texto);
        
        for(String palavra : soPalavras){
            if(palavra != null){
                adicionarPalavra(palavra);
            }
        }
    }
    
    public void adicionarPalavra(String palavra){
        palavra = palavra.toLowerCase();
        if(!stopWords.contains(palavra)){
            if(!dicionario.contains(palavra)){
                dicionario.add(palavra);
            }
        }
    }
    
    private String[] somentePalavras(String texto){
        return texto.split(" ");
    }

    public List<String> getDicionario() {
        return dicionario;
    }
    
    public void exibirPalavras(){
        dicionario.forEach((palavra) -> {
            System.out.print(palavra + " ");
        });
        System.out.println("");
    }
    
}
