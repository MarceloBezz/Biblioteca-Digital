public class TesteGestorEmprestimos {
    public static void main(String[] args) {
        emprestimoLivro();
        emprestimoLivroJaEmprestado();
        devolucaoLivroComFila();
        devolucaoLivroSemFila();
        devolucaoLivroComFilaVazia();
    }

    private static void emprestimoLivro() {
        System.out.println("============================== TESTE 1 ===========================");
        GestorEmprestimos emprestimos = new GestorEmprestimos();
        populaHash(emprestimos.hash);

        Livro livro1 = new Livro("12345", "Estrutura de dados", "Autor 1", 2018);
        System.out.println("Antes do empréstimo: " + livro1);
        emprestimos.solicitarEmprestimo(livro1, new Usuario(1, "Aluno 1", "email@email.com"));

        // O livro deve estar indisponível
        System.out.println(livro1);
    }

    private static void emprestimoLivroJaEmprestado() {
        System.out.println("============================== TESTE 2 ===========================");
        GestorEmprestimos emprestimos = new GestorEmprestimos();
        populaHash(emprestimos.hash);

        Livro livro2 = new Livro("123456", "Java", "Autor 2", 2017);
        emprestimos.solicitarEmprestimo(livro2, new Usuario(1, "Aluno 1", "email@email.com"));
        emprestimos.solicitarEmprestimo(livro2, new Usuario(2, "Aluno 2", "email2@email.com"));
        emprestimos.solicitarEmprestimo(livro2, new Usuario(3, "Aluno 3", "email3@email.com"));

        // O livro deve estar indisponível
        System.out.println(livro2);

        // Deve mostrar os alunos 2 e 3 na fila de espera
        emprestimos.listarFilaDeEspera(livro2.getIsbn());
    }

    private static void devolucaoLivroComFila() {
        System.out.println("============================== TESTE 3 ===========================");
        GestorEmprestimos emprestimos = new GestorEmprestimos();
        populaHash(emprestimos.hash);

        Livro livro3 = new Livro("780432", "Banco de dados", "Autor 3", 2015);
        emprestimos.solicitarEmprestimo(livro3, new Usuario(1, "Aluno 1", "email@email.com"));
        emprestimos.solicitarEmprestimo(livro3, new Usuario(2, "Aluno 2", "email2@email.com"));
        emprestimos.solicitarEmprestimo(livro3, new Usuario(3, "Aluno 3", "email3@email.com"));
        emprestimos.devolverLivro(livro3);

        // O livro deve estar indisponível
        System.out.println(livro3);

        // Deve mostrar o aluno 3 na fila de espera
        emprestimos.listarFilaDeEspera(livro3.getIsbn());
    }

    private static void devolucaoLivroSemFila() {
        System.out.println("============================== TESTE 4 ===========================");
        GestorEmprestimos emprestimos = new GestorEmprestimos();
        populaHash(emprestimos.hash);

        Livro livro4 = new Livro("161548", "Algoritmos", "Autor 4", 2000);
        emprestimos.solicitarEmprestimo(livro4, new Usuario(1, "Aluno 1", "email@email.com"));
        emprestimos.devolverLivro(livro4);

        // O livro deve estar disponível
        System.out.println(livro4);
    }

    private static void devolucaoLivroComFilaVazia() {
        System.out.println("============================== TESTE 5 ===========================");
        GestorEmprestimos emprestimos = new GestorEmprestimos();
        populaHash(emprestimos.hash);

        Livro livro5 = new Livro("789165", "Frontend explicado", "Autor 5", 2026);
        // Deve imprimir "Fila vazia!"
        emprestimos.devolverLivro(livro5);
    }

    private static void populaHash(NossoHash<String, Fila<Usuario>> hash) {
        Livro livro1 = new Livro("12345", "Estrutura de dados", "Autor 1", 2018);
        Livro livro2 = new Livro("123456", "Java", "Autor 2", 2017);
        Livro livro3 = new Livro("780432", "Banco de dados", "Autor 3", 2015);
        Livro livro4 = new Livro("161548", "Algoritmos", "Autor 4", 2000);
        Livro livro5 = new Livro("789165", "Frontend explicado", "Autor 5", 2026);

        hash.put(livro1.getIsbn(), new Fila<>());
        hash.put(livro2.getIsbn(), new Fila<>());
        hash.put(livro3.getIsbn(), new Fila<>());
        hash.put(livro4.getIsbn(), new Fila<>());
        hash.put(livro5.getIsbn(), new Fila<>());
    }

}
