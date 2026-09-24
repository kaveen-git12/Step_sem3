public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; // Starts on RED by default
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void next() {
        switch (color) {
            case "RED":
                color = "GREEN";
                break;
            case "GREEN":
                color = "YELLOW";
                break;
            case "YELLOW":
                color = "RED";
                break;
        }
    }
}