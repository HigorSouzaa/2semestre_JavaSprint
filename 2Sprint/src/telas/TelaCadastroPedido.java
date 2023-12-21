package telas;

import java.awt.EventQueue;
import java.awt.HeadlessException;

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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaCadastroPedido extends JFrame {

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
	public TelaCadastroPedido(String title) throws HeadlessException {
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
				if (txtNumMesa.getText().isEmpty() || txtNumPedido.getText().isEmpty() || txtQuant.getText().isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Alerta", JOptionPane.WARNING_MESSAGE);
			    } else {
			        try {
			            int numMesa = Integer.parseInt(txtNumMesa.getText());
			            int numCardapio = Integer.parseInt(txtNumPedido.getText());
			            int quantidade = Integer.parseInt(txtQuant.getText());

			            Connection conexao = ConexaoBancoDados.conectar();

			            // Consulta SQL para buscar o valor do item do cardápio
			            String pesquisaValorCardapio = "SELECT Valor FROM cardapio WHERE NumeroCardapio = ?";
			            try (PreparedStatement ps = conexao.prepareStatement(pesquisaValorCardapio)) {
			                ps.setInt(1, numCardapio);
			                ResultSet rs = ps.executeQuery();

			                if (rs.next()) {
			                    double valorItem = rs.getDouble("Valor");
			                    double valorTotal = valorItem * quantidade;

			                    String insertPedido = "INSERT INTO mesa (NumeroCardapio, Quantidade, NumMesa, ValorTotal) VALUES (?,?,?,?)";
			                    try (PreparedStatement psInsert = conexao.prepareStatement(insertPedido)) {
			                        psInsert.setInt(1, numCardapio);
			                        psInsert.setInt(2, quantidade);
			                        psInsert.setInt(3, numMesa);
			                        psInsert.setDouble(4, valorTotal);
			                        int linhasAfetadas = psInsert.executeUpdate();

			                        if (linhasAfetadas > 0) {
			                            System.out.println("Dados inseridos com sucesso!");
			                            JOptionPane.showMessageDialog(null, "Pedido feito com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			                            txtNumMesa.setText("");
			                            txtNumPedido.setText("");
			                            txtQuant.setText("");
			                        } else {
			                            System.out.println("Falha ao inserir dados.");
			                            JOptionPane.showMessageDialog(null, "Erro ao Fazer Pedido!", "Erro", JOptionPane.ERROR_MESSAGE);
			                        }
			                    }
			                } else {
			                    JOptionPane.showMessageDialog(null, "Número de cardápio não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
			                }
			            } catch (SQLException ex) {
			                ex.printStackTrace();
			                JOptionPane.showMessageDialog(null, "" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			            } finally {
			                ConexaoBancoDados.fechar(conexao);
			            }
			        } catch (NumberFormatException e2) {
			            e2.printStackTrace();
			            txtNumMesa.setText("");
			            txtNumPedido.setText("");
			            txtQuant.setText("");
			            JOptionPane.showMessageDialog(null, "Revise se está informando valores válidos (números)!", "Alerta", JOptionPane.WARNING_MESSAGE);
			        }
			    }
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
