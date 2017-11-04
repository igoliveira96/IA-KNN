package ilist.knn;

/**
 *
 * @author Igor Goulart de Oliveira
 */

public class Tarefa {
    
    private String titulo;
    private String descricao;
    private int codigoLocal;
    
    public Tarefa(String titulo, String descricao, int codigoLocal){
        this.titulo = titulo;
        this.descricao = descricao;
        this.codigoLocal = codigoLocal;
    }
    
    public Tarefa(){
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(int codigoLocal) {
        this.codigoLocal = codigoLocal;
    }
    
}
