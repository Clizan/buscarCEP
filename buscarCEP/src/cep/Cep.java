package cep;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;

public class Cep extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_cep;
	private JTextField txt_endereco;
	private JTextField txt_bairro;
	private JTextField txt_cidade;
	private JComboBox cmb_uf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cep frame = new Cep();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cep() {
		setTitle("Buscar CEP");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cep.class.getResource("/img/house.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("Sobre");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CEP");
		lblNewLabel.setBounds(20, 25, 46, 14);
		contentPane.add(lblNewLabel);

		txt_cep = new JTextField();
		txt_cep.setBounds(72, 22, 145, 20);
		contentPane.add(txt_cep);
		txt_cep.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Endereço");
		lblNewLabel_1.setBounds(20, 71, 46, 14);
		contentPane.add(lblNewLabel_1);

		txt_endereco = new JTextField();
		txt_endereco.setBounds(72, 68, 330, 20);
		contentPane.add(txt_endereco);
		txt_endereco.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Bairro");
		lblNewLabel_2.setBounds(20, 116, 46, 14);
		contentPane.add(lblNewLabel_2);

		txt_bairro = new JTextField();
		txt_bairro.setBounds(72, 113, 330, 20);
		contentPane.add(txt_bairro);
		txt_bairro.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Cidade");
		lblNewLabel_3.setBounds(20, 158, 46, 14);
		contentPane.add(lblNewLabel_3);

		txt_cidade = new JTextField();
		txt_cidade.setBounds(72, 155, 220, 20);
		contentPane.add(txt_cidade);
		txt_cidade.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("UF");
		lblNewLabel_4.setBounds(316, 158, 21, 14);
		contentPane.add(lblNewLabel_4);

		cmb_uf = new JComboBox();
		cmb_uf.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cmb_uf.setBounds(347, 154, 55, 22);
		contentPane.add(cmb_uf);

		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txt_cep.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Informe o CEP");
					txt_cep.requestFocus();

				} else {

					// bucar CEP
					buscarCEP();

				}

			}
		});
		btn_buscar.setBounds(248, 21, 89, 23);
		contentPane.add(btn_buscar);

		JButton btn_limpar = new JButton("Limpar");
		btn_limpar.setBounds(20, 202, 89, 23);
		contentPane.add(btn_limpar);

		JButton btn_sobre = new JButton("");
		btn_sobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btn_sobre.setToolTipText("Sobre");
		btn_sobre.setBorder(null);
		btn_sobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_sobre.setIcon(new ImageIcon(Cep.class.getResource("/img/information-button.png")));
		btn_sobre.setBackground(SystemColor.control);
		btn_sobre.setBounds(371, 11, 32, 32);
		contentPane.add(btn_sobre);

		/* Uso da biblioteca Atxy2k.jar para validação do campo txt_cep */
		RestrictedTextField validar = new RestrictedTextField(txt_cep);
		validar.setOnlyNums(true);
		validar.setLimit(8);

	} // Fim do construtor

	/* Criar meótodo buscar CEP */
	private void buscarCEP() {

		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txt_cep.getText();
		
		try {
			
			/*Classe modelo utilizada para ler um conteúdo na web*/
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();	
			
			for(Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				
				/* validando se o elemento bairro foi encontrado*/
				if(element.getQualifiedName().equals("bairro")) {
					txt_bairro.setText(element.getText());
				}
				
				/* Validando se o elemento cidade foi encontrada */
				if(element.getQualifiedName().equals("cidade")) {
					/*Setando o valor encontrado após a busca da API*/
					txt_cidade.setText(element.getText());
				}
				
				/* Validando se o elemento uf foi encontrado*/
				if(element.getQualifiedName().equals("uf")) {
					cmb_uf.setSelectedItem(element.getText());
				}
				
				/* Validando se o elemento endereço foi encontrado */
				if(element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				
				/* Validando se o elemento endereço foi encontrado */
				if(element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				
				/* Variavel de apoio para buscar o resultado da API*/
				if(element.getQualifiedName().equals(resultado)) {
					resultado = element.getText();
					
					/* validando se o CEP é um número válido*/
					if(resultado.equals("1")) {
						
					}else {
						JOptionPane.showMessageDialog(null, "CEP não encontrado");
					}
				}
			}
			
			// setar o campo endereço
			txt_endereco.setText(tipoLogradouro + " " + logradouro);
			
		} catch (Exception e) {

			System.out.println(e);
			
		}

	}
}
