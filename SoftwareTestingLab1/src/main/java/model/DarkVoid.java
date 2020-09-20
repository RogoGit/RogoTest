package model;

import java.util.ArrayList;

public class DarkVoid {

    public static final int minDotNumberToBeSplashed = 100;

    private ArrayList<BrightDot> incrediblyBrightDots;

    public DarkVoid() {
        this.incrediblyBrightDots = new ArrayList<>();
    }

    public ArrayList<BrightDot> getIncrediblyBrightDots() {
        return incrediblyBrightDots;
    }

    public boolean canFeelAirFlow(AirFlow airFlow) {
        return airFlow.isInTheVoid();
    }

    public String  fillVoidWithDots(int requiredBrightness) {

        if (requiredBrightness < 0 || requiredBrightness > 1000) return "Необходимая яркость должна быть между 0 и 1000";

        if (!this.getIncrediblyBrightDots().isEmpty()) return "Эта пустота уже усеяна яркими точками";

        while (this.incrediblyBrightDots.size() < minDotNumberToBeSplashed) {

            BrightDot dot = new BrightDot(Math.random() * 1000);
            if (dot.getBrightness() >= requiredBrightness) {
                this.incrediblyBrightDots.add(dot);
            }

        }

        return "Пустота усеяна невероятно яркими точками";

    }

    public void clearTheVoid() {
        this.incrediblyBrightDots.clear();
    }

    public int getDotsNum() {
        return this.incrediblyBrightDots.size();
    }

}
