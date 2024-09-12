package cep;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.ImageIcon;

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
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/house.png")));
		setBounds(100, 100, 450, 300);
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
		
		JLabel lbl_acessoGitHub = new JLabel("https://github.com/Clizan/buscarCEP");
		lbl_acessoGitHub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_acessoGitHub.setForeground(SystemColor.textHighlight);
		lbl_acessoGitHub.setBounds(92, 110, 200, 14);
		getContentPane().add(lbl_acessoGitHub);
		
		JButton btn_git_hub = new JButton("");
		btn_git_hub.setIcon(new ImageIcon(Sobre.class.getResource("/img/github-logo.png")));
		btn_git_hub.setBounds(25, 161, 31, 31);
		getContentPane().add(btn_git_hub);

	}
}
