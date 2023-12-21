package telas;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class TelaFinalizarMesaFun extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMesa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFinalizarMesa frame = new TelaFinalizarMesa("Barao Lanches - Finalizar Mesa");
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
	public TelaFinalizarMesaFun(String title) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMesa = new JTextField();
		txtMesa.setHorizontalAlignment(SwingConstants.CENTER);
		txtMesa.setFont(new Font("Arial", Font.PLAIN, 15));
		txtMesa.setColumns(10);
		txtMesa.setBorder(null);
		txtMesa.setBounds(365, 383, 170, 20);
		contentPane.add(txtMesa);
		
		JButton btFinalizarMesa = new JButton("");
		btFinalizarMesa.setIcon(new ImageIcon(TelaFinalizarMesa.class.getResource("/arquivos/BotaoFinalizarMesa.png")));
		btFinalizarMesa.setContentAreaFilled(false);
		btFinalizarMesa.setBorderPainted(false);
		btFinalizarMesa.setBounds(345, 464, 206, 60);
		contentPane.add(btFinalizarMesa);
		
		JButton btVoltar = new JButton("");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionarios funcionarios = new TelaFuncionarios("Barao Lanches - Funcionarios");
				funcionarios.setVisible(true);
				setVisible(false);
			}
		});
		btVoltar.setIcon(new ImageIcon(TelaLoginAdministracao.class.getResource("/arquivos/BotaoVoltar.png")));
		btVoltar.setContentAreaFilled(false);
		btVoltar.setBorderPainted(false);
		btVoltar.setBounds(10, 11, 66, 55);
		contentPane.add(btVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaFinalizarMesa.class.getResource("/arquivos/TelaFinalizarMesa.png")));
		lblNewLabel.setBounds(0, 0, 881, 661);
		contentPane.add(lblNewLabel);
	}

}
