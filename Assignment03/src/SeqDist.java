import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Sequences;

public class SeqDist extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        var windowView=new WindowView();
        var model=new Sequences();
        var presenter=new WindowPresenter(windowView.getWindowController(), model);

        stage.setScene(new Scene(windowView.getRoot()));
        stage.setTitle("SeqDist");
        stage.show();
    }
}
