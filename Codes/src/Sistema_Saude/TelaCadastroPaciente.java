package Sistema_Saude;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

public class TelaCadastroPaciente extends JFrame implements ActionListener{
	
	List<Cadastros> listaPacientes;
	Cadastros cadastro;
	JFrame janela;
	JButton cad;
	JButton can;
	
	int prontuario;
	JTextField textoNome;
	JTextField textoIdade;
	JTextField textoCpf;
	JTextField textoNatal;
	JTextField textoEndereço;
	JTextField textoTel;
	
	TelaCadastroPaciente(List<Cadastros> listaPacientes){
		this.listaPacientes = listaPacientes;
	}
	
	public void exibirTela() {
		ImageIcon icone = new ImageIcon("arena_sus.jpeg*");
		Image iconeEscala2 = icone.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon iconeJanela = new ImageIcon(iconeEscala2);
		
		janela = new JFrame("Cadastro Cliente");
		janela.setSize(500,525);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setLayout(null);
		
		JPanel painelTex = new JPanel();
		painelTex.setLayout(new GridLayout(7,2,10,20));
		painelTex.setBounds(50,75,400,350);
		
		Border borda = BorderFactory.createLineBorder(Color.black,2);
		JLabel titulo = new JLabel("Cadastro cliente");
		titulo.setVerticalAlignment(JLabel.NORTH); 
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setForeground(Color.black);
		titulo.setBackground(Color.lightGray);
		titulo.setBorder(borda);
		titulo.setOpaque(true);
		titulo.setBounds(50,20,400,25);
		titulo.setFont(new Font("Calibri",Font.BOLD,19));
		JLabel nome = new JLabel("Nome:");
		JLabel idade = new JLabel("Idade:");
		JLabel cpf = new JLabel("Cpf:");
		JLabel natal = new JLabel("Data de nascimento (dd/mm/aa):");
		JLabel end = new JLabel("Endereço:");
		JLabel tel = new JLabel("Telefone/Celular (DDD incluso):");
		
		 textoNome = new JTextField();
		 textoIdade = new JTextField();
		 textoCpf = new JTextField();
		 textoNatal = new JTextField();
		 textoEndereço = new JTextField();
		 textoTel = new JTextField();
		
		cad = new JButton("Cadastrar");
		cad.setForeground(Color.white);
		cad.setBackground(Color.blue);
		cad.addActionListener(this);
		
		can = new JButton("Cancelar");
		can.addActionListener(this);
		
		painelTex.add(nome);
		painelTex.add(textoNome);
		painelTex.add(idade);
		painelTex.add(textoIdade);
		painelTex.add(cpf);
		painelTex.add(textoCpf);
		painelTex.add(natal);
		painelTex.add(textoNatal);;
		painelTex.add(end);
		painelTex.add(textoEndereço);
		painelTex.add(tel);
		painelTex.add(textoTel);
		painelTex.add(cad);
		painelTex.add(can);
	
		janela.add(painelTex);
		janela.add(titulo);
		janela.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Notificar mensagem = new Notificar();
		cadastro = new Cadastros();
		
		if(e.getSource() == can) {
			janela.dispose();
		}
		else if(e.getSource() == cad) {
			if(verificaTextoCadastro(textoNome.getText(),textoIdade.getText(),textoCpf.getText()
				    				,textoNatal.getText(),textoEndereço.getText(),textoTel.getText())) 
			{	
				prontuario = Cadastros.gerarNovoProntuario();
				cadastro.setNumProntuario(prontuario);
				cadastro.setNome_pessoa1(textoNome.getText());
				cadastro.setIdade1(textoIdade.getText());
				cadastro.setCpf1(textoCpf.getText());
				cadastro.setNatal1(textoNatal.getText());
		    	cadastro.setEndereço1(textoEndereço.getText());
		    	cadastro.setTelefone1(textoTel.getText());
		    	cadastro.transferir();
		    //cadastro.setListaPacientes(cadastro);
		    	listaPacientes.add(cadastro);
		   
		    	
		    	cadastro.listarPacientes(listaPacientes);
				mensagem.notMensagem("O paciente foi cadastrado com sucesso");
				janela.dispose();
		    }
		}
	}
	
	public boolean verificaTextoCadastro(String nome,String idade,String cpf,String natal,String endereço,String telefone) {
		if(new Operacao().verificaTexto(nome,idade,cpf,natal,endereço,telefone)) {
			if(!new Operacao().verificaNome(nome)) {
				return false;
			}
			else if(!new Operacao().verificaIdade(idade)) {
				return false;
			}
			else if (!new Operacao().verificaCpf(cpf, listaPacientes)) {
				return false;
			}
			else if(!new Operacao().verificaNatal(natal)) {
				return false;
			}
			else if (!new Operacao().verificaTelefone(telefone, listaPacientes)) {
				return false;
			}
		}
		else {new Notificar().notMensagem("Preencha-os devidamente e tente novamente."); return false;}
		return true;
	}
}
