public class Fila<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    public Fila() {}
    
    public Fila(T info) {
        primeiro = new No<T>(info);
    }

    public void enfileira(T info) {
        if (primeiro == null)
            primeiro = new No<T>(info);
        else if (ultimo == null) {
            ultimo = new No<T>(info);
            primeiro.setProximo(ultimo);
        } else {
            ultimo.setProximo(new No<>(info));
            ultimo = ultimo.getProximo();
        }
        tamanho++;
    }

    public T desenfileira() {
        if (filaVazia())
            throw new FilaVaziaException("Fila vazia!");

        T desenfileirado = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if (primeiro == null)
            ultimo = null;
        tamanho--;
        return desenfileirado;
    }

    public T primeiro() {
        if (filaVazia())
            throw new FilaVaziaException("Fila vazia!");

        return primeiro.getInfo();
    }

    public boolean filaVazia() {
        return primeiro == null;
    }

    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        No<T> atual = primeiro;
        while (atual != null) {
            sb.append("[" + atual.getInfo() + "] -> ");
            atual = atual.getProximo();
        }
        return sb.append("\\\\.").toString();
    }
}

class FilaVaziaException extends RuntimeException {
    FilaVaziaException(String mensagem) {
        super(mensagem);
    }
}
