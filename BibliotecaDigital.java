import java.util.Scanner;

public class BibliotecaDigital {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        ListaDupla lista = new ListaDupla();
        GestorEmprestimos emprestimos = new GestorEmprestimos();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo à biblioteca digital!");
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    Selecione uma das opções:
                    1 - Cadastrar Livro
                    2 - Buscar Livro por ISBN
                    3 - Listar acervo do início ao fim
                    4 - Listar acervo do fim ao início
                    5 - Solicitar empréstimo
                    6 - Devolver livro
                    7 - Ver fila de espera de um livro
                    0 - Sair
                    """);
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarLivro(scanner, lista, catalogo);
                    break;
                case 2:
                    buscarLivro(scanner, catalogo);
                    break;

                case 3:
                    listarAcervoInicioAoFim(lista);
                    break;

                case 4:
                    listarAcervoFimAoInicio(lista);
                    break;

                case 5:
                    solicitarEmprestimoLivro(scanner, emprestimos, catalogo);
                    break;

                case 6:
                    devolverLivro(scanner, emprestimos, catalogo);
                    System.out.println("Até mais!");
                    break;
                
                case 7:
                    listaEsperaLivro(emprestimos, scanner);
                    break;

                case 0:
                    System.out.println("Até mais!");
                    break;
            
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

    }

    private static void cadastrarLivro(Scanner scanner, ListaDupla lista, Catalogo catalogo) {
        try {
            Livro livro = preencherLivro(scanner, catalogo);
            lista.insereFim(livro);
            catalogo.cadastrar(livro);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Livro preencherLivro(Scanner scanner, Catalogo catalogo) {
        System.out.println("Preencha os dados do livro");
        
        System.out.print("ISBN:");
        String isbn = scanner.nextLine();
        if (catalogo.existe(isbn))
            throw new RuntimeException("ISBN já cadastrado!");

        System.out.print("Título:");
        String titulo = scanner.nextLine();

        System.out.print("Autor:");
        String autor = scanner.nextLine();

        System.out.print("Ano de publicação:");
        int anoPub = scanner.nextInt();
        scanner.nextLine();

        return new Livro(isbn, titulo, autor, anoPub);
    }

    private static void buscarLivro(Scanner scanner, Catalogo catalogo) {
        System.out.print("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine();
        Livro livro = catalogo.buscar(isbn);
        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return;
        }

        System.out.println(livro);
    }

    private static void listarAcervoInicioAoFim(ListaDupla lista) {
        lista.listarDoInicio();
    }

    private static void listarAcervoFimAoInicio(ListaDupla lista) {
        lista.listarDoFim();
    }

    private static void solicitarEmprestimoLivro(Scanner scanner, GestorEmprestimos emprestimos, Catalogo catalogo) {
        System.out.print("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine();
        Livro livro = catalogo.buscar(isbn);
        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return;
        }
        Usuario usuario = preencherUsuario(scanner);
        emprestimos.solicitarEmprestimo(livro, usuario);
    }

    private static Usuario preencherUsuario(Scanner scanner) {
        System.out.println("Preencha seus dados de usuário");
        
        System.out.print("Matrícula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new Usuario(matricula, nome, email);
    }

    private static void devolverLivro(Scanner scanner, GestorEmprestimos emprestimos, Catalogo catalogo) {
        System.out.print("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine();
        Livro livro = catalogo.buscar(isbn);
        emprestimos.devolverLivro(livro);
    }

    private static void listaEsperaLivro(GestorEmprestimos emprestimos, Scanner scanner) {
        System.out.print("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine();
        emprestimos.listarFilaDeEspera(isbn);
    }
}
