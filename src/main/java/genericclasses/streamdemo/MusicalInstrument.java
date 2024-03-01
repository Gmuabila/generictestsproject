package genericclasses.streamdemo;

public class MusicalInstrument {
    //This is a straightforward Java bean that contains two properties:
    // musical instrument name (e.g., trumpet) and type of musical instrument (e.g., brass).
    private String name;
    private String type;

    public MusicalInstrument(String name, String type) {
        setName(name);
        setType(type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "[" + name + " is a " + type + " instrument]";
    }
}
