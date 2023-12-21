package telas;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistemas.ConexaoBancoDados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaCadastroFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDataNasc;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtHabilitacao;
	private JTextField txtCargo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionario frame = new TelaCadastroFuncionario("Barao Lanches - Cadastro Funcionarios");
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
	public TelaCadastroFuncionario(String title) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btCadastrarFuncionarios = new JButton("");
		btCadastrarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cargo = txtCargo.getText();
		        String nome = txtNome.getText();
		        String dataNascimento = txtDataNasc.getText();
		        String cpf = txtCpf.getText();
		        String email = txtEmail.getText();
		        String telefone = txtTelefone.getText();
		        String endereco = txtEndereco.getText();
		        String habilitacao = txtHabilitacao.getText();

		        if (cargo.isEmpty() || nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || dataNascimento.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios (Cargo, Nome, CPF, Data de Nascimento e Email).","Alert!!!",JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        Connection conexao = ConexaoBancoDados.conectar();
		        String insertFuncionario = "INSERT INTO Funcionarios (Nome, DataNascimento, CPF, Email, Telefone, Endereco, Habilitacao, Cargo) "
	                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

				try (PreparedStatement ps = conexao.prepareStatement(insertFuncionario)) {
		            ps.setString(1, nome);
		            ps.setString(2, dataNascimento);
		            ps.setString(3, cpf);
		            ps.setString(4, email);
		            ps.setString(5, telefone);
		            ps.setString(6, endereco);
		            ps.setString(7, habilitacao);
		            ps.setString(8, cargo);

		            int linhasAfetadas = ps.executeUpdate();

		            if (linhasAfetadas > 0) {
		                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		                txtNome.setText("");
		                txtDataNasc.setText("");
		                txtCpf.setText("");
		                txtEmail.setText("");
		                txtTelefone.setText("");
		                txtEndereco.setText("");
		                txtHabilitacao.setText("");
		                txtCargo.setText("");

		            } else {
		                JOptionPane.showMessageDialog(null, "Erro ao cadastrar Funcionario!!!.", "Erro", JOptionPane.ERROR_MESSAGE);
		            }

				} catch (SQLException ex) {
					ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionarios: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } finally {
                    ConexaoBancoDados.fechar(conexao);
                }



			}
		});
		btCadastrarFuncionarios.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/arquivos/BotaoCadastrarFuncionario.png")));
		btCadastrarFuncionarios.setContentAreaFilled(false);
		btCadastrarFuncionarios.setBorderPainted(false);
		btCadastrarFuncionarios.setBounds(556, 503, 206, 60);
		contentPane.add(btCadastrarFuncionarios);

		txtEndereco = new JTextField();
		txtEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		txtEndereco.setFont(new Font("Arial", Font.PLAIN, 15));
		txtEndereco.setColumns(10);
		txtEndereco.setBorder(null);
		txtEndereco.setBounds(577, 419, 170, 20);
		contentPane.add(txtEndereco);

		txtHabilitacao = new JTextField();
		txtHabilitacao.setHorizontalAlignment(SwingConstants.CENTER);
		txtHabilitacao.setFont(new Font("Arial", Font.PLAIN, 15));
		txtHabilitacao.setColumns(10);
		txtHabilitacao.setBorder(null);
		txtHabilitacao.setBounds(306, 523, 170, 20);
		contentPane.add(txtHabilitacao);

		txtTelefone = new JTextField();
		txtTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefone.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTelefone.setColumns(10);
		txtTelefone.setBorder(null);
		txtTelefone.setBounds(43, 419, 170, 20);
		contentPane.add(txtTelefone);

		txtCargo = new JTextField();
		txtCargo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCargo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCargo.setColumns(10);
		txtCargo.setBorder(null);
		txtCargo.setBounds(43, 523, 170, 20);
		contentPane.add(txtCargo);

		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBounds(306, 419, 170, 20);
		contentPane.add(txtEmail);

		txtNome = new JTextField();
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNome.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNome.setColumns(10);
		txtNome.setBorder(null);
		txtNome.setBounds(43, 322, 170, 20);
		contentPane.add(txtNome);

		txtCpf = new JTextField();
		txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCpf.setColumns(10);
		txtCpf.setBorder(null);
		txtCpf.setBounds(577, 322, 170, 20);
		contentPane.add(txtCpf);

		txtDataNasc = new JTextField();
		txtDataNasc.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataNasc.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDataNasc.setColumns(10);
		txtDataNasc.setBorder(null);
		txtDataNasc.setBounds(306, 322, 170, 20);
		contentPane.add(txtDataNasc);

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
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/arquivos/TelaCadastroFuncionario.png")));
		lblNewLabel.setBounds(0, 0, 881, 661);
		contentPane.add(lblNewLabel);
	}
}
