public class Catalogo {
    private NossoHash<String, Livro> hash;

    public Catalogo() {
        hash = new NossoHash<>();
    }

    public void cadastrar(Livro livro) {
        hash.put(livro.getIsbn(), livro);
    }

    public Livro buscar(String isbn) {
        return hash.get(isbn);
    }

    public boolean existe(String isbn) {
        return hash.containsKey(isbn);
    }

    public void exibirCatalogo() {
        hash.exibeMap();
    }
}
