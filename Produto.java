package Model;

public class Produto {
	
private String produto;
private double preco;
	public Produto(String produto, double preco) {
			this.produto = produto;
			this.preco = preco;
	}
// Getters e Setters
	public String getProduto() {
		return produto;
	}
	public String setProduto(String produto) {
		return this.produto;
	}
	
	public double getPreco() {
		return preco;
	}
	public double setPreco(double preco) {
		return this.preco;
	}
}