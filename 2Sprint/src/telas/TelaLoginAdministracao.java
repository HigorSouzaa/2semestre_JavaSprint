package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.SuperUser;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class TelaLoginAdministracao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private SuperUser adm = new SuperUser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoginAdministracao frame = new TelaLoginAdministracao("Barao Lanches - Login Administração");
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
	public TelaLoginAdministracao (String title) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btVoltar = new JButton("");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login("Barao Lanches - Login Adm");
				lg.setVisible(true);
				setVisible(false);
			}
		});
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 23));
		txtSenha.setBorder(null);
		txtSenha.setBounds(115, 529, 294, 31);
		contentPane.add(txtSenha);
		
		btVoltar.setIcon(new ImageIcon(TelaLoginAdministracao.class.getResource("/arquivos/BotaoVoltar.png")));
		btVoltar.setContentAreaFilled(false);
		btVoltar.setBorderPainted(false);
		btVoltar.setBounds(10, 11, 66, 55);
		contentPane.add(btVoltar);
		
//		JButton btLogar = new JButton("");
//		btLogar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (!txtUsuario.getText().isEmpty() && !txtSenha.getText().isEmpty()) {
//					if (txtUsuario.getText().equals(adm.getUser()) && adm.getPassword().equals(String.valueOf(txtSenha.getText()))) {
//						TelaAdministracao admin = new TelaAdministracao("Barao Lanches - Admisnistracao");
//						admin.setVisible(true);
//						setVisible(false);
//					} else {
//                        txtUsuario.setText("");
//                        txtSenha.setText("");
//
//                        JOptionPane.showMessageDialog(null, "Cadastro invalido!!!", "Barao Lanches",JOptionPane.ERROR_MESSAGE);
//                    }
//				} else {
//                    JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos!!!", "Barao Lanches",JOptionPane.INFORMATION_MESSAGE);
//                }
//			}
//		});
		
		JButton btLogar = new JButton("");
		btLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministracao adm = new TelaAdministracao("Barao Lanches - Admisnistracao");
				adm.setVisible(true);
				setVisible(false);
			}
		});
		btLogar.setContentAreaFilled(false);
		btLogar.setBorderPainted(false);
		btLogar.setIcon(new ImageIcon(Login.class.getResource("/arquivos/BotaoLogar.png")));
		btLogar.setBounds(529, 514, 66, 60);
		contentPane.add(btLogar);
		
		txtUsuario = new JTextField();
		txtUsuario.setBorder(null);
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 23));
		txtUsuario.setBounds(115, 314, 294, 31);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(TelaLoginAdministracao.class.getResource("/arquivos/TelaLoginAdminstracao.png")));
		lblNewLabel.setBounds(0, 0, 884, 661);
		contentPane.add(lblNewLabel);
	}
}
