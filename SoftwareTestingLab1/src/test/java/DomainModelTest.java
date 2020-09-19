import model.Astronaut;
import model.AstronautTransfer;
import model.Location;
import model.TransferWay;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DomainModelTest {

    private Astronaut astronaut;
    private AstronautTransfer transfer;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testAstronautTransfer() {

        astronaut = new Astronaut("Ford", Location.OUTER_SPACE);
        transfer = new AstronautTransfer(astronaut, Location.SPACE_SHIP);
        transfer.organizeTransfer();

        Assert.assertEquals(astronaut.getName() + " вылетел куда-то не туда", transfer.getDestination(), astronaut.getLocation());

    }

    @Test
    public void testSpaceTransferWay() {

        astronaut = new Astronaut("Ford", Location.SPACE_SHIP);
        transfer = new AstronautTransfer(astronaut, Location.OUTER_SPACE);
        transfer.organizeTransfer();

        Assert.assertEquals("Космноват должен был вылететь в космос, как конфетти", transfer.getTransferWay(), TransferWay.CONFETTI_LIKE_WAY);

    }

    @Test
    public void testTransferToSameLocation() {

        System.setOut(new PrintStream(outContent));

        astronaut = new Astronaut("Ford", Location.SPACE_SHIP);
        transfer = new AstronautTransfer(astronaut, Location.SPACE_SHIP);
        transfer.organizeTransfer();

        Assert.assertEquals("Нельзя отправить космонавта туда, где он находится сейчас", outContent.toString(), "Перемещение космонавта не требуется");

    }

    @Test (expected = NullPointerException.class)
    public void testTransferNullParameter() {
        astronaut = null;
        transfer = new AstronautTransfer(astronaut, null);
        transfer.organizeTransfer();
    }


}
