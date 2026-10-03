import java.util.Scanner;

interface Dimmable {
    void setBrightness(int brightness);
    int getBrightness();
}

interface TemperatureAdjustable {
    void setTemperature(int temperature);
    int getTemperature();
}

abstract class SmartDevice {
    protected String name;
    protected boolean isOn;

    public SmartDevice(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getName() {
        return name;
    }

    public abstract String getStatus();
}

class LightDevice extends SmartDevice implements Dimmable {
    private int brightness;

    public LightDevice(String name) {
        super(name);
        this.brightness = 100;
    }

    @Override
    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    @Override
    public int getBrightness() {
        return brightness;
    }

    @Override
    public String getStatus() {
        return String.format("%s: %s (Brightness: %d%%)", name, isOn ? "ON" : "OFF", brightness);
    }
}

class ThermostatDevice extends SmartDevice implements TemperatureAdjustable {
    private int temperature;

    public ThermostatDevice(String name) {
        super(name);
        this.temperature = 22;
    }

    @Override
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public int getTemperature() {
        return temperature;
    }

    @Override
    public String getStatus() {
        return String.format("%s: %s (Temp: %dC)", name, isOn ? "ON" : "OFF", temperature);
    }
}

class FanDevice extends SmartDevice {
    public FanDevice(String name) {
        super(name);
    }

    @Override
    public String getStatus() {
        return String.format("%s: %s", name, isOn ? "ON" : "OFF");
    }
}

public class SmartHomeController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        SmartDevice[] devices = new SmartDevice[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            switch (type) {
                case "LIGHT":
                    devices[i] = new LightDevice(name);
                    break;
                case "THERMOSTAT":
                    devices[i] = new ThermostatDevice(name);
                    break;
                case "FAN":
                    devices[i] = new FanDevice(name);
                    break;
            }
        }

        int commandCount = scanner.nextInt();
        for (int i = 0; i < commandCount; i++) {
            String name = scanner.next();
            String command = scanner.next();

            SmartDevice targetDevice = null;
            for (SmartDevice dev : devices) {
                if (dev.getName().equals(name)) {
                    targetDevice = dev;
                    break;
                }
            }

            if (targetDevice != null) {
                switch (command) {
                    case "ON":
                        targetDevice.turnOn();
                        break;
                    case "OFF":
                        targetDevice.turnOff();
                        break;
                    case "SET_BRIGHTNESS":
                        int brightness = scanner.nextInt();
                        if (targetDevice instanceof Dimmable) {
                            ((Dimmable) targetDevice).setBrightness(brightness);
                        }
                        break;
                    case "SET_TEMP":
                        int temp = scanner.nextInt();
                        if (targetDevice instanceof TemperatureAdjustable) {
                            ((TemperatureAdjustable) targetDevice).setTemperature(temp);
                        }
                        break;
                }
            }
        }

        for (SmartDevice dev : devices) {
            System.out.println(dev.getStatus());
        }

        scanner.close();
    }
}