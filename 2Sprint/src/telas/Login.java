package telas;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.EventQueue;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login("Barao Lanches - Login");
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
	public Login(String title) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btAdministracao = new JButton("");
		btAdministracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoginAdministracao lgAdm = new TelaLoginAdministracao("Barao Lanches - Login Adm");
				lgAdm.setVisible(true);
				setVisible(false);
			}
		});
		btAdministracao.setBorderPainted(false);
		btAdministracao.setIcon(new ImageIcon(Login.class.getResource("/arquivos/BotaoAdm.png")));
		btAdministracao.setContentAreaFilled(false);
		btAdministracao.setBounds(156, 431, 209, 60);
		contentPane.add(btAdministracao);

		
		JButton btFuncionarios = new JButton("");
		btFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoginFuncionarios lgFuncionarios = new TelaLoginFuncionarios("Barao Lanches - Funcionarios");
				lgFuncionarios.setVisible(true);
				setVisible(false);
			}
		});
		btFuncionarios.setContentAreaFilled(false);
		btFuncionarios.setIcon(new ImageIcon(Login.class.getResource("/arquivos/BotaoFuncionarios.png")));
		btFuncionarios.setBorderPainted(false);
		btFuncionarios.setBounds(156, 321, 211, 60);
		contentPane.add(btFuncionarios);


		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/arquivos/TelaLogin.png")));
		lblNewLabel.setBounds(0, 0, 900, 661);
		contentPane.add(lblNewLabel);
	}
}
