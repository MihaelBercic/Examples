package net.slex.data;

/**
 * Created by Mihael on 18. 03. 2017.
 */
public class FletcherSettings {

    private BoltEnum selectedBolt; // on creation the selection is null since user hasn't selected anything.

    public BoltEnum getSelectedBolt() { // get the selected bolt.
        return selectedBolt;
    }

    public void setSelectedBolt(BoltEnum selectedBolt) { // set the selected bolt
        this.selectedBolt = selectedBolt;
    }
}
