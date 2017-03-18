package net.slex;

import com.runemate.game.api.client.embeddable.EmbeddableUI;
import com.runemate.game.api.hybrid.util.Resources;
import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import net.slex.branches.TheBranchWeNeed;
import net.slex.data.FletcherSettings;
import net.slex.ui.Controller;

/**
 * Created by Mihael on 18. 03. 2017.
 */
public class MainClass extends TreeBot implements EmbeddableUI {

    private FletcherSettings fletcherSettings = new FletcherSettings(); // Create new settings class. Nothing is set in the class yet.
    private Controller controller = new Controller(fletcherSettings); // Create new controller with which we operate the FXML file we created. DON'T FORGET FXIDS
    private TheBranchWeNeed weNeed = new TheBranchWeNeed(fletcherSettings); // "Root" branch we are using to define whether to run the bot or not.


    @Override
    public TreeTask createRootTask() {
        return weNeed;
    }

    public MainClass() {
        setEmbeddableUI(this); // set the UI in runemate to the botInterfaceProperty overriden down there.
        fitToHeightProperty().set(true); // to make it resizable
    }

    @Override
    public void onStart(String... strings) {
        super.onStart(strings);
        setLoopDelay(200); // we will just be outputting some stuff. no need for fast loop.
    }


    @Override
    public ObjectProperty<? extends Node> botInterfaceProperty() {
        SimpleObjectProperty<Node> node = null;
        if (node == null) {
            try {
                FXMLLoader loader = new FXMLLoader(); // create a new loader with which we will load the file.
                loader.setController(controller); // you set it. you can see that one xD
                Node parent = loader.load(Resources.getAsStream("net/slex/ui/ui.fxml"));
                node = new SimpleObjectProperty<>(parent); // create a new Node which is later set in setEmbedableUI in the constructor.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return node;
    }
}
