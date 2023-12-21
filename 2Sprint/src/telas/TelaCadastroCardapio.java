package telas;

import sistemas.ConexaoBancoDados;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TelaCadastroCardapio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumCardapio;
	private JTextField txtNomePedido;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCardapio frame = new TelaCadastroCardapio("Barao Lanches - Cadastro Cardapio");
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
	public TelaCadastroCardapio(String title) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton btAdicionarCardapio = new JButton("");
		btAdicionarCardapio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 if (txtNomePedido.getText().isEmpty() || txtNumCardapio.getText().isEmpty() || txtValor.getText().isEmpty()) {
				        JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Alerta", JOptionPane.WARNING_MESSAGE);
				    } else {
				        try {
				            int numPedido = Integer.parseInt(txtNumCardapio.getText());
				            double valor = Double.parseDouble(txtValor.getText());
				            String nomePedido = txtNomePedido.getText();

				            Connection conexao = ConexaoBancoDados.conectar();
				            String insertCardapio = "INSERT INTO cardapio (NumeroCardapio, NomeDoPedido, Valor) VALUES (?,?,?)";

				            try (PreparedStatement ps = conexao.prepareStatement(insertCardapio)) {
				                ps.setInt(1, numPedido);
				                ps.setString(2, nomePedido);
				                ps.setDouble(3, valor);
				                int linhasAfetadas = ps.executeUpdate();

				                if (linhasAfetadas > 0) {
				                    System.out.println("Dados inseridos com sucesso!");
					                JOptionPane.showMessageDialog(null, "Cardápio cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					                txtNomePedido.setText("");
					                txtNumCardapio.setText("");
					                txtValor.setText("");
				                } else {
				                    System.out.println("Falha ao inserir dados.");
					                JOptionPane.showMessageDialog(null, "Erro ao cadastrar o cardarpio!", "Erro", JOptionPane.ERROR_MESSAGE);

				                }

				            } catch (SQLException ex) {
				                ex.printStackTrace();
				                JOptionPane.showMessageDialog(null, "Erro ao cadastrar cardápio: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				            } finally {
				                ConexaoBancoDados.fechar(conexao);
				            }
				        } catch (NumberFormatException e1) {
				            e1.printStackTrace();
				            JOptionPane.showMessageDialog(null, "Revise se o número do cardápio e o valor são números válidos!", "Alerta", JOptionPane.WARNING_MESSAGE);
				        }
				    }
				
			}
		});
		btAdicionarCardapio.setIcon(new ImageIcon(TelaCadastroCardapio.class.getResource("/arquivos/BotaoAdicionarCardapio.png")));
		btAdicionarCardapio.setContentAreaFilled(false);
		btAdicionarCardapio.setBorderPainted(false);
		btAdicionarCardapio.setBounds(350, 526, 206, 60);
		contentPane.add(btAdicionarCardapio);

		
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
		
		
		txtNomePedido = new JTextField();
		txtNomePedido.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomePedido.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNomePedido.setColumns(10);
		txtNomePedido.setBorder(null);
		txtNomePedido.setBounds(366, 384, 170, 20);
		contentPane.add(txtNomePedido);


		txtValor = new JTextField();
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setFont(new Font("Arial", Font.PLAIN, 15));
		txtValor.setColumns(10);
		txtValor.setBorder(null);
		txtValor.setBounds(658, 384, 170, 20);
		contentPane.add(txtValor);


		txtNumCardapio = new JTextField();
		txtNumCardapio.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumCardapio.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNumCardapio.setColumns(10);
		txtNumCardapio.setBorder(null);
		txtNumCardapio.setBounds(70, 383, 170, 20);
		contentPane.add(txtNumCardapio);


		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroCardapio.class.getResource("/arquivos/TelaCadastroCardapio.png")));
		lblNewLabel.setBounds(0, 0, 881, 661);
		contentPane.add(lblNewLabel);



	}
}
