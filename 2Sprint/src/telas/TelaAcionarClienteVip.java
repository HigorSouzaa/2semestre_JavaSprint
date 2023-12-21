package telas;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.ClienteVIP;
import sistemas.ConexaoBancoDados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaAcionarClienteVip extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCpf;
	private JTextField txtNivelVip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAcionarClienteVip frame = new TelaAcionarClienteVip("Barão Lanches - Adicionar ClienteVip");
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
	public TelaAcionarClienteVip(String title) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNivelVip = new JTextField();
		txtNivelVip.setHorizontalAlignment(SwingConstants.CENTER);
		txtNivelVip.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNivelVip.setColumns(10);
		txtNivelVip.setBorder(null);
		txtNivelVip.setBounds(513, 411, 170, 20);
		contentPane.add(txtNivelVip);
		
		txtCpf = new JTextField();
		txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCpf.setColumns(10);
		txtCpf.setBorder(null);
		txtCpf.setBounds(217, 410, 170, 20);
		contentPane.add(txtCpf);
		
		JButton btAdicionarVip = new JButton("");
		btAdicionarVip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = txtCpf.getText();
                int nivelVIP = Integer.parseInt(txtNivelVip.getText());

                // Realizar a busca no banco de dados pelo CPF
                Connection conexao = ConexaoBancoDados.conectar();
                String consultaSql = "SELECT * FROM cliente WHERE CPF = ?";
                try (PreparedStatement stmt = conexao.prepareStatement(consultaSql)) {
                    stmt.setString(1, cpf);
                    ResultSet resultSet = stmt.executeQuery();

                    if (resultSet.next()) {
                        
                        String nome = resultSet.getString("Nome");
                        String datNasc = resultSet.getString("DataNascimento");
                        String telefone = resultSet.getString("Telefone");
                        String endereco = resultSet.getString("Endereco");
                        String email = resultSet.getString("Email");

                        ClienteVIP clienteVIP = new ClienteVIP(nome, datNasc, cpf, telefone, endereco, email, nivelVIP);
                        double desconto = clienteVIP.calcularDesconto(nivelVIP);

                        JOptionPane.showMessageDialog(null, "Cliente VIP criado:\n" + clienteVIP.mostrarDados() + "Desconto: " + desconto);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } finally {
                    ConexaoBancoDados.fechar(conexao);
                }
				
			}
		});
		btAdicionarVip.setIcon(new ImageIcon(TelaAcionarClienteVip.class.getResource("/arquivos/BotaoAdicionarClienteVip.png")));
		btAdicionarVip.setContentAreaFilled(false);
		btAdicionarVip.setBorderPainted(false);
		btAdicionarVip.setBounds(356, 511, 206, 60);
		contentPane.add(btAdicionarVip);
		
		JButton btVoltar = new JButton("");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministracao adm = new TelaAdministracao("Barao Lanches - Administração");
				adm.setVisible(true);
				setVisible(false);
			}
		});
		btVoltar.setIcon(new ImageIcon(TelaLoginAdministracao.class.getResource("/arquivos/BotaoVoltar.png")));
		btVoltar.setContentAreaFilled(false);
		btVoltar.setBorderPainted(false);
		btVoltar.setBounds(10, 11, 66, 55);
		contentPane.add(btVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaAcionarClienteVip.class.getResource("/arquivos/TelaAdicionarVip.png")));
		lblNewLabel.setBounds(0, 0, 881, 661);
		contentPane.add(lblNewLabel);
	}
}
