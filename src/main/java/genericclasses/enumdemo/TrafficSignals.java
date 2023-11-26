package genericclasses.enumdemo;

public enum TrafficSignals {
    RED("STOP"),
    ORANGE("SLOW DOWN"),
    GREEN("GO");

    private final String action;

    TrafficSignals(String action){
        this.action = action;
    }

    public String getAction(){
        return this.action;
    }
}
