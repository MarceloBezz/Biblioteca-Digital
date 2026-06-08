public class TesteListaDupla {

    public static void main(String[] args) {
        testarInsereInicio();
        testarInsereFim();
        testarRemovePrimeiro();
        testarRemoveUltimo();
        testarBuscarPorIsbn();
        testarTamanho();
        testarListarDoInicio();
        testarListarDoFim();
    }

    public static void testarInsereInicio() {
        System.out.println("\n=== TESTE insereInicio ===");

        ListaDupla lista = new ListaDupla(
                new Livro("111", "Java", "Autor A", 2020));

        lista.insereInicio(
                new Livro("222", "Estruturas de Dados", "Autor B", 2021));

        // Esperado:
        // Imprimir primeiro o livro Estruturas de Dados e depois o Java
        lista.listarDoInicio();
    }

    public static void testarInsereFim() {
        System.out.println("\n=== TESTE insereFim ===");

        ListaDupla lista = new ListaDupla(
                new Livro("111", "Java", "Autor A", 2020));

        lista.insereFim(
                new Livro("333", "Banco de Dados", "Autor C", 2022));

        // Esperado:
        // Imprimir primeiro o livro Banco de Dados e depois o Java
        lista.listarDoFim();
    }

    public static void testarRemovePrimeiro() {
        System.out.println("\n=== TESTE removePrimeiro ===");

        ListaDupla lista = new ListaDupla(
                new Livro("111", "Livro 1", "Autor A", 2020));

        lista.insereFim(
                new Livro("222", "Livro 2", "Autor B", 2021));

        Livro removido = lista.removePrimeiro();

        // Esperado:
        // Livro 1
        System.out.println("Removido: " + removido);

        // Esperado:
        // null
        System.out.println("Busca ISBN 111: "
                + lista.buscarPorIsbn("111"));

        // Esperado:
        // Livro 2
        System.out.println("Busca ISBN 222: "
                + lista.buscarPorIsbn("222"));
    }

    public static void testarRemoveUltimo() {
        System.out.println("\n=== TESTE removeUltimo ===");

        ListaDupla lista = new ListaDupla(
                new Livro("111", "Livro 1", "Autor A", 2020));

        lista.insereFim(
                new Livro("222", "Livro 2", "Autor B", 2021));

        lista.insereFim(
                new Livro("333", "Livro 3", "Autor C", 2022));

        Livro removido = lista.removeUltimo();

        // Esperado:
        // Livro 3
        System.out.println("Removido: " + removido);

        // Esperado:
        // null
        System.out.println("Busca ISBN 333: "
                + lista.buscarPorIsbn("333"));

        // Esperado:
        // Livro 2
        System.out.println("Busca ISBN 222: "
                + lista.buscarPorIsbn("222"));
    }

    public static void testarBuscarPorIsbn() {
        System.out.println("\n=== TESTE buscarPorIsbn ===");

        ListaDupla lista = new ListaDupla(
                new Livro("111", "Java", "Autor A", 2020));

        lista.insereFim(
                new Livro("222", "Python", "Autor B", 2021));

        lista.insereFim(
                new Livro("333", "C#", "Autor C", 2022));

        // Esperado:
        // Livro Python
        System.out.println(lista.buscarPorIsbn("222"));

        // Esperado:
        // null
        System.out.println(lista.buscarPorIsbn("999"));
    }

    public static void testarTamanho() {
        System.out.println("\n=== TESTE tamanho ===");

        ListaDupla lista = new ListaDupla(
                new Livro("111", "Livro 1", "Autor A", 2020));

        // Esperado: 1
        System.out.println("Tamanho: " + lista.tamanho());

        lista.insereFim(
                new Livro("222", "Livro 2", "Autor B", 2021));

        // Esperado: 2
        System.out.println("Tamanho: " + lista.tamanho());

        lista.insereFim(
                new Livro("333", "Livro 3", "Autor C", 2022));

        // Esperado: 3
        System.out.println("Tamanho: " + lista.tamanho());

        lista.removeUltimo();

        // Esperado: 2
        System.out.println("Tamanho: " + lista.tamanho());
    }

    public static void testarListarDoInicio() {
        System.out.println("\n=== TESTE listarDoInicio ===");

        ListaDupla lista = new ListaDupla(
                new Livro("111", "Livro 1", "Autor A", 2020));

        lista.insereFim(
                new Livro("222", "Livro 2", "Autor B", 2021));

        lista.insereFim(
                new Livro("333", "Livro 3", "Autor C", 2022));

        // Esperado:
        // Livro 1
        // Livro 2
        // Livro 3
        lista.listarDoInicio();
    }

    public static void testarListarDoFim() {
        System.out.println("\n=== TESTE listarDoFim ===");

        ListaDupla lista = new ListaDupla(
                new Livro("111", "Livro 1", "Autor A", 2020));

        lista.insereFim(
                new Livro("222", "Livro 2", "Autor B", 2021));

        lista.insereFim(
                new Livro("333", "Livro 3", "Autor C", 2022));

        // Esperado:
        // Livro 3
        // Livro 2
        // Livro 1
        lista.listarDoFim();
    }
}