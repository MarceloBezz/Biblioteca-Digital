public class Entrada<K, V> {
    K entrada;
    V value;
    Entrada<K, V> proximo;
    
    public Entrada(K entrada, V value) {
        this.entrada = entrada;
        this.value = value;
    }

    public void setProximo(Entrada<K, V> proximo) {
        this.proximo = proximo;
    }
}
