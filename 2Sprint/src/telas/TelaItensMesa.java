package telas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import sistemas.ConexaoBancoDados;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaItensMesa extends JFrame {

    private JPanel contentPane;
    private JTextArea textArea;
    private int numMesa;

    public TelaItensMesa(int numMesa) {
        this.numMesa = numMesa;
        setTitle("Itens da Mesa " + numMesa);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setEditable(false); // Para evitar que o usuário edite o texto

        // Carregar e exibir os itens da mesa
        exibirItensMesa();
    }

    public void exibirItensMesa() {
        textArea.setText(""); // Limpa o conteúdo anterior, se houver

        Connection conexao = ConexaoBancoDados.conectar();
        String query = "SELECT NumeroCardapio, Quantidade, ValorTotal FROM mesa WHERE NumMesa = ?";

        try (PreparedStatement ps = conexao.prepareStatement(query)) {
            ps.setInt(1, numMesa);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int numCardapio = rs.getInt("NumeroCardapio");
                int quantidade = rs.getInt("Quantidade");
                double valorPedido = rs.getDouble("ValorTotal");

                // Adicione as informações do pedido ao JTextArea
                textArea.append("Item do Cardápio: " + numCardapio + ", Quantidade: " + quantidade + ", Valor Total: " + valorPedido + "\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao exibir itens da mesa!", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBancoDados.fechar(conexao);
        }
    }
    
    public static void main(String[] args) {
		TelaItensMesa itensMesa = new TelaItensMesa(1);
	}
}
