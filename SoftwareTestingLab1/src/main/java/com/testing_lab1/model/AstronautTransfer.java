package com.testing_lab1.model;

public class AstronautTransfer {

    private TransferWay transferWay;
    private Astronaut astronaut;
    private Location destination;

    public AstronautTransfer(Astronaut astronaut, Location destination) {

        this.transferWay = TransferWay.BORING_NORMAL_WAY;
        this.astronaut = astronaut;
        this.destination = destination;
    }

    public Location getDestination() {
        return destination;
    }

    public TransferWay getTransferWay() {
        return transferWay;
    }

    public void organizeTransfer() {

        if (this.destination.equals(this.astronaut.getLocation())) {

            System.out.print("Перемещение космонавта не требуется");

        } else {

            if ((destination.equals(Location.OUTER_SPACE))) {
                this.transferWay = TransferWay.CONFETTI_LIKE_WAY;
            }

            this.astronaut.setLocation(this.destination);

        }

    }

}
