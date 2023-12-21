package telas;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroPedidoFun extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumPedido;
	private JTextField txtQuant;
	private JTextField txtNumMesa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPedido frame = new TelaCadastroPedido("Barão Lanches - Cadastro Pedidos");
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
	public TelaCadastroPedidoFun(String title) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtQuant = new JTextField();
		txtQuant.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuant.setFont(new Font("Arial", Font.PLAIN, 15));
		txtQuant.setColumns(10);
		txtQuant.setBorder(null);
		txtQuant.setBounds(357, 365, 170, 20);
		contentPane.add(txtQuant);
		
		txtNumMesa = new JTextField();
		txtNumMesa.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumMesa.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNumMesa.setColumns(10);
		txtNumMesa.setBorder(null);
		txtNumMesa.setBounds(64, 365, 170, 20);
		contentPane.add(txtNumMesa);
		
		JButton btFazerPedido = new JButton("");
		btFazerPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btFazerPedido.setIcon(new ImageIcon(TelaCadastroPedido.class.getResource("/arquivos/BotaoFazerPedido.png")));
		btFazerPedido.setContentAreaFilled(false);
		btFazerPedido.setBorderPainted(false);
		btFazerPedido.setBounds(335, 490, 206, 60);
		contentPane.add(btFazerPedido);
		
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
		
		txtNumPedido = new JTextField();
		txtNumPedido.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumPedido.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNumPedido.setColumns(10);
		txtNumPedido.setBorder(null);
		txtNumPedido.setBounds(594, 364, 170, 20);
		contentPane.add(txtNumPedido);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroPedido.class.getResource("/arquivos/TelaCadastroPedidos.png")));
		lblNewLabel.setBounds(0, 0, 881, 661);
		contentPane.add(lblNewLabel);
	}
}
