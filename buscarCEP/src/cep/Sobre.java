package cep;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sobre extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setModal(true);
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/house.png")));
		setBounds(150, 150, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar CEP - Versão 1.0");
		lblNewLabel.setBounds(25, 30, 134, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("@Author Clizan Willian");
		lblNewLabel_1.setBounds(25, 68, 210, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Webservice:");
		lblNewLabel_2.setBounds(25, 110, 69, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lbl_webservice = new JLabel("https://github.com/Clizan/buscarCEP");
		lbl_webservice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*Chamando o método link */
				link("https://github.com/Clizan/buscarCEP");
				
			}
		});
		lbl_webservice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_webservice.setForeground(SystemColor.textHighlight);
		lbl_webservice.setBounds(92, 110, 286, 14);
		getContentPane().add(lbl_webservice);
		
		JButton btn_git_hub = new JButton("");
		btn_git_hub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_git_hub.setIcon(new ImageIcon(Sobre.class.getResource("/img/github-logo.png")));
		btn_git_hub.setBounds(25, 161, 31, 31);
		getContentPane().add(btn_git_hub);

	} // Fim do construtor
	
	/* Criando método para abrir o site externo*/
	private void link(String site) {
	
		/* Criando o objeto desktop que recebe a interface gráfica padrão do usuário */
		Desktop desktop = Desktop.getDesktop();
		
		try {
			
			/* Criando o objeto URI*/
			URI uri = new URI(site);
			desktop.browse(uri);
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
	} 
	
}
