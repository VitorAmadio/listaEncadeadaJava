package br.com.estruturadados.lista;

public class ListaEncadeada<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;

    public void adiciona(T elemento){
        No<T> celula = new No<T>(elemento);

        if(this.tamanho == 0){
            this.inicio = celula;
        }else {
            this.ultimo.setProximo(celula);
        }

        this.ultimo = celula;
        this.tamanho++;
    }

    public void limpaLista(){

        for (No<T> atual = this.inicio; atual != null;) {
            No<T> proximoNo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual =proximoNo;
        }
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    @Override
    public String toString() {
        if(this.tamanho == 0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        No<T> valorAtual = this.inicio;


        for (int i = 0; i < this.tamanho -1; i++) {
            builder.append(valorAtual.getElemento()).append(", ");
            valorAtual = valorAtual.getProximo();
        }
        builder.append(valorAtual.getElemento()).append("]");

       /* while (valorAtual.getProximo() != null){
            valorAtual = valorAtual.getProximo();
            builder.append(valorAtual.getElemento()).append(", ");
        }*/

        return builder.toString();
    }
}
