package Sistema_Saude;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


public class TelaLista extends JFrame {

	
	
	List<Cadastros> listaPacientes = new ArrayList<>();
	List<Historico> historicoMedico = new ArrayList<>();
	
	TelaLista(List<Cadastros> lista){
		this.listaPacientes = lista;
		
	}
	TelaLista(List<Cadastros> lista,List<Historico> historico){
		this.listaPacientes = lista;
		this.historicoMedico = historico;
	}
	
	public void cadastros() {
		this.setSize(800,300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		String[] topicosPa = {"Cód. Prontuário","Nome","Idade","CPF","Data Nasc.", "Endereço", "Telefone"};
		
		DefaultTableModel modelo = new DefaultTableModel(topicosPa,0);
		
		for(Cadastros cadastro: listaPacientes) {
			Object[] dados = {cadastro.getNumProntuario(),cadastro.getNome_pessoa(),cadastro.getIdade(),cadastro.cpf,cadastro.getNatal(),cadastro.getEndereço(),cadastro.getTelefone()};
			modelo.addRow(dados);
		}
		
		JTable tabelaPa = new JTable(modelo);
		//tabelaPa.setBounds(300,200,700,225);
		JScrollPane barra = new JScrollPane(tabelaPa); // com o scrollpane - não precisa especificar as proporções da tabela
		barra.setBounds(50,20,700,220);
		
		this.add(barra);
	}
	
	
	public void historio() {
		this.setSize(800,300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		String[] topicosHistorico = {"Cod. Prontuário","Consulta","Data Consulta","Hora Consulta.","Exame","Data Exame.", "Hora Exame"};
		
		DefaultTableModel modelo = new DefaultTableModel(topicosHistorico,0);
		
		for(Historico historico: historicoMedico) {
			Object[] dados = {historico.getCod(),historico.getConsulta(),historico.getDataConsulta(),historico.getHoraConsulta(),historico.getExame(),historico.getDataExame(),historico.getHoraExame()};
			modelo.addRow(dados);
		}
			
		
		JTable tabelaHistorico = new JTable(modelo);
		//tabelaPa.setBounds(300,200,700,225);
		JScrollPane barra = new JScrollPane(tabelaHistorico); // com o scrollpane - não precisa especificar as proporções da tabela
		barra.setBounds(50,20,700,220);
		
		this.add(barra);
	}
}