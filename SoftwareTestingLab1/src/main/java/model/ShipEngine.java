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

    public void startTheEngine() {

        if (!isWorking) {

            isWorking = true;
            System.out.println("Мотор зажжужал");

        } else {

            System.out.println("Мотор уже запущен");

        }
    }

    public void stopTheEngine() {

        if (!isWorking) {

            System.out.println("Мотор и так не работает");

        } else {

            isWorking = false;
            System.out.println("Мотор остановлен");

        }
    }
}