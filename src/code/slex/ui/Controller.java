package net.slex.ui;

import com.runemate.game.api.client.ClientUI;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import net.slex.data.BoltEnum;
import net.slex.data.FletcherSettings;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Mihael on 18. 03. 2017.
 */
public class Controller implements Initializable {

    private FletcherSettings settings;

    public Controller(FletcherSettings settings) {
        this.settings = settings;
    }

    @FXML
    private ComboBox<BoltEnum> boltBox;

    @FXML
    private Button startButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boltBox.getItems().setAll(BoltEnum.values()); // set items to the box from the enum
        boltBox.getSelectionModel().select(0); // select the first item in the box (avoid empty selection)

        startButton.setOnAction(event -> { // set a method called when button is pressed.
            BoltEnum selected = boltBox.getSelectionModel().getSelectedItem(); // get selected item from the box
            ClientUI.showAlert("You selected: " + selected.name(), Color.ORANGERED); // random fun. show the alert on the top of the runemate.
            settings.setSelectedBolt(selected); // set selected item in the settings.
            startButton.setText("Update"); // change the text of the button.
        });

    }
}
