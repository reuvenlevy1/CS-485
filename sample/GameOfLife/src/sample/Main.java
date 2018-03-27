package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Game Of Life CS485");
        primaryStage.setScene(new Scene(root, 800, 700));
        root.getChildren().add(CreateBoxes());

        primaryStage.show();
    }

    public Pane CreateBoxes(){
        Pane roots = new Pane();
        roots.setPrefSize(500,500);
        for (int i = 0; i< 35; i++)
        {
            for(int j = 0; j<70; j++){
                Tile tile = new Tile();
                tile.setTranslateX(j*10);
                tile.setTranslateY(i*10);

                roots.getChildren().add(tile);
            }
        }

        roots.setLayoutX(70);
        roots.setLayoutY(90);
        return roots;
    }

    public class Tile extends StackPane{


        public Tile(){
            Rectangle border = new Rectangle(10,10);
            border.setFill(null);
            border.setStroke(Color.BLACK);

            //setAlignment(Pos.CENTER);
            getChildren().addAll(border);

            setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY)
                {
                    border.setFill(Color.BLACK);
                }
            });
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
