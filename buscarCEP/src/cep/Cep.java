package cep;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class Cep extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_cep;
	private JTextField txt_endereco;
	private JTextField txt_bairro;
	private JTextField txt_cidade;

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
		
		JComboBox cmb_uf = new JComboBox();
		cmb_uf.setBounds(347, 154, 55, 22);
		contentPane.add(cmb_uf);
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.setBounds(248, 21, 89, 23);
		contentPane.add(btn_buscar);
		
		JButton btn_limpar = new JButton("Limpar");
		btn_limpar.setBounds(20, 202, 89, 23);
		contentPane.add(btn_limpar);
		
		JButton btn_sobre = new JButton("");
		btn_sobre.setToolTipText("Sobre");
		btn_sobre.setBorder(null);
		btn_sobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_sobre.setIcon(new ImageIcon(Cep.class.getResource("/img/information-button.png")));
		btn_sobre.setBackground(SystemColor.control);
		btn_sobre.setBounds(371, 11, 32, 32);
		contentPane.add(btn_sobre);
	}
}
