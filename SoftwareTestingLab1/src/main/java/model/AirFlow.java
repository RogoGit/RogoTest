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

    public boolean isInTheVoid() {
        return isInTheVoid;
    }

    public String moveToWhistle() {

        if (this.intensity.equals(AirFlowIntensity.NO_FLOW)) {

            if (ShipEngine.getEngineInfo().isWorking) {
                this.intensity = AirFlowIntensity.GENTLE_WHISTLE;
                this.isInTheVoid = false;
                return "Зазвучал тоненький свист";
            }

            if (!ShipEngine.getEngineInfo().isWorking) return "Мотор не работает. Все еще тишина...";

        }

        if (this.intensity.equals(AirFlowIntensity.GENTLE_WHISTLE)) {
            return "Свист не может перейти в свист";
        }

        if (this.intensity.equals(AirFlowIntensity.AIR_ROAR)) {

            if (ShipEngine.getEngineInfo().isWorking) return "Двигатель работает по полной! Рев не может стать свистом";

            if (!ShipEngine.getEngineInfo().isWorking) {
                this.intensity = AirFlowIntensity.GENTLE_WHISTLE;
                this.isInTheVoid = false;
                return "Мотор не работает, и рев стихает, становясь свистом";
            }

        }

        return null;

    }

    public String moveToRoar() {

        if (this.intensity.equals(AirFlowIntensity.NO_FLOW)) {
            return "Невозможно стать ревом, не пройдя стадию свиста";
        }

        if (this.intensity.equals(AirFlowIntensity.AIR_ROAR)) {
            return "Рев не может перейти в рев";
        }

        if (this.intensity.equals(AirFlowIntensity.GENTLE_WHISTLE)) {

            if (ShipEngine.getEngineInfo().isWorking) {
                this.intensity = AirFlowIntensity.AIR_ROAR;
                this.isInTheVoid = true;
                return "Тоненький свист перерос в рев воздуха, вырывающегося в пустоту";
            }
            if (!ShipEngine.getEngineInfo().isWorking) return "Свист не может стать ревом, мотор перестал работать";

        }

        return null;

    }

    public String moveToNoFlow() {

        if (this.intensity.equals(AirFlowIntensity.NO_FLOW)) {
            return "Все и так тихо, ни свиста, ни рева";
        }

        if (this.intensity.equals(AirFlowIntensity.AIR_ROAR)) {
            return "Рев не может стихнуть так сразу, ему нужно стать свистом";
        }

        if (this.intensity.equals(AirFlowIntensity.GENTLE_WHISTLE)) {

            if (ShipEngine.getEngineInfo().isWorking) return "Тоненький свист не может прекратиться, пока мотор работает";

            if (!ShipEngine.getEngineInfo().isWorking) {
                this.intensity = AirFlowIntensity.NO_FLOW;
                this.isInTheVoid = false;
                return "Мотор не работает, свист прекращается";
            }

        }

        return null;
    }


}
