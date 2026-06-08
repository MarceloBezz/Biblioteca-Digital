public class NossoHash<K, V> {
    private Entrada<K, V>[] array;

    @SuppressWarnings("unchecked")
    public NossoHash() {
        array = (Entrada<K, V>[]) new Entrada[16];
    }

    public void put(K key, V value) {
        int posicao = hash(key);
        Entrada<K, V> entrada = new Entrada<>(key, value);
        entrada.setProximo(array[posicao]);
        array[posicao] = entrada;
    }

    public V get(K key) {
        int posicao = hash(key);
        Entrada<K, V> item = array[posicao];
        V retorno = null;
        while (item != null) {
            if (item.entrada.equals(key)) {
                retorno = item.value;
                break;
            }
            item = item.proximo;
        }

        return retorno;
    }

    public boolean containsKey(K key) {
        int posicao = hash(key);
        Entrada<K, V> item = array[posicao];
        while (item != null) {
            if (item.entrada.equals(key))
                return true;

            item = item.proximo;
        }

        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < array.length; i++) {
            Entrada<K, V> item = array[i];
            while (item != null) {
                if (item.value.equals(value))
                    return true;
    
                item = item.proximo;
            }
        }

        return false;
    }

    public void exibeMap() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Posição " + i + ":\n");
            Entrada<K, V> item = array[i];
            while (item != null) {
                System.out.println(item.value);
                item = item.proximo;
            }
            System.out.println("=======================================");
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % 16;
    }
}
