import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class WindowController {

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private Button applyKSizeButton;

    @FXML
    private MenuItem clearAllMenuItem;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem fullscreenMenuItem;

    @FXML
    private Label kMerSizeLabel;

    @FXML
    private TextField kSizeTextField;

    @FXML
    private Label numberSequencesLabel;

    @FXML
    private MenuItem openMenuItem;

    @FXML
    private TextArea seqTextArea;

    @FXML
    private CheckBox showHeaderCheckbox;

    @FXML
    private CheckBox wrapTextCheckbox;

    public MenuItem getAboutMenuItem() {
        return aboutMenuItem;
    }

    public Button getApplyKSizeButton() {
        return applyKSizeButton;
    }

    public MenuItem getClearAllMenuItem() {
        return clearAllMenuItem;
    }

    public MenuItem getCloseMenuItem() {
        return closeMenuItem;
    }

    public MenuItem getFullscreenMenuItem() {
        return fullscreenMenuItem;
    }

    public Label getkMerSizeLabel() {
        return kMerSizeLabel;
    }

    public TextField getkSizeTextField() {
        return kSizeTextField;
    }

    public Label getNumberSequencesLabel() {
        return numberSequencesLabel;
    }

    public MenuItem getOpenMenuItem() {
        return openMenuItem;
    }

    public TextArea getSeqTextArea() {
        return seqTextArea;
    }

    public CheckBox getShowHeaderCheckbox() {
        return showHeaderCheckbox;
    }

    public CheckBox getWrapTextCheckbox() {
        return wrapTextCheckbox;
    }
}
