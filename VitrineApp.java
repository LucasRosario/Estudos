package View;
import Controler.Carrinho;
import Model.Produto;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VitrineApp extends Application {
	private AnchorPane pane;
	private TextField txPesquisa;
	private TableView<ItensProperty> tbVitrine;
	private TableColumn<ItensProperty, String> columnProduto;
	private TableColumn<ItensProperty, Double> columnPreco;
	private static ObservableList<ItensProperty> listItens = FXCollections.observableArrayList();
	private static Carrinho carrinho;
	private static Stage stage;

	
	@Override
	public void start(Stage arg0) throws Exception {
		initComponents();
		Scene scene = new Scene(pane);		//INSTANCIA A SENA
		arg0.setScene(scene);				// SETA 	SENA NO PALCO
		arg0.setResizable(false);			//REMOVE A OP DE MAX A TELA
		arg0.setTitle("Login - GolFX");	//TITULO
		arg0.show();						// MOSTRA O PALCO 
		VitrineApp.stage = arg0;	
	}
	
	public static void main(String[] args) {	
		launch(args);

	}
	
	private void initComponents() {
		pane = new AnchorPane();	//Painel
		pane.setPrefSize(800, 600);
		txPesquisa = new TextField();	//texto pesquisa
		txPesquisa.setPromptText("Digite o item para pesquisa");
		tbVitrine = new TableView<ItensProperty>();
		tbVitrine.setPrefSize(780, 550);
		columnProduto = new TableColumn<ItensProperty, String>();
		columnPreco = new TableColumn<ItensProperty, Double>();
		tbVitrine.getColumns().addAll(columnProduto, columnPreco);
		pane.getChildren().addAll(txPesquisa, tbVitrine);
		carrinho = new Carrinho();
		columnProduto.setCellValueFactory(new PropertyValueFactory<ItensProperty, String>("produto"));
		columnPreco.setCellValueFactory(new PropertyValueFactory<ItensProperty, Double>("preco"));
		tbVitrine.setItems(listItens);
	}

	private void initItens(){
		Vitrine v = new Vitrine();
		v.addProdutos(new Produto("Bola Topper", 15.00), new Produto(
		"Luvas Umbro", 9.00), new Produto("Camisa Esportiva", 40.00),
		new Produto("Chuteira Nike Mercurial", 199.00), new Produto("Caneleira Topper", 10.00));
		for (Produto p : v.getProdutos())
			listItens.add(new ItensProperty(p.getProduto(), p.getPreco()));
				
	}
	public class ItensProperty {
		private SimpleStringProperty produto;
		private SimpleDoubleProperty preco;
		public ItensProperty(String produto, double preco) {
		this.produto = new SimpleStringProperty(produto);
		this.preco = new SimpleDoubleProperty(preco);
		}
		
		public String getProduto() {
			return produto.get();
			}
			public void setProduto(String produto) {
			this.produto.set(produto);
			}
			public double getPreco() {
			return preco.get();
			}
			public void setPreco(double preco) {
			this.preco.set(preco);
			}
		
	}
		
}


