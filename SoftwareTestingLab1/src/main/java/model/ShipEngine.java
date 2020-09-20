package model;

public class ShipEngine {

    private static ShipEngine engine;
    public boolean isWorking;

    private ShipEngine() {
        this.isWorking = false;
    }

    public static ShipEngine getEngineInfo() {
        if (engine == null) {
            engine = new ShipEngine();
        }
        return engine;
    }

    public String startTheEngine() {

        if (!isWorking) {

            isWorking = true;
            return "Мотор зажжужал";

        } else {

            return "Мотор уже запущен";

        }
    }

    public String stopTheEngine() {

        if (!isWorking) {

            return "Мотор и так не работает";

        } else {

            isWorking = false;
            return "Мотор остановлен";

        }
    }
}