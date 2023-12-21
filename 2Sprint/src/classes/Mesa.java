package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import sistemas.ConexaoBancoDados;

public class Mesa {
	private int numMesa;
	private int numCardapio;
	private int quantidade;
	private double valorTotal;
	private String nomeCardapio;
	
	
	public Mesa(int numMesa, int numCardapio, int quantidade, double valorTotal) {
		super();
		this.numMesa = numMesa;
		this.numCardapio = numCardapio;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
	}
	
	public Mesa(int numCardapio, int quantidade, double valorTotal) {
		super();
		this.numCardapio = numCardapio;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
	}



	public String mostrarDados() {
		return this.numCardapio + "\t" + this.quantidade + "\tR$" + this.valorTotal + "\n";
	}

	
	
	



	public double getValorTotal() {
		return 0;
	}



}
