package Sistema_Saude;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Operacao {
	List<Cadastros> listaPacientes = new ArrayList<>();
	List<Historico> historicoMedico = new ArrayList<>();
	String ultimoCod;
	Operacao(List<Cadastros> listaPacientes, List<Historico> historicoMedico){
		this.listaPacientes = listaPacientes;
		this.historicoMedico = historicoMedico;
	}
	Operacao(List<Cadastros> listaPacientes){
		this.listaPacientes = listaPacientes;
	}
	Operacao(){}
	
	public void excluirCod(String cod) {
		Iterator<Cadastros> iterator = listaPacientes.iterator();
		while (iterator.hasNext()) {
		    if (iterator.next().possuiNumero(cod)) {
		        iterator.remove();
		        break;
		    }
		}
	}
	
	public Cadastros acharCadastro(String cod) {
		for(Cadastros cadastro: listaPacientes) {
			if(cadastro.possuiNumero(cod)) {
				
				return cadastro;
			}
		}
		return null;
	}
	
	public void setUltimoCod(String cod) {
		this.ultimoCod = cod;
	}
	public String getUltimiCod() {
		return ultimoCod;
	}
	
	public boolean verificaTexto(String texto,String texto2,String texto3,String texto4,String texto5,String texto6) {
		if(texto == null || texto.isBlank() || texto2 == null || texto2.isBlank() || texto3 == null || texto3.isBlank() ||
			texto4 == null || texto4.isBlank() || texto5 == null || texto5.isBlank() || texto6 == null || texto6.isBlank()) {
			return false;}
		
		return true;
	}
	
	
	public boolean verificaNome(String nome) {
		for(char c: nome.toCharArray()) {
			if(!Character.isLetter(c) && c != ' ' && c != '-') {
				new Notificar().notMensagem("O nome não pode possuir números. Tente novamente.");
				return false;
			}
		}
		if(nome.length() < 3) {
			new Notificar().notMensagem("Um nome deve conter mais de 2 dígitos.");
			return false;
		}
		return true;
	}
	
	public boolean verificaIdade(String idade) {
		for(char c:idade.toCharArray()) {
			if(Character.isLetter(c)) {
				new Notificar().notMensagem("A idade não pode conter letras");
				return false;
			}
		}
		
		if(Integer.parseInt(idade) > 120) {
			new Notificar().notMensagem("Mais de 120 anos? Até parece. Corrija essa informação e tente novamente.");
			return false;
		}else if(Integer.parseInt(idade) < 0) {
			new Notificar().notMensagem("Você nem nasceu ainda.");
			return false;
		}
		
		return true;
	}
	
	public boolean verificaCpf(String cpf, List<Cadastros> lista) {
		for(char c: cpf.toCharArray()) {
			if(Character.isLetter(c)) {
				new Notificar().notMensagem("O cpf não pode conter letras.");
				return false;
			}
		}
		if (cpf.length() != 11) {
			new Notificar().notMensagem("O cpf deve conter 11 dígitos. Tente novamente.");
			return false;
		}
		
		for(Cadastros cadastro: lista) {
    		if(cadastro.getCpf().equals(cpf)) {
    			new Notificar().notMensagem("O cpf digitado pertence a outra pessoa. Tente novamente.");
    			return false;
    		}
    	}
    	return true;
    }
	
	public boolean verificaCpfEditado(String cpf, List<Cadastros> lista, String cpfOriginal) {
		for(char c: cpf.toCharArray()) {
			if(Character.isLetter(c)) {
				new Notificar().notMensagem("O cpf não pode conter letras.");
				return false;
			}
		}
		
		if (cpf.length() != 11) {
			new Notificar().notMensagem("O cpf deve conter 11 dígitos. Tente novamente.");
			return false;
		}
		for(Cadastros cadastro: lista) {
			if(cadastro.getCpf().equals(cpf) && !cadastro.getCpf().equals(cpfOriginal)) {
				new Notificar().notMensagem("O cpf digitado pertence a outra pessoa. Tente novamente.");
				return false;
			}
		}
		return true;
	}
	
	public boolean verificaTelefone(String telefone, List<Cadastros> lista) {
		
		for(char c: telefone.toCharArray()) {
			if(Character.isLetter(c)) {
				new Notificar().notMensagem("O telefone não pode conter letras.");
				return false;
			}
		}
		
		if (telefone.length() < 10) {
			new Notificar().notMensagem("O telefone deve conter ao menos 10 dígitos incluindo DDD");
			return false;
		}
		else if (telefone.length() > 11) {
			new Notificar().notMensagem("O telefone deve conter no máximo 11 dígitos incluindo DDD");
			return false;
		}
		else if (telefone.length() == 11) {
			for(Cadastros cadastro: lista) {
	    		if(cadastro.getTelefone().equals(telefone)) {
	    			new Notificar().notMensagem("O numero de telefone "+telefone+" pertence a uma outra pessoa.");
	    			return false;
	    		}
	    	}
		}
		return true;
    }
	
	public boolean verificaTelefoneEditado(String telefone, List<Cadastros> lista, String telefoneOriginal) {
		
		for(char c: telefone.toCharArray()) {
			if(Character.isLetter(c)) {
				new Notificar().notMensagem("O telefone não pode conter letras.");
				return false;
			}
		}
		
		if (telefone.length() < 10) {
			new Notificar().notMensagem("O telefone deve conter ao menos 10 dígitos incluindo DDD");
			return false;
		}
		else if (telefone.length() > 11) {
			new Notificar().notMensagem("O telefone deve conter no máximo 11 dígitos incluindo DDD");
			return false;
		}
		else if (telefone.length() == 11) {
			for(Cadastros cadastro: lista) {
	    		if(cadastro.getTelefone().equals(telefone) && !cadastro.getTelefone().equals(telefoneOriginal)) {
	    			new Notificar().notMensagem("O numero de telefone "+telefone+" pertence a uma outra pessoa.");
	    			return false;
	    		}
	    	}
		}
		return true;
    }
	
	public boolean verificaNatal(String natal) {
		if(natal.length() != 10 || natal.charAt(2) != '/' || natal.charAt(5) != '/') {
			new Notificar().notMensagem("Digite uma data válida com o exemplo: xx/xx/xxxx");
			return false;
		}
		return true;
	}
	
	
	
	public boolean verificaHora(String hora, String hora2) {
		for (char c: hora.toCharArray()) {
			if(Character.isLetter(c)) {
				return false;
			}
		}
		for (char c: hora2.toCharArray()) {
			if(Character.isLetter(c)) {
				return false;
			}
		}
		if(hora.length() != 5 || hora.charAt(2) != ':' || hora2.length() != 5 || hora2.charAt(2) != ':') {
			return false;
		}
		return true;
	}
	
	public boolean verificaData(String data, String data2) {
		if (Integer.parseInt(data) > 30 || Integer.parseInt(data) < 1) {
			new Notificar().notMensagem("O dia "+data+" não existe no calendário, tente novamente.");
			return false;
		}
		else if (Integer.parseInt(data2) > 30 || Integer.parseInt(data2) < 1) {
			new Notificar().notMensagem("O dia "+data2+" não existe no calendário, tente novamente.");
			return false;
		}
		
		
		
		return true;
	}
}