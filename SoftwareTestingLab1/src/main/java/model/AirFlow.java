package model;

public class AirFlow {

    private AirFlowIntensity intensity;
    private boolean isInTheVoid;


    public AirFlow() {
        this.intensity = AirFlowIntensity.NO_FLOW;
        this.isInTheVoid = false;
    }

    public AirFlowIntensity getIntensity() {
        return intensity;
    }

    public void moveToWhistle() {

        if (this.intensity.equals(AirFlowIntensity.NO_FLOW)) {

            if (ShipEngine.getEngineInfo().isWorking) {
                this.intensity = AirFlowIntensity.GENTLE_WHISTLE;
                this.isInTheVoid = false;
                System.out.println("Зазвучал тоненький свист");
            }

            if (!ShipEngine.getEngineInfo().isWorking) System.out.println("Мотор не работает. Все еще тишина...");

        }

        if (this.intensity.equals(AirFlowIntensity.GENTLE_WHISTLE)) {
            System.out.println("Свист не может перейти в свист");
        }

        if (this.intensity.equals(AirFlowIntensity.AIR_ROAR)) {

            if (ShipEngine.getEngineInfo().isWorking) System.out.println("Двигатель работает по полной! Рев не может стать свистом");

            if (!ShipEngine.getEngineInfo().isWorking) {
                System.out.println("Мотор не работает, и рев стихает, становясь свистом");
                this.intensity = AirFlowIntensity.GENTLE_WHISTLE;
                this.isInTheVoid = false;
            }

        }

    }

    public void moveToRoar() {

        if (this.intensity.equals(AirFlowIntensity.NO_FLOW)) {
            System.out.println("Невозможно стать ревом, не пройдя стадию свиста");
        }

        if (this.intensity.equals(AirFlowIntensity.AIR_ROAR)) {
            System.out.println("Рев не может перейти в рев");
        }

        if (this.intensity.equals(AirFlowIntensity.GENTLE_WHISTLE)) {

            if (ShipEngine.getEngineInfo().isWorking) {
                System.out.println("Тоненький свист перерос в рев воздуха, вырывающегося в пустоту");
                this.intensity = AirFlowIntensity.AIR_ROAR;
                this.isInTheVoid = true;
            }
            if (!ShipEngine.getEngineInfo().isWorking) System.out.println("Мотор не работает, и рев стихает, становясь свистом");

        }

    }

    public void moveToNoFlow() {

        if (this.intensity.equals(AirFlowIntensity.NO_FLOW)) {
            System.out.println("Все и так тихо, ни свиста, ни рева");
        }

        if (this.intensity.equals(AirFlowIntensity.AIR_ROAR)) {
            System.out.println("Рев не может стихнуть так сразу, ему нужно стать свистом");
        }

        if (this.intensity.equals(AirFlowIntensity.GENTLE_WHISTLE)) {

            if (ShipEngine.getEngineInfo().isWorking) System.out.println("Тоненький свист не может прекратиться, пока мотор работает");

            if (!ShipEngine.getEngineInfo().isWorking) {
                System.out.println("Мотор не работает, свист прекращается");
                this.intensity = AirFlowIntensity.NO_FLOW;
                this.isInTheVoid = false;
            }

        }

    }


}
