import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginApp extends Application{
	
	private AnchorPane pane;
	private TextField txLogin;
	private PasswordField txSenha;
	private Button btEntrar, btSair;
	private static Stage stage;


@Override
public void start(Stage stage) throws Exception{
	initComponents();
	initListeners();
	Scene scene = new Scene(pane);		//INSTANCIA A SENA
	stage.setScene(scene);				// SETA 	SENA NO PALCO
	stage.setResizable(false);			//REMOVE A OP DE MAX A TELA
	stage.setTitle("Login - GolFX");	//TITULO
	stage.show();						// MOSTRA O PALCO 
	initLayout();
	LoginApp.stage = stage;	
}

public static Stage getStage() {
	return stage;
}

private void initComponents() {
	pane = new AnchorPane(); // INSTANCIA PAINEL 
	pane.setPrefSize(400, 300);			// SETA PAINEL
	txLogin = new TextField();
	txLogin.setPromptText("Digite aqui seu login");
	txSenha = new PasswordField();
	txSenha.setPromptText("Digite aqui sua senha");
	btEntrar = new Button("Entrar");
	btSair = new Button("Sair");
	pane.getChildren().addAll(txLogin, txSenha, btEntrar, btSair); // FILHOS DO PAINEL
}


private void initLayout() {
	txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
	txLogin.setLayoutY(50);
	txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth()) / 2);
	txSenha.setLayoutY(100);
	btEntrar.setLayoutX((pane.getWidth() - btEntrar.getWidth()) / 2);
	btEntrar.setLayoutY(150);
	btSair.setLayoutX((pane.getWidth() - btSair.getWidth()) / 2);
	btSair.setLayoutY(200);
}

private void initListeners() {
	btSair.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			fecharAplicacao();
		}
	});
	
	btEntrar.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			logar();
		}
	});
}

private void logar(){
	if (txLogin.getText().equals("admin") && txSenha.getText().equals("admin")) {
			// TODO Abrir a tela VitrineApp
	} else {
		JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
	}

}

private void fecharAplicacao(){
System.exit(0);
}


public static void main(String[] args) {
launch(args);
}

}