import javafx.application.Platform;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Sequences;

import java.io.IOException;

public class WindowPresenter {
    public WindowPresenter(WindowController controller, Sequences sequences){

        controller.getCloseMenuItem().setOnAction(e-> Platform.exit());

        controller.getOpenMenuItem().setOnAction(e-> openFile(null, controller, sequences));

        controller.getShowHeaderCheckbox().setOnAction(e -> openFile(null, controller, sequences));

    }

    private void openFile(Stage stage, WindowController windowController, Sequences model){
        var fileChooser = new FileChooser();
        fileChooser.setTitle("Open a FastA file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("FastA FIles", "*.fasta", "*.fa", "*.fna"), new FileChooser.ExtensionFilter("ALl Files", "*.*"));
        var selectedFile=fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            model.clear();
            windowController.getNumberSequencesLabel().setText("empty");
            try {
                model.read(selectedFile.getPath());
                windowController.getSeqTextArea().setText(
                        model.getText(windowController.getShowHeaderCheckbox().isSelected()));
                windowController.getNumberSequencesLabel().setText("Number of sequences " + model.size());
            } catch (IOException e) {
                windowController.getNumberSequencesLabel().setText("Error " + e.getMessage());
            }
        }
    }
}
