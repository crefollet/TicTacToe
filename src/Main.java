import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;

public class Main extends Application implements EventHandler<ActionEvent> {

	int turn = 0;
	char[][] game = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
	Button button_00 = new Button(" ");
	Button button_01 = new Button(" ");
	Button button_02 = new Button(" ");
	Button button_10 = new Button(" ");
	Button button_11 = new Button(" ");
	Button button_12 = new Button(" ");
	Button button_20 = new Button(" ");
	Button button_21 = new Button(" ");
	Button button_22 = new Button(" ");
	Button newGame = new Button("New Game");
	BorderPane border = new BorderPane();
	VBox top_VBox = new VBox();
	HBox top_VBox_HBox = new HBox();
	Label top = new Label("To start: X places a tile, followed by O.\nTo win: Place 3 of the same tiles in a row,\ncolumn, or diagonal.");
	Label bottom = new Label("Player 1's turn!");
	GridPane gridpane = new GridPane();
	Scene scene = new Scene(border);
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void handle(ActionEvent event) {
		
		if (((Button) event.getSource()).getText() == "X" || ((Button) event.getSource()).getText() == "O") {
			bottom.setText("Tile is already occupied! Try another tile!");
		}
		else {
			if(turn == 0) {
				((Button) event.getSource()).setText("X");
				((Button) event.getSource()).setStyle("-fx-background-color: LightCoral");
				game[gridpane.getColumnIndex((Button) event.getSource())][gridpane.getRowIndex((Button) event.getSource())] = 'X';
				bottom.setText("Player 2's turn!");
			}
				
			else if(turn == 1) {
				((Button) event.getSource()).setText("O");
				((Button) event.getSource()).setStyle("-fx-background-color: MediumTurquoise");
				game[gridpane.getColumnIndex((Button) event.getSource())][gridpane.getRowIndex((Button) event.getSource())] = 'O';
				bottom.setText("Player 1's turn!");
			}
			if(checkWin()) {
				
				bottom.setText("PLAYER " + ++turn + " IS THE WINNER!");
				
				bottom.setStyle("-fx-font-weight: bold");
				bottom.setStyle("-fx-font-size: 28px");
				
				button_00.setDisable(true);
				button_01.setDisable(true);
				button_02.setDisable(true);
				button_10.setDisable(true);
				button_11.setDisable(true);
				button_12.setDisable(true);
				button_20.setDisable(true);
				button_21.setDisable(true);
				button_22.setDisable(true);
			}
			if (turn == 0) ++turn;
			else --turn;
		}	
		
	}
	
	public boolean checkWin() {
		//OOO
		//---
		//---
		if(game[0][0] == game[0][1] && game[0][0] == game[0][2])
			return true;
		//---
		//OOO
		//--- 
		if(game[1][0] == game[1][1] && game[1][0] == game[1][2])
			return true;
		//---
		//---
		//OOO
		if(game[2][0] == game[2][1] && game[2][0] == game[2][2])
			return true;
		//O--
		//O--
		//O--
		if(game[0][0] == game[1][0] && game[0][0] == game[2][0])
			return true;
		//-O-
		//-O-	
		//-O-
		if(game[0][1] == game[1][1] && game[0][1] == game[2][1])
			return true;
		//--O
		//--O
		//--O
		if(game[0][2] == game[1][2] && game[0][2] == game[2][2])
			return true;
		//O--
		//-O-
		//--O
		if(game[0][0] == game[1][1] && game[0][0] == game[2][2])
			return true;
		//--O
		//-O-
		//O--
		if(game[0][2] == game[1][1] && game[0][2] == game[2][0])
			return true;
		
		return false;
	}
	
	@Override
	public void start(Stage window) throws Exception {
		window.setTitle("Tic Tac Toe");
		
		top_VBox_HBox.setMargin(top, new Insets(10,10,10,10));
		top_VBox_HBox.setMargin(newGame, new Insets(10,10,10,10));
		top_VBox.setMargin(bottom, new Insets(10,10,10,10));
		top_VBox_HBox.getChildren().addAll(top, newGame);
		top_VBox.getChildren().addAll(top_VBox_HBox, bottom);
	
		border.setTop(top_VBox);
		border.setCenter(gridpane);
		gridpane.setPadding(new Insets(10, 50, 50, 50));
		
		button_00.setMinWidth(100);
		button_00.setMinHeight(100);
		button_00.setMaxWidth(100);
		button_00.setMaxHeight(100);
	
		button_01.setMinWidth(100);
		button_01.setMinHeight(100);
		button_01.setMaxWidth(100);
		button_01.setMaxHeight(100);
		
		button_02.setMinWidth(100);
		button_02.setMinHeight(100);
		button_02.setMaxWidth(100);
		button_02.setMaxHeight(100);

		button_10.setMinWidth(100);
		button_10.setMinHeight(100);
		button_10.setMaxWidth(100);
		button_10.setMaxHeight(100);

		button_11.setMinWidth(100);
		button_11.setMinHeight(100);
		button_11.setMaxWidth(100);
		button_11.setMaxHeight(100);

		button_12.setMinWidth(100);
		button_12.setMinHeight(100);
		button_12.setMaxWidth(100);
		button_12.setMaxHeight(100);

		button_20.setMinWidth(100);
		button_20.setMinHeight(100);
		button_20.setMaxWidth(100);
		button_20.setMaxHeight(100);

		button_21.setMinWidth(100);
		button_21.setMinHeight(100);
		button_21.setMaxWidth(100);
		button_21.setMaxHeight(100);

		button_22.setMinWidth(100);
		button_22.setMinHeight(100);
		button_22.setMaxWidth(100);
		button_22.setMaxHeight(100);

		gridpane.add(button_00, 0, 0);
		gridpane.add(button_01, 0, 1);
		gridpane.add(button_02, 0, 2);
		gridpane.add(button_10, 1, 0);
		gridpane.add(button_11, 1, 1);
		gridpane.add(button_12, 1, 2);
		gridpane.add(button_20, 2, 0);
		gridpane.add(button_21, 2, 1);
		gridpane.add(button_22, 2, 2);
		
		button_00.setOnAction(this);
		button_01.setOnAction(this);
		button_02.setOnAction(this);
		button_10.setOnAction(this);
		button_11.setOnAction(this);
		button_12.setOnAction(this);
		button_20.setOnAction(this);
		button_21.setOnAction(this);
		button_22.setOnAction(this);
		
		// Creates a new game by closing the window and restarting
		newGame.setOnAction(e -> {
			window.close();
				Platform.runLater( () -> {
					try {
						new Main().start(new Stage());
					} catch (Exception e1) {}
				});
		});
		
		window.setScene(scene);
		window.setResizable(false);
		window.show();		
	}
}