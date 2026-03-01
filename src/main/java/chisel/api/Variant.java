package chisel.api;

public class Variant {

    private final String name;
    private final boolean canConnect;

    public Variant(String name, boolean canConnect) {
        this.name = name;
        this.canConnect = canConnect;
    }

    public String getName() {
        return name;
    }

    public boolean hasConnectedTextures() {
        return canConnect;
    }
}
