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

public class Editar extends JFrame implements ActionListener{

	JFrame janela;
	JButton editar;
	JButton cancelar;
	
	
	JTextField textoNome;
	JTextField textoIdade;
	JTextField textoCpf;
	JTextField textoNatal; 
	JTextField textoEndereço; 
	JTextField textoTel;
	
	private List<Cadastros> listaPacientes = new ArrayList<>();
	private Cadastros cadastro;
	private String cod;
	
	Editar(String cod, Cadastros cadastro, List<Cadastros> listaPacientes){
		this.cod = cod;
		this.cadastro = cadastro;
		this.listaPacientes = listaPacientes;
		}
	
	public void exibir() {
		ImageIcon icone = new ImageIcon("arena_sus.jpeg");
		Image iconeEscala2 = icone.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon iconeJanela = new ImageIcon(iconeEscala2);
		
		
		janela = new JFrame("Editar Cadastro");
		janela.setSize(500,525);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setLayout(null);
		janela.setIconImage(iconeJanela.getImage());
		
		
		JPanel painelTex = new JPanel();
		painelTex.setLayout(new GridLayout(7,2,10,20));
		painelTex.setBounds(50,75,400,350);
		
		Border borda = BorderFactory.createLineBorder(Color.black,2);
		JLabel titulo = new JLabel("Editar Cadastro");
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
		JLabel tel = new JLabel("Telefone:");
		
		 textoNome = new JTextField(cadastro.getNome_pessoa());
		 textoIdade = new JTextField(cadastro.getIdade());
		 textoCpf = new JTextField(cadastro.getCpf());
		 textoNatal = new JTextField(cadastro.getNatal());
		 textoEndereço = new JTextField(cadastro.getEndereço());
		 textoTel = new JTextField(cadastro.getTelefone());
		
		editar = new JButton("Salvar");
		editar.setForeground(Color.white);
		editar.setBackground(Color.blue);
		editar.addActionListener(this);
		
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);
		
		
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
		painelTex.add(editar);
		painelTex.add(cancelar);
		
		
		janela.add(painelTex);
		janela.add(titulo);
		
		
		janela.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Notificar mensagem = new Notificar();
		if(e.getSource() == editar) {
			if(verificaTextoCadastro(textoNome.getText(),textoIdade.getText(),textoCpf.getText()
					,textoNatal.getText(),textoEndereço.getText(),textoTel.getText())) 
				{
					cadastro.setNome_pessoa1(textoNome.getText());
					cadastro.setIdade1(textoIdade.getText());
					cadastro.setCpf1(textoCpf.getText());
					cadastro.setNatal1(textoNatal.getText());
					cadastro.setEndereço1(textoEndereço.getText());
					cadastro.setTelefone1(textoTel.getText());
					cadastro.transferir();
		    
					listaPacientes.set(listaPacientes.indexOf(cadastro),cadastro);
					//cadastro.setListaPacientes(cadastro);
		   
			
					mensagem.notMensagem("O cadastro foi editado com sucesso");
					janela.dispose();
			}
		}
		else if(e.getSource() == cancelar) {
			janela.dispose();
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
			else if (!new Operacao().verificaCpfEditado(cpf, listaPacientes, cadastro.getCpf())) {
				return false;
			}
			else if(!new Operacao().verificaNatal(natal)) {
				return false;
			}
			else if (!new Operacao().verificaTelefoneEditado(telefone, listaPacientes, cadastro.getTelefone())) {
				return false;
			}
		}
		else {new Notificar().notMensagem("Preencha-os devidamente e tente novamente."); return false;}
		return true;
	}

}