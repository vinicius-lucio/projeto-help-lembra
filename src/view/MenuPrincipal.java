package view;

import controller.PessoaController;
import model.Pessoa;
import java.util.Scanner;

public class MenuPrincipal {
    private PessoaController pessoaController;
    private Scanner sc;
    
    public MenuPrincipal() {
        this.pessoaController = new PessoaController();
        this.sc = new Scanner(System.in);
    }
    
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== SISTEMA MEDLEMBRA ===");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Listar pessoas");
            System.out.println("3 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch (opcao) {
                case 1:
                    cadastrarPessoa();
                    break;
                case 2:
                    listarPessoas();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }
    
    private void cadastrarPessoa() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        
        Pessoa pessoa = new Pessoa(nome, idade, telefone);
        pessoaController.adicionarPessoa(pessoa);
        System.out.println("Pessoa cadastrada com sucesso!");
    }
    
    private void listarPessoas() {
        System.out.println("\n=== LISTA DE PESSOAS ===");
        for (Pessoa p : pessoaController.listarPessoas()) {
            System.out.println("- " + p.getNome() + " | " + p.getIdade() + " anos | " + p.getTelefone());
        }
    }
}