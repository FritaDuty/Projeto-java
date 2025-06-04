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

public class TelaInicial extends JFrame implements ActionListener {

	List<Cadastros> listaPacientes = new ArrayList<>();
	List<Historico> historicoMedico = new ArrayList<>();
	JFrame inicio;
	
	JButton cadPa ;
	JButton lisPa ;
	JButton agendar ;
	JButton consultas ;
	JButton excluir;
	JButton editar;
	JButton sair;
	
	public TelaInicial() {}
		
	public void mostrarTela() {
		inicio = new JFrame("Arena SUS");
		inicio.setSize(400,500);
		inicio.setResizable(false);
		inicio.setLocationRelativeTo(null);
		inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicio.setLayout(null); 
		inicio.setBackground(new Color(0xD1234567));
		
		JPanel painel = new JPanel();
		painel.setLayout(new GridLayout(8,1,10,5)); 
		painel.setBounds(90,160,200,200);
		
		ImageIcon icone = new ImageIcon("arena_sus.jpeg");
		Image iconeEscala1 = icone.getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH);
		Image iconeEscala2 = icone.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon iconeMenor = new ImageIcon(iconeEscala1);
		ImageIcon iconeJanela = new ImageIcon(iconeEscala2);
		inicio.setIconImage(iconeJanela.getImage());
		
		JLabel titulo = new JLabel(iconeMenor);
		titulo.setBounds(90,40,200,100);
		titulo.setFont(new Font("Calibri",Font.BOLD,15));
		titulo.setForeground(Color.black);
		
		cadPa = new JButton("Cadastrar Paciente");
		cadPa.addActionListener(this);
		
		lisPa = new JButton("Cadastros");
		lisPa.addActionListener(this);
		
		agendar = new JButton("Agendar Consulta");
		agendar.addActionListener(this);
		
		consultas = new JButton("Histórico de Consultas");
		consultas.addActionListener(this);
		
		editar = new JButton("Editar");
		editar.addActionListener(this);
		
		excluir = new JButton("Excluir");
		excluir.addActionListener(this);
		
		sair = new JButton("Sair");
		sair.addActionListener(this);
		sair.setForeground(Color.white);
		sair.setBackground(Color.blue);
		
		painel.add(cadPa);
		painel.add(lisPa);
		painel.add(agendar);
		painel.add(consultas);
		painel.add(editar);
		painel.add(excluir);
		painel.add(sair);
		
		inicio.add(painel);
		inicio.add(titulo);
		inicio.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Notificar mensagem = new Notificar(listaPacientes,historicoMedico);
		if(e.getSource() == cadPa) { // cadastrar novos pacientes
			TelaCadastroPaciente cadastro = new TelaCadastroPaciente(listaPacientes);
			cadastro.exibirTela();
		}
		else if(e.getSource() == lisPa) { // lista de pacientes cadastrados
			TelaLista telaLista = new TelaLista(listaPacientes);
			telaLista.cadastros();
		}
		else if(e.getSource() == agendar) { // agendamento de consultas
			if(listaPacientes.size() < 1) {
				mensagem.notMensagem("Não há cadastros no sistema");
			}
			else {
				String cod = mensagem.solicitaInput();
				if(mensagem.verificaInput(cod)) {
					Agendar agendar = new Agendar(listaPacientes,historicoMedico,cod);
					agendar.exibir();
				}
			}
		}
		else if(e.getSource() == consultas) { // historico de consultas
				TelaLista telaLista = new TelaLista(listaPacientes,historicoMedico);
				telaLista.historio();
		}
		else if(e.getSource() == editar) { // editar cadastro
			if(listaPacientes.size() < 1) {
				mensagem.notMensagem("Não há cadastros no sistema");
			}
			else {
			String cod = mensagem.solicitaInput();
				if(mensagem.verificaInput(cod)) {
					Cadastros cadastro = new Operacao(listaPacientes).acharCadastro(cod);
					if(cadastro != null) {new Editar(cod,cadastro,listaPacientes).exibir();}
					else {mensagem.notMensagem("Cadastro não encontrado para o código informado.");}
				}
			}
		}
		else if(e.getSource() == excluir) { // excluir cadastro
			if(listaPacientes.size() < 1) {
				mensagem.notMensagem("Não há cadastros no sistema");
			}
			else {
				String cod = mensagem.solicitaInput();
				if(mensagem.verificaInput(cod)) {
					new Operacao(listaPacientes).excluirCod(cod);
					mensagem.notMensagem("O cadastro foi excluido do sistema.");
				}
			}
		}
		else if(e.getSource() == sair) {
			System.exit(0);
		}
	}
}