public class NoDuplo {
    private Livro atual;
    private NoDuplo proximo;
    private NoDuplo anterior;

    public NoDuplo(Livro livro) {
        atual = livro;
    }

    public Livro getAtual() {
        return atual;
    }

    public NoDuplo getProximo() {
        return proximo;
    }

    public void setProximo(NoDuplo proximo) {
        this.proximo = proximo;
    }

    public NoDuplo getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuplo anterior) {
        this.anterior = anterior;
    }
    
}
