
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro {

    protected String nome_pessoa;
    protected int idade; 
    protected String cpf; 
    protected String natal;
    protected String endereço; 
    protected String telefone;
    protected int numeroProntuário;
    protected String listaConsulta;
    protected String listaExames;
    
    Scanner leia = new Scanner(System.in);
    
    private String nome_pessoa1, natal1, endereço1, telefone1, listaConsulta1, listaExames1,cpf1;
    private int idade1, numeroProntuário1;
    /*
    private static class Medico {
        private String nome;
        private int idade;
        private String cpf;
        private String coren;
        private String telefone;
        private String Especial;
        
        public Medico(String nome, int idade, String cpf, String coren, String telefone, String Especial) {
            this.nome = nome;
            this.idade = idade;
            this.cpf = cpf;
            this.coren = coren;
            this.telefone = telefone;
            this.Especial = Especial;
        }
        
        public void exibir() {
            System.out.println("\n*** Dados do Médico ***");
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
            System.out.println("CPF: " + cpf);
            System.out.println("COREN: " + coren);
            System.out.println("Telefone: " + telefone);
            System.out.println("Especialização: " + Especial);
        }
    }
    */
    public Cadastro(String nome_pessoa, int idade, String cpf, String natal, String endereço, String telefone,
            int numeroProntuário, String listaConsulta, String listaExames) {
        this.nome_pessoa = nome_pessoa;
        this.idade = idade;
        this.cpf = cpf;
        this.natal = natal;
        this.endereço = endereço;
        this.telefone = telefone;
        this.numeroProntuário = numeroProntuário;
        this.listaConsulta = listaConsulta;
        this.listaExames = listaExames;
    }
    
    public Cadastro() {}

   
    public void setNome_pessoa1(String nome_pessoa1) {
        this.nome_pessoa1 = nome_pessoa1;
    }

    public void setNatal1(String natal1) {
        this.natal1 = natal1;
    }

    public void setEndereço1(String endereço1) {
        this.endereço1 = endereço1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public void setListaConsulta1(String listaConsulta1) {
        this.listaConsulta1 = listaConsulta1;
    }

    public void setListaExames1(String listaExames1) {
        this.listaExames1 = listaExames1;
    }

    public void setIdade1(int idade1) {
        this.idade1 = idade1;
    }

    public void setCpf1(String cpf1) {
        this.cpf1 = cpf1;
    }

    public void setNumeroProntuário1(int numeroProntuário1) {
        this.numeroProntuário1 = numeroProntuário1;
    }
   
    
    public void transferir() {
        this.nome_pessoa = this.nome_pessoa1;
        this.idade = this.idade1;
        this.cpf = this.cpf1;
        this.natal = this.natal1;
        this.endereço = this.endereço1;
        this.telefone = this.telefone1;
        this.numeroProntuário = this.numeroProntuário1;
        this.listaConsulta = this.listaConsulta1;
        this.listaExames = this.listaExames1;
    }
    
    public void exibirCadastro() {
        System.out.println("\n*** Dados do Paciente ***");
        System.out.println("Nome: " + nome_pessoa);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
        System.out.println("Data de Nascimento: " + natal);
        System.out.println("Endereço: " + endereço);
        System.out.println("Telefone: " + telefone);
        System.out.println("Número do Prontuário: " + numeroProntuário);
        System.out.println("Consultas Agendadas: " + listaConsulta);
        System.out.println("Exames Solicitados: " + listaExames);
    }

    public void VisualizarCadastro() {
        Scanner leia = new Scanner(System.in);
        List<Cadastro> listaPacientes = new ArrayList<>();
       // List<Medico> listaMedicos = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE SAÚDE =====");
            System.out.println("1 - Cadastrar Paciente");
            System.out.println("2 - Cadastrar Médico");
            System.out.println("3 - Listar Pacientes");
            System.out.println("4 - Listar Médicos");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = leia.nextInt();
            leia.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarNovoPaciente(leia, listaPacientes);
                    break;
                //case 2:
                   // cadastrarNovoMedico(leia, listaMedicos);
                    //break;
                case 3:
                    listarPacientes(listaPacientes);
                    break;
                //case 4:
                    //listarMedicos(listaMedicos);
                   // break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
        
        leia.close();
    }

    private static void cadastrarNovoPaciente(Scanner leia, List<Cadastro> lista) {
        Cadastro novoCadastro = new Cadastro();
        
        System.out.println("\n*** NOVO CADASTRO DE PACIENTE ***");
        
        System.out.print("Nome completo: ");
        novoCadastro.setNome_pessoa1(leia.nextLine());
        
        System.out.print("Idade: ");
        novoCadastro.setIdade1(leia.nextInt());
        leia.nextLine();  
        
        System.out.print("CPF: ");
        novoCadastro.setCpf1(leia.nextLine());
        
        System.out.print("Data de nascimento (DD/MM/AAAA): ");
        novoCadastro.setNatal1(leia.nextLine());
        
        System.out.print("Endereço completo: ");
        novoCadastro.setEndereço1(leia.nextLine());
        
        System.out.print("Telefone: ");
        novoCadastro.setTelefone1(leia.nextLine());
        
        System.out.print("Número do prontuário: ");
        novoCadastro.setNumeroProntuário1(leia.nextInt());
        leia.nextLine();  
        
        System.out.print("Consultas agendadas (separadas por vírgula): ");
        novoCadastro.setListaConsulta1(leia.nextLine());
        
        System.out.print("Exames solicitados (separados por vírgula): ");
        novoCadastro.setListaExames1(leia.nextLine());

        novoCadastro.transferir();
        
        lista.add(novoCadastro);
        
        System.out.println("\nPaciente cadastrado com sucesso!");
    }
    
    private static void listarPacientes(List<Cadastro> lista) {
        if (lista.isEmpty()) {
            System.out.println("\nNenhum paciente cadastrado!");
            return;
        }
        
        System.out.println("\n===== PACIENTES CADASTRADOS =====");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("\nPaciente #" + (i + 1));
            lista.get(i).exibirCadastro();
        }
    }
}
