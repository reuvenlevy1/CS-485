package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    /*
        Creating an empty GUI
    */
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
                Tile tile = new Tile(j,i);
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
        private int x;
        private int y;
        private boolean on = true;


        public Tile(int x, int y){
            this.x = x;
            this.y = y;
            Rectangle border = new Rectangle(10,10);
            border.setFill(null);
            border.setStroke(Color.BLACK);


            //setAlignment(Pos.CENTER);
            getChildren().addAll(border);


            /*
              THIS EventHandler gets the xy position of any clicked cell.
             */
            addEventHandler(MouseEvent.MOUSE_PRESSED, cell ->{
                double x_coord = getPositionX();
                double y_cord  = getPositionY();
               System.out.println("Position clicked: "+"X: "+getPositionX()+" Y: "+getPositionY());
            });


            setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY)
                {
                    if (border.getFill() == Color.BLACK){
                        border.setFill(Color.WHITE);
                        setOnFalse();
                       // System.out.println("Cell Dead =: ");

                    }
                    else{
                        setOnTrue();
                        border.setFill(Color.BLACK);
                      //  System.out.println("Cell Alive =:");
                    }

                }
            });
        }

        public int getPositionX(){return x;}

        public int getPositionY(){return y;}

        public void setOnFalse(){on = false;}

        public void setOnTrue(){on = true;}

    }

    public static void main(String[] args) {
        launch(args);
    }
}
