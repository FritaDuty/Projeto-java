package Sistema_Saude;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

public class Agendar extends JFrame implements ActionListener{
	
	Historico novohistorico;
	
	JTextField caixaConsultas;
	JTextField caixaDataConsultas;
	JTextField caixaHoraConsultas;
	JTextField caixaExames;
	JTextField caixaDataExames;
	JTextField caixaHoraExames;
	
	
	JFrame tela;
	JButton cons;
	JButton dataCo;
	JButton horaCo;
	JButton agendar;
	JButton cancelar;
	
	List<Cadastros> listaPacientes = new ArrayList<>();
	List<Historico> historicoMedico = new ArrayList<>();
	String cod;
	
	
	Agendar(List<Cadastros> lista,List<Historico> historico,String cod){
		this.listaPacientes = lista;
		this.historicoMedico = historico;
		this.cod = cod;
	}
	
	public void exibir(){
		
		ImageIcon icone = new ImageIcon("arena_sus.jpeg");
		Image iconeEscala2 = icone.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon iconeJanela = new ImageIcon(iconeEscala2);
		
		
		tela = new JFrame("Arena SUS");
		tela.setSize(450,500);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		tela.setLayout(null); 
		tela.setBackground(new Color(0xD1234567));
		tela.setIconImage(iconeJanela.getImage());
		
		JPanel painel = new JPanel();
		painel.setLayout(new GridLayout(7,1,50,5)); 
		painel.setBounds(20,110,400,200);
		
		Border borda = BorderFactory.createLineBorder(Color.black,2);
		JLabel titulo = new JLabel("Agendar Consulta");
		titulo.setVerticalAlignment(JLabel.NORTH); 
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setForeground(Color.black);
		titulo.setBackground(Color.lightGray);
		titulo.setBorder(borda);
		titulo.setOpaque(true);
		titulo.setBounds(125,80,200,25);
		titulo.setFont(new Font("Calibri",Font.BOLD,19));
		
		JLabel cons = new JLabel("Consulta Solicitada");
		JLabel dataCo = new JLabel("Data da Consulta (dd/06/2025):");
		JLabel horaCo = new JLabel("Hora da Consulta (hh:mm):");
		JLabel exa = new JLabel("Exame Solicitado");
		JLabel dataEx = new JLabel("Data do Exame (dd/06/2025):");
		JLabel horaex = new JLabel("Hora do Exame (hh:mm):");
	
		 caixaConsultas = new JTextField();
		 caixaDataConsultas = new JTextField();
		 caixaHoraConsultas = new JTextField();
		 caixaExames = new JTextField();
		 caixaDataExames = new JTextField();
		 caixaHoraExames = new JTextField();
		
		agendar = new JButton("Agendar");
		agendar.setForeground(Color.white);
		agendar.setBackground(Color.blue);
		agendar.addActionListener(this);
		
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);
		
		painel.add(cons);
		painel.add(caixaConsultas);
		painel.add(dataCo);
		painel.add(caixaDataConsultas);
		painel.add(horaCo);
		painel.add(caixaHoraConsultas);
		painel.add(exa);
		painel.add(caixaExames);
		painel.add(dataEx);
		painel.add(caixaDataExames);
		painel.add(horaex);
		painel.add(caixaHoraExames);
		painel.add(agendar);
		painel.add(cancelar);
	
		tela.add(painel);
		tela.add(titulo);
		tela.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Notificar mensagem = new Notificar();
		
		if(e.getSource() == agendar) {
			if(verificaTextoAgendamento(caixaConsultas.getText(), 
					caixaDataConsultas.getText(), 
					caixaHoraConsultas.getText(),
					caixaExames.getText(), 
					caixaDataExames.getText(), 
					caixaHoraExames.getText())) 
			{
				novohistorico = new Historico(cod,caixaConsultas.getText(),caixaDataConsultas.getText(),caixaHoraConsultas.getText(),
											caixaExames.getText(),caixaDataExames.getText(), caixaHoraExames.getText());
				historicoMedico.add(novohistorico);
				mensagem.notMensagem("A consulta e exame agendados.");
				tela.dispose();
			}

		}
		else if(e.getSource() == cancelar) {
			tela.dispose();
		}
		
	}
	
	public boolean verificaTextoAgendamento(String consulta,String dataConsulta,String horaConsulta,String exame,String dataExame,String horaExame) {
		if(new Operacao().verificaTexto(consulta,dataConsulta,horaConsulta,exame,dataExame,horaExame)) {
			
			if(!new Operacao().verificaData(dataConsulta, dataExame)) {
				return false;
			}
			else if (!new Operacao().verificaHora(horaConsulta,horaExame)) {
				new Notificar().notMensagem("Digite um horário válido ao modelo exemplo: \"XX:XX\"");
				return false;
			}
		}
		else {new Notificar().notMensagem("Preencha os espaços em branco e tente novamente."); return false;}
		return true;
	}
}
