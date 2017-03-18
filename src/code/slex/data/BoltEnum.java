package net.slex.data;

/**
 * Created by Mihael on 18. 03. 2017.
 */
public enum BoltEnum {

    HEADLESS_ARROW("Arrow shaft", "Feather");

    private String[] requiredItems;

    BoltEnum(String... requiredItems) {
        this.requiredItems = requiredItems;
    }

    public String[] getRequiredItems() {
        return requiredItems;
    }

    private String capitalize(final String string) {
        return String.valueOf(string.charAt(0)).toUpperCase() + string.substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return capitalize(this.name()).replace("_", " ");
    }
}
