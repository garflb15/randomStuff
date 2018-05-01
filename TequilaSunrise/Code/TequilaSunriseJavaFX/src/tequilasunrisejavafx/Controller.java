/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tequilasunrisejavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 *
 * @author Flori
 */
public class Controller extends Application
{    
    @Override
    public void start(Stage primaryStage)
    {
        VBox layout = new VBox();
        Picture picture = new Picture();
        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args)
    {
        launch(args);
    }*/
    
}
