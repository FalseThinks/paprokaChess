package com.paproka.paprokachess;

import com.paproka.paprokachess.chess.Board;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class chessController extends Application {
    @Override
    public void start(Stage stage) { //Default para el start, aqui va todo
        //Creamos el objeto texto, creamos el tablero.
        Text text = new Text();
        Board chess = new Board(8, 8);
        chess.generateBoard(chess);

        //Añadimos el resultado del tablero al texto
        text.setText(chess.toString());

        //Posicionamiento de este texto
        text.setX(200);
        text.setY(100);

        //Creamos un grupo que contenga los elementos
        Group root = new Group(text);

        //Creamos una escena que contenga los grupos que queramos
        Scene scene = new Scene(root, 600, 300);

        //Titulo
        stage.setTitle("Paproka chess");

        //Añadimos la escena
        stage.setScene(scene);

        //Muestra el contenido
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}