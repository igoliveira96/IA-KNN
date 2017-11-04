package ilist.knn;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor Goulart de Oliveira
 */
public class ILISTKNN {

    public static void main(String[] args) {
        /**
         * Locais: 
         * 1 - Açougue 
         * 2 - Mercado 
         * 3 - Casa
         */

        // CRIAÇÃO DAS TAREFAS:
        Tarefa tarefaUm = new Tarefa();
        tarefaUm.setTitulo("Churrasco da turma");
        tarefaUm.setDescricao("Comprar carne no açougue");
        tarefaUm.setCodigoLocal(1);

        Tarefa tarefaDois = new Tarefa();
        tarefaDois.setTitulo("Churrasco");
        tarefaDois.setDescricao("Comprar carne para o churrasco na casa do Fernando");
        tarefaDois.setCodigoLocal(1);

        Tarefa tarefaTres = new Tarefa();
        tarefaTres.setTitulo("Código");
        tarefaTres.setDescricao("Construir o código do KNN");
        tarefaTres.setCodigoLocal(3);

        Tarefa tarefaQuatro = new Tarefa();
        tarefaQuatro.setTitulo("Arroz");
        tarefaQuatro.setDescricao("Comprar arroz no supermercado UEDA-CENTER");
        tarefaQuatro.setCodigoLocal(2);

        // TAREFA SEM LOCAL:
        /*Tarefa tarefaSemLocal = new Tarefa();
        tarefaSemLocal.setTitulo("Programação");
        tarefaSemLocal.setDescricao("Terminar de construir o código de busca");*/
        
        /*Tarefa tarefaSemLocal = new Tarefa();
        tarefaSemLocal.setTitulo("Feijão");
        tarefaSemLocal.setDescricao("Comprar feijão no supermercado");*/
        
        Tarefa tarefaSemLocal = new Tarefa();
        tarefaSemLocal.setTitulo("Churrasco");
        tarefaSemLocal.setDescricao("Comprar carne no açougue");

        // GERAR DICIONÁRIO:
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavras(tarefaUm.getTitulo() + " " + tarefaUm.getDescricao());
        dicionario.adicionarPalavras(tarefaDois.getTitulo() + " " + tarefaDois.getDescricao());
        dicionario.adicionarPalavras(tarefaTres.getTitulo() + " " + tarefaTres.getDescricao());
        dicionario.adicionarPalavras(tarefaQuatro.getTitulo() + " " + tarefaQuatro.getDescricao());
        
        dicionario.exibirPalavras();

        // GERAR LISTA DE FREQUÊNCIAS:
        Dicionario dicionarioTarefaUm = new Dicionario();
        dicionarioTarefaUm.adicionarPalavras(tarefaUm.getTitulo() + " " + tarefaUm.getDescricao());
        Frequencia freqUm = new Frequencia(
                dicionario.getDicionario(),
                dicionarioTarefaUm.getDicionario(),
                tarefaUm.getCodigoLocal());

        Dicionario dicionarioTarefaDois = new Dicionario();
        dicionarioTarefaDois.adicionarPalavras(tarefaDois.getTitulo() + " " + tarefaDois.getDescricao());
        Frequencia freqDois = new Frequencia(
                dicionario.getDicionario(),
                dicionarioTarefaDois.getDicionario(),
                tarefaDois.getCodigoLocal());

        Dicionario dicionarioTarefaTres = new Dicionario();
        dicionarioTarefaTres.adicionarPalavras(tarefaTres.getTitulo() + " " + tarefaTres.getDescricao());
        Frequencia freqTres = new Frequencia(
                dicionario.getDicionario(),
                dicionarioTarefaTres.getDicionario(),
                tarefaTres.getCodigoLocal());

        Dicionario dicionarioTarefaQuatro = new Dicionario();
        dicionarioTarefaQuatro.adicionarPalavras(tarefaQuatro.getTitulo() + " " + tarefaQuatro.getDescricao());
        Frequencia freqQuatro = new Frequencia(
                dicionario.getDicionario(),
                dicionarioTarefaQuatro.getDicionario(),
                tarefaQuatro.getCodigoLocal()
        );

        List<Frequencia> frequencias = new ArrayList<>();
        frequencias.add(freqUm);
        frequencias.add(freqDois);
        frequencias.add(freqTres);
        frequencias.add(freqQuatro);
        
        
        for(int i = 0; i < frequencias.size(); i++){
            for(int j = 0; j < frequencias.get(i).getFrequencia().length; j++){
                System.out.print(frequencias.get(i).getFrequencia()[j] + " ");
            }
            System.out.println("");
        }

        // FREQUÊNCIA DA TAREFA SEM LOCAL:
        Dicionario dicionarioTarefaSemLocal = new Dicionario();
        dicionarioTarefaSemLocal.adicionarPalavras(tarefaSemLocal.getTitulo() + " " + tarefaSemLocal.getDescricao());
        Frequencia frequenciaTarefaSemLocal = new Frequencia(
                dicionario.getDicionario(),
                dicionarioTarefaSemLocal.getDicionario(),
                -1
        );
        
        for(int j = 0; j < frequenciaTarefaSemLocal.getFrequencia().length; j++){
                System.out.print(frequenciaTarefaSemLocal.getFrequencia()[j] + " ");
            }
            System.out.println("");
        
        // EXECUTAR O KNN:
        KNN knn = new KNN();
        knn.executar(frequencias, frequenciaTarefaSemLocal);
        
        List<Double> distancias = knn.getDistancias();
        
        System.out.println("\nDistâncias:");
        for(int pos = 0; pos < distancias.size(); pos++){
            System.out.printf("Distância %d: %f\n", (pos+1), distancias.get(pos));
        }
        
        int menorDistancia = 0;
        for(int pos = 0; pos < distancias.size(); pos++){
            if(distancias.get(pos) < distancias.get(menorDistancia)){
                menorDistancia = pos;
            }
        }
        
        System.out.println("\nTarefa: " + tarefaSemLocal.getTitulo());
        int codigoLocal = frequencias.get(menorDistancia).getLocal();
        System.out.print("Possível local: ");
        switch(codigoLocal){
            case 1:
                System.out.println("1 - Açougue");
                break;
            case 2:
                System.out.println("2 - Mercado");
                break;
            case 3:
                System.out.println("3 - Casa");
                break;
        }
    }

}
