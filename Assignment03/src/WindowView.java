import com.sun.javafx.stage.WindowEventDispatcher;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class WindowView {
    private final Parent root;
    private final WindowController windowController;

    public WindowView() throws IOException {
        try(var ins= Objects.requireNonNull(getClass().getResource("Window.fxml")).openStream()){
            var fxmlLoader= new FXMLLoader();
            fxmlLoader.load(ins);

            windowController=fxmlLoader.getController();
            root=fxmlLoader.getRoot();
        }
    }

    public WindowController getWindowController() {
        return windowController;
    }

    public Parent getRoot() {
        return root;
    }
}
