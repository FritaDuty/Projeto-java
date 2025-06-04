package Sistema_Saude;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Notificar {
	List<Cadastros> listaPacientes = new ArrayList<>();
	List<Historico> historicoMedico = new ArrayList<>();
	
	Notificar(List<Cadastros> listaPacientes, List<Historico> historicoMedico){
		this.listaPacientes = listaPacientes;
		this.historicoMedico = historicoMedico;
	}
	
	Notificar(){}
	Operacao operaçao = new Operacao(listaPacientes,historicoMedico);
	
	public String solicitaInput() {
		String cod = JOptionPane.showInputDialog(null,"Digite o numero de prontuário.","N° Cod.",3);
		return cod;
		
	}
	
	public boolean verificaInput(String cod) {
		Notificar mensagem = new Notificar();
		
		if(cod == null || cod.isEmpty()) {
			return false;
		}
		else if(cod.isBlank() || cod.length() != 5 ) {
			mensagem.notMensagem("O número informado não se encontro no sistema, tente novamente.");
			return false;
		}
		
		for (Cadastros cadastro : listaPacientes) {
			if(cadastro.possuiNumero(cod)) {
				operaçao.setUltimoCod(cod);
				return true;
			}
		}
		
		mensagem.notMensagem("O código informado não se encontro no sistema, tente novamente.");
		return false;
	}
	public void notMensagem(String string) {
		JOptionPane.showMessageDialog(null, string);
	}
}

