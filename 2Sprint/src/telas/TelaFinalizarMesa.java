package telas;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Mesa;
import sistemas.ConexaoBancoDados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class TelaFinalizarMesa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean situacaoBotao = false;
	private List<Mesa> mesas = new ArrayList<Mesa>();
	
	
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
	public TelaFinalizarMesa(String title) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMesa = new JPanel();
		panelMesa.setBackground(Color.decode("#690303"));
		panelMesa.setBounds(424, 269, 392, 355);
		contentPane.add(panelMesa);
		panelMesa.setLayout(null);
		panelMesa.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 372, 235);
		panelMesa.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setFont(new Font("Arial", Font.PLAIN, 17));
		textArea.setBackground(Color.decode("#91413F"));
		scrollPane.setViewportView(textArea);
		
		JButton btFinalizarMesa = new JButton("");
		btFinalizarMesa.setBounds(95, 268, 206, 60);
		panelMesa.add(btFinalizarMesa);
		btFinalizarMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				panelMesa.setVisible(false);
			}
		});
		btFinalizarMesa.setIcon(new ImageIcon(TelaFinalizarMesa.class.getResource("/arquivos/BotaoFinalizarMesa.png")));
		btFinalizarMesa.setContentAreaFilled(false);
		btFinalizarMesa.setBorderPainted(false);
		
		JButton btVisualizarMesa = new JButton("");
		btVisualizarMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int getMesa = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o numero da mesa que deseja ver???", "Barao Lanches", JOptionPane.PLAIN_MESSAGE));
					panelMesa.setVisible(true);
					Connection conexao = ConexaoBancoDados.conectar();
					String selectMesa = "SELECT NumeroCardapio, Quantidade, ValorTotal FROM mesa WHERE NumMesa = ?";
					double valorTotalMesa = 0;
					
					try (PreparedStatement ps = conexao.prepareStatement(selectMesa)) {
						ps.setInt(1, getMesa);
						
						ResultSet rs = ps.executeQuery();
						
						while (rs.next()) {
							Mesa conta = new Mesa(
									rs.getInt("NumeroCardapio"),
									rs.getInt("Quantidade"),
									rs.getDouble("ValorTotal"));
							
							valorTotalMesa += rs.getDouble("ValorTotal");
							mesas.add(conta);
						}
						
						
						if (mesas.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Nenhuma Mesa cadastrada", "Alert!!!", JOptionPane.WARNING_MESSAGE);
						} else {
							textArea.setText("Numero \tQuantidade \tValor Total\n");
							for (Mesa mesa : mesas) {
								textArea.append(mesa.mostrarDados());
							}
							textArea.append("\nValor Final da Mesa: R$" + valorTotalMesa);
							
						}
						
						
					} catch (SQLException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					} finally {
						ConexaoBancoDados.fechar(conexao);
					}
					
					
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Informe um numero de mesa valido", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btVisualizarMesa.setIcon(new ImageIcon(TelaFinalizarMesa.class.getResource("/arquivos/BotaoVisualizarMesa.png")));
		btVisualizarMesa.setContentAreaFilled(false);
		btVisualizarMesa.setBorderPainted(false);
		btVisualizarMesa.setBounds(101, 359, 206, 60);
		contentPane.add(btVisualizarMesa);
		
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
		lblNewLabel.setIcon(new ImageIcon(TelaFinalizarMesa.class.getResource("/arquivos/TelaFinalizarMesa.png")));
		lblNewLabel.setBounds(0, 0, 881, 661);
		contentPane.add(lblNewLabel);
	}
}
