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

public class TelaAdministracao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministracao frame = new TelaAdministracao("Barao Lanches - Administração");
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
	public TelaAdministracao(String title) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
			
			JButton btCadastrarFuncionarios = new JButton("");
			btCadastrarFuncionarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaCadastroFuncionario funcionario = new TelaCadastroFuncionario("Barao Lanches - Cadastro funcionario");
					funcionario.setVisible(true);
					setVisible(false);
				}
			});
			btCadastrarFuncionarios.setIcon(new ImageIcon(TelaAdministracao.class.getResource("/arquivos/BotaoCadastrarFuncionario.png")));
			btCadastrarFuncionarios.setContentAreaFilled(false);
			btCadastrarFuncionarios.setBorderPainted(false);
			btCadastrarFuncionarios.setBounds(585, 480, 206, 60);
			contentPane.add(btCadastrarFuncionarios);
			
			JButton btCadastrarCardapio = new JButton("");
			btCadastrarCardapio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaCadastroCardapio cardapio = new TelaCadastroCardapio("Barao Lanches - Cadastro Cardapio");
					cardapio.setVisible(true);
					setVisible(false);
					
				}
			});
			btCadastrarCardapio.setIcon(new ImageIcon(TelaAdministracao.class.getResource("/arquivos/BotaoAdicionarCardapio.png")));
			btCadastrarCardapio.setContentAreaFilled(false);
			btCadastrarCardapio.setBorderPainted(false);
			btCadastrarCardapio.setBounds(585, 341, 206, 60);
			contentPane.add(btCadastrarCardapio);
			
			JButton btAdicionarClienteVip = new JButton("");
			btAdicionarClienteVip.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaAcionarClienteVip vip = new TelaAcionarClienteVip("Barão Lanches - Adicionar ClienteVip");
					vip.setVisible(true);
					setVisible(false);
				}
			});
			btAdicionarClienteVip.setIcon(new ImageIcon(TelaAdministracao.class.getResource("/arquivos/BotaoAdicionarClienteVip.png")));
			btAdicionarClienteVip.setContentAreaFilled(false);
			btAdicionarClienteVip.setBorderPainted(false);
			btAdicionarClienteVip.setBounds(585, 412, 206, 60);
			contentPane.add(btAdicionarClienteVip);
			
			
			
			
			JButton btFinalizarMesa = new JButton("");
			btFinalizarMesa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaFinalizarMesa mesa = new TelaFinalizarMesa("Barao Lanches - Finalizar Mesa");
					mesa.setVisible(true);
					setVisible(false);
				}
			});
			btFinalizarMesa.setIcon(new ImageIcon(TelaAdministracao.class.getResource("/arquivos/BotaoFinalizarMesa.png")));
			btFinalizarMesa.setContentAreaFilled(false);
			btFinalizarMesa.setBorderPainted(false);
			btFinalizarMesa.setBounds(89, 483, 206, 60);
			contentPane.add(btFinalizarMesa);
			
			JButton btCadastrarPedido = new JButton("");
			btCadastrarPedido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaCadastroPedido pedido = new TelaCadastroPedido("Barão Lanches - Cadastro Pedidos");
					pedido.setVisible(true);
					setVisible(false);
				}
			});
			btCadastrarPedido.setIcon(new ImageIcon(TelaAdministracao.class.getResource("/arquivos/BotaoCadastrarPedido.png")));
			btCadastrarPedido.setContentAreaFilled(false);
			btCadastrarPedido.setBorderPainted(false);
			btCadastrarPedido.setBounds(89, 412, 206, 60);
			contentPane.add(btCadastrarPedido);
		
			JButton btCadastrarCliente = new JButton("");
			btCadastrarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaCadastroClientes clietes = new TelaCadastroClientes("Barão Lanches - Cadastro clientes");
					clietes.setVisible(true);
					setVisible(false);
				}
			});
			btCadastrarCliente.setContentAreaFilled(false);
			btCadastrarCliente.setBorderPainted(false);
			btCadastrarCliente.setIcon(new ImageIcon(TelaAdministracao.class.getResource("/arquivos/BotaoCadastrarCliente.png")));
			btCadastrarCliente.setBounds(89, 341, 206, 60);
			contentPane.add(btCadastrarCliente);
			
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaAdministracao.class.getResource("/arquivos/TelaAdmistracao.png")));
		lblNewLabel.setBounds(0, 0, 881, 661);
		contentPane.add(lblNewLabel);
	}
 
}
