public class GestorEmprestimos {
    NossoHash<String, Fila<Usuario>> hash;

    public GestorEmprestimos() {
        hash = new NossoHash<>();
    }
    
    public void solicitarEmprestimo(Livro livro, Usuario u) {
        Fila<Usuario> fila = hash.get(livro.getIsbn());
        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            return;
        }
            
        fila.enfileira(u);
    }

    public void devolverLivro(Livro livro) {
        livro.setDisponivel(true);
        Fila<Usuario> fila = hash.get(livro.getIsbn());
        if (fila == null || fila.filaVazia()) {
            System.out.println("Fila vazia!");
            return;
        }
        
        fila.desenfileira();
        livro.setDisponivel(false);
    }

    public void listarFilaDeEspera(String isbn) {
        Fila<Usuario> fila = hash.get(isbn);
        if (fila == null)
            System.out.println("Fila vazia!");
        System.out.println(fila);
    }
}
