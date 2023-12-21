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
import javax.swing.JButton;

public class TelaFuncionarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionarios frame = new TelaFuncionarios("Barao Lanches - Login Funcionarios");
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
	public TelaFuncionarios(String title) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btFinalizarMesa = new JButton("");
		btFinalizarMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFinalizarMesaFun mesaFun = new TelaFinalizarMesaFun("Barao Lanches - Finalizar Mesa");
				mesaFun.setVisible(true);
				setVisible(false);
			}
		});
		btFinalizarMesa.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/arquivos/BotaoFinalizarMesa.png")));
		btFinalizarMesa.setContentAreaFilled(false);
		btFinalizarMesa.setBorderPainted(false);
		btFinalizarMesa.setBounds(133, 458, 206, 60);
		contentPane.add(btFinalizarMesa);
		
		JButton btCadastrarPedido = new JButton("");
		btCadastrarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPedidoFun pedidoFun = new TelaCadastroPedidoFun("Barao Lanches - Cadastro Pedido");
				pedidoFun.setVisible(true);
				setVisible(false);
			}
		});
		btCadastrarPedido.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/arquivos/BotaoCadastrarPedido.png")));
		btCadastrarPedido.setContentAreaFilled(false);
		btCadastrarPedido.setBorderPainted(false);
		btCadastrarPedido.setBounds(133, 387, 206, 60);
		contentPane.add(btCadastrarPedido);
		
		JButton btVoltar = new JButton("");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login("Barao Lanches - Login Adm");
				lg.setVisible(true);
				setVisible(false);
			}
		});
		btVoltar.setIcon(new ImageIcon(TelaLoginAdministracao.class.getResource("/arquivos/BotaoVoltar.png")));
		btVoltar.setContentAreaFilled(false);
		btVoltar.setBorderPainted(false);
		btVoltar.setBounds(10, 11, 66, 55);
		contentPane.add(btVoltar);
		
		JButton btCadastrarCliente = new JButton("");
		btCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroClientesFun clientesFun = new TelaCadastroClientesFun("Barao Lanches - Cadastrar Clientes");
				clientesFun.setVisible(true);
				setVisible(false);
			}
		});
		btCadastrarCliente.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/arquivos/BotaoCadastrarCliente.png")));
		btCadastrarCliente.setContentAreaFilled(false);
		btCadastrarCliente.setBorderPainted(false);
		btCadastrarCliente.setBounds(133, 316, 206, 60);
		contentPane.add(btCadastrarCliente);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/arquivos/TelaFuncionario.png")));
		lblNewLabel.setBounds(0, 0, 881, 661);
		contentPane.add(lblNewLabel);
	}
}
