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

import classes.Cliente;
import sistemas.ConexaoBancoDados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class TelaCadastroClientesFun extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDataNasc;
	private JTextField txtEndereco;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JButton btPesquisarCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroClientes frame = new TelaCadastroClientes("Barao Lanches - Cadastro clientes");
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
	public TelaCadastroClientesFun(String title) throws HeadlessException {
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
				TelaFuncionarios funcionarios = new TelaFuncionarios("Barao Lanches - Funcionarios");
				funcionarios.setVisible(true);
				setVisible(false);
			}
		});
		
		
		btPesquisarCliente = new JButton("");
		btPesquisarCliente.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String cpf = JOptionPane.showInputDialog("Informe o CPF para pesquisar cliente");
		        
		        
		        Connection conexao = ConexaoBancoDados.conectar();
                String consultaSql = "SELECT * FROM cliente WHERE cpf = ?";
                try (PreparedStatement ps = conexao.prepareStatement(consultaSql)) {
                    ps.setString(1, cpf);
                    ResultSet resultSet = ps.executeQuery();
                    
                    if (resultSet.next()) {
                        // Cliente encontrado, criar um objeto cliente
                        String nome = resultSet.getString("nome");
                        String datNasc = resultSet.getString("dataNascimento");
                        String telefone = resultSet.getString("telefone");
                        String endereco = resultSet.getString("endereco");
                        String email = resultSet.getString("email");

                        //Criando objeto de cliente com os valores do banco para exibir a baixo
                        Cliente cliente = new Cliente(nome, datNasc, cpf, telefone, endereco, email);
                        JOptionPane.showMessageDialog(null, cliente.mostrarDados());
                    
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

		btPesquisarCliente.setIcon(new ImageIcon(TelaCadastroClientes.class.getResource("/arquivos/BotaoPesquisarCliente.png")));
		btPesquisarCliente.setContentAreaFilled(false);
		btPesquisarCliente.setBorderPainted(false);
		btPesquisarCliente.setBounds(480, 590, 206, 60);
		contentPane.add(btPesquisarCliente);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCpf.setColumns(10);
		txtCpf.setBorder(null);
		txtCpf.setBounds(142, 411, 170, 20);
		contentPane.add(txtCpf);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBounds(491, 519, 170, 20);
		contentPane.add(txtEmail);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTelefone.setColumns(10);
		txtTelefone.setBorder(null);
		txtTelefone.setBounds(142, 519, 170, 20);
		contentPane.add(txtTelefone);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Arial", Font.PLAIN, 15));
		txtEndereco.setColumns(10);
		txtEndereco.setBorder(null);
		txtEndereco.setBounds(491, 411, 170, 20);
		contentPane.add(txtEndereco);
		
		txtDataNasc = new JTextField();
		txtDataNasc.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDataNasc.setColumns(10);
		txtDataNasc.setBorder(null);
		txtDataNasc.setBounds(491, 303, 170, 20);
		contentPane.add(txtDataNasc);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNome.setBorder(null);
		txtNome.setBounds(142, 303, 170, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btCadastrar = new JButton("");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = txtCpf.getText();
				String nome = txtNome.getText();
				String dataNasc = txtDataNasc.getText();
				String telefone = txtTelefone.getText();
				String endereco = txtEndereco.getText();
				String email = txtEmail.getText();
				
				
				// Verificar campos vazios
                if (nome.isEmpty() || cpf.isEmpty() || dataNasc.isEmpty() || telefone.isEmpty() || endereco.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Alert!!!", JOptionPane.WARNING_MESSAGE);
                } else {

                	Connection conexao = ConexaoBancoDados.conectar();
                	String insertCliente = "INSERT INTO cliente (cpf, nome, dataNascimento, telefone, endereco, email) VALUES (?, ?, ?, ?, ?, ?)";
                	try (PreparedStatement ps = conexao.prepareStatement(insertCliente)) {
                		ps.setString(1, cpf);
                		ps.setString(2, nome);
                		ps.setString(3, dataNasc);
                		ps.setString(4, telefone);
                		ps.setString(5, endereco);
                		ps.setString(6, email);
                		
                		int linhasAfetadas = ps.executeUpdate();
    		            
    		            if (linhasAfetadas > 0) {
    	                	JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
    		                txtNome.setText("");
    		                txtDataNasc.setText("");
    		                txtCpf.setText("");
    		                txtEmail.setText("");
    		                txtTelefone.setText("");
    		                txtEndereco.setText("");
    		              
    		                
    		            } else {
    		                JOptionPane.showMessageDialog(null, "Erro ao cadastrar Cliente!!!.", "Erro", JOptionPane.ERROR_MESSAGE);
    		            }

					} catch (SQLException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					} finally {
						ConexaoBancoDados.fechar(conexao);
					}
                               
                }
			}
		});
		btCadastrar.setIcon(new ImageIcon(TelaCadastroClientes.class.getResource("/arquivos/BotaoCadastrar.png")));
		btCadastrar.setContentAreaFilled(false);
		btCadastrar.setBorderPainted(false);
		btCadastrar.setBounds(128, 590, 206, 60);
		contentPane.add(btCadastrar);
		btVoltar.setIcon(new ImageIcon(TelaLoginAdministracao.class.getResource("/arquivos/BotaoVoltar.png")));
		btVoltar.setContentAreaFilled(false);
		btVoltar.setBorderPainted(false);
		btVoltar.setBounds(10, 11, 66, 55);
		contentPane.add(btVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroClientes.class.getResource("/arquivos/TelaCadastroCliente.png")));
		lblNewLabel.setBounds(0, 0, 881, 661);
		contentPane.add(lblNewLabel);
	}
}
