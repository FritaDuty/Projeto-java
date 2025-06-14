package Sistema_Saude;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastros {
	protected static int contNum = 10000;
	protected int numProntuario = 0;
    protected String nome_pessoa;
    protected String idade; 
    protected String cpf; 
    protected String natal;
    protected String endereço; 
    protected String telefone;
  
    Scanner leia = new Scanner(System.in);
    private String nome_pessoa1, natal1, endereço1, telefone1,cpf1, idade1;
    public Cadastros(int numProntuario, String nome_pessoa, String idade, String cpf, String natal, String endereço, String telefone) {
        this.numProntuario = contNum ;
    	this.nome_pessoa = nome_pessoa;
        this.idade = idade;
        this.cpf = cpf;
        this.natal = natal;
        this.endereço = endereço;
        this.telefone = telefone;
    }
   
    public Cadastros() {}
   
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
    public void setIdade1(String idade1) {
        this.idade1 = idade1;
    }
    public void setCpf1(String cpf1) {
        this.cpf1 = cpf1;
    }
    
    public void setNumProntuario(int numero) {
    	this.numProntuario = numero;
    }
    public int getNumProntuario() {
    	return numProntuario;
    }
    public String getNome_pessoa() {
		return nome_pessoa;
	}
	public String getIdade() {
		return idade;
	}
	public String getCpf() {
		return cpf;
	}
	public String getNatal() {
		return natal;
	}
	public String getEndereço() {
		return endereço;
	}
	public String getTelefone() {
		return telefone;
	}

	public void transferir() {
        this.nome_pessoa = this.nome_pessoa1;
        this.idade = this.idade1;
        this.cpf = this.cpf1;
        this.natal = this.natal1;
        this.endereço = this.endereço1;
        this.telefone = this.telefone1;
    }
    protected void listarPacientes(List<Cadastros> listaPacientes) {
        if (listaPacientes.isEmpty()) {
            System.out.println("\nNenhum paciente cadastrado!");
            return;
        }
        System.out.println("\n===== PACIENTES CADASTRADOS =====");
        for (int i = 0; i < listaPacientes.size(); i++) {
            System.out.println("\nPaciente #" + (i + 1));
            listaPacientes.get(i).exibirCadastro();
        }
    }
    public void exibirCadastro() {
        System.out.println("\n*** Dados do Paciente ***");
        System.out.println("Nome: " + nome_pessoa);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
        System.out.println("Data de Nascimento: " + natal);
        System.out.println("Endereço: " + endereço);
        System.out.println("Telefone: " + telefone);
    }
    public static int gerarNovoProntuario() {
        return contNum++;
    }
    
    public boolean possuiNumero(String num) {
    	String numero = String.valueOf(numProntuario);
    	if(numero.equals(num)) {
    		return true;
    	}
    	return false;
    }
    
    
}