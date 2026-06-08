public class ListaDupla {
    private NoDuplo primeiro;
    private NoDuplo ultimo;
    private int tamanho;

    public ListaDupla() {
        tamanho = 0;
    }

    public ListaDupla(Livro livro) {
        primeiro = new NoDuplo(livro);
        tamanho = 1;
    }

    public void insereInicio(Livro livro) {
        NoDuplo inicio = new NoDuplo(livro);
        if (primeiro != null) {
            inicio.setProximo(primeiro);
            primeiro.setAnterior(inicio);
        }

        if (ultimo == null)
            ultimo = primeiro;

        primeiro = inicio;
        tamanho++;
    }

    public void insereFim(Livro livro) {
        NoDuplo fim = new NoDuplo(livro);
        if (primeiro == null) {
            primeiro = fim;
        } else if (ultimo == null) {
            ultimo = fim;
            primeiro.setProximo(ultimo);
            ultimo.setAnterior(primeiro);
        } else {
            fim.setAnterior(ultimo);
            ultimo.setProximo(fim);
            ultimo = fim;
        }
        tamanho++;
    }

    public Livro removePrimeiro() {
        if (tamanho == 0) 
            return null;
        
        Livro removido = primeiro.getAtual();
        NoDuplo segundo = primeiro.getProximo();
        segundo.setAnterior(null);
        primeiro = segundo;
        tamanho--;
        return removido;
    }

    public Livro removeUltimo() {
        if (tamanho == 0)
            return null;

        if (ultimo == null)
            return removePrimeiro();
        
        Livro removido = ultimo.getAtual();
        if (tamanho == 2) {
            primeiro.setProximo(null);
            ultimo.setAnterior(null);
            ultimo = null;
            tamanho--;
            return removido;
        }

        NoDuplo penultimo = ultimo.getAnterior();
        ultimo.setAnterior(null);
        penultimo.setProximo(null);
        ultimo = penultimo;
        tamanho--;
        return removido;
    }

    public Livro buscarPorIsbn(String isbn) {
        Livro resultado = null;
        NoDuplo atual = primeiro;
        while (atual != null) {
            if (atual.getAtual().getIsbn().equals(isbn)) {
                resultado = atual.getAtual();
                break;
            }
            atual = atual.getProximo();
        }

        return resultado;
    }

    public void listarDoInicio() {
        if (tamanho == 0) {
            System.out.println("Lista vazia!");
            return;
        }
        

        NoDuplo atual = primeiro;
        StringBuilder sb = new StringBuilder();
        while (atual != null) {
            sb.append(atual.getAtual()).append("\n");
            atual = atual.getProximo();
        }
        System.out.println(sb.toString().trim());
    }

    public void listarDoFim() {
        if (tamanho == 0) {
            System.out.println("Lista vazia!");
            return;
        }

        if (tamanho == 1) {
            System.out.println(primeiro.getAtual());
            return;
        }

        NoDuplo atual = ultimo;
        StringBuilder sb = new StringBuilder();
        while (atual != null) {
            sb.append(atual.getAtual()).append("\n");
            atual = atual.getAnterior();
        }
        System.out.println(sb.toString().trim());
    }

    public int tamanho() {
        return tamanho;
    }
}
