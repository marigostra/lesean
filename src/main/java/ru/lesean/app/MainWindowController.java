package ru.lesean.app;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class MainWindowController
{

    public class TextHolder
    {
        public String Text;
    }
    @FXML
    private Label BookName;

    @FXML
    private TextArea MainTextArea;

    @FXML
    private Button SaveButton;

    @FXML
    private Button SearchButton;

    //    private FictionBook _book;
    private String _bookName;
    private TextHolder _parsedBook = new TextHolder();
    private TextHolder _metadata = new TextHolder();

    public void Init()
    {
	//        MainTextArea.setText(_parsedBook.Text);
    }

    @FXML
    void OnSaveClickHandler(MouseEvent event)
    {
        try
        {
            Node source=  (Node) event.getSource();
            Stage privaryStage = (Stage) source.getScene().getWindow();
            DirectoryChooser directoryChooser = new DirectoryChooser ();
            directoryChooser.setTitle("Выберите директорию для сохранения");
            directoryChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
            File textFile = new File(directoryChooser.showDialog(privaryStage), _bookName + "text.txt") ;
            textFile.createNewFile();
            FileWriter writer = new FileWriter(textFile, false);
            writer.write(_parsedBook.Text);
            writer.flush();
        }
        catch (Exception exception)
        {

        }

    }

    @FXML
    void OnSearchClickClick(MouseEvent event)
    {
        try
        {
            Node source = (Node) event.getSource();
            Stage privaryStage = (Stage) source.getScene().getWindow();
            DirectoryChooser directoryChooser = new DirectoryChooser ();
            directoryChooser.setTitle("Выберите директорию для сохранения");
            directoryChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
            File jsonFile = new File(directoryChooser.showDialog(privaryStage), _bookName + "meta.json") ;
            jsonFile.createNewFile();
            FileWriter writer = new FileWriter(jsonFile, false);
            writer.write(_metadata.Text);
            writer.flush();
        }
        catch (Exception exception)
        {

        }
    }

    protected void ParseSectionString(TextHolder str)
    {
    }

    protected void ParseTitleString(TextHolder writer)
    {
	//                writer.Text += titleValue.getText() + "\n";
    }


    protected void ParseSection(FileWriter writer)
    {
    }

}
