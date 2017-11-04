package ilist.knn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Igor Goulart de Oliveira
 */
public class Arquivo {
    
    public List<String> lerArquivo(String arquivo) {
        BufferedReader inputReader;
        List<String> linhas = new ArrayList<>();
        
        try {
            inputReader = new BufferedReader(new FileReader(arquivo));
            
            while(inputReader.ready()){
                linhas.add(inputReader.readLine().trim());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado: " + arquivo);
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        
        return linhas;
    }
    
}
