package ru.lesean.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppController
{
    @FXML
    private Label welcomeText;

    private File fileObject;

    @FXML protected void onHelloButtonClick(ActionEvent event)
    {
        Node source=  (Node) event.getSource();
        Stage privaryStage = (Stage) source.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter fb2Filter = new FileChooser.ExtensionFilter(".fb2 files (*.fb2)", "*.fb2");
        fileChooser.getExtensionFilters().add(fb2Filter);
        fileChooser.getExtensionFilters().addAll(fb2Filter);
        fileChooser.setTitle("Выбор файла");

        fileObject = fileChooser.showOpenDialog(privaryStage);

        if(fileObject == null)
        {
            return;
        }


	try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainWindow.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(fxmlLoader.load()));

            MainWindowController mainWindowController = fxmlLoader.getController();
            mainWindowController.Init();

            stage.show();

            fxmlLoader = new FXMLLoader(Main.class.getResource("popup.fxml"));
            stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
	}
	catch(IOException e)
	{
	    throw new RuntimeException(e);
	}
	    /*
        }
        catch (ParserConfigurationException | IOException | SAXException e)
        {
            e.printStackTrace();
        }
	    */

    }
}
