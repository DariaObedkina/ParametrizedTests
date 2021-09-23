package doc.dobedkina.enumClasses;

public enum ToolsQaItems {

    ELEMENTS ("Elements"),
    FORMS ("Forms"),
    ALERTS ("Alerts, Frame & Windows"),
    WIDGETS ("Widgets"),
    INTERACTIONS ("Interactions");

    private String description;

    ToolsQaItems(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
