import model.*;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DomainModelTest {

    private static Astronaut astronaut;
    private AstronautTransfer transfer;

    private final ByteArrayOutputStream outData = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeClass
    public static void createAstro() {
        astronaut = new Astronaut("Ford");
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outData));
    }

    @After
    public void resettingTestData() {

        ShipEngine.getEngineInfo().isWorking = false;
        astronaut.setLocation(Location.SPACE_SHIP);
        System.setOut(originalOut);
    }

    @Test
    public void testAstronautStartingLocation() {

        Assert.assertEquals("Космонавт еще не выходил в космос и должен сейчас быть на корабле", Location.SPACE_SHIP, astronaut.getLocation());
    }

    @Test
    public void testTransferAstronautToSpace() {

        transfer = new AstronautTransfer(astronaut, Location.OUTER_SPACE);
        transfer.organizeTransfer();

        Assert.assertEquals(astronaut.getName() + " вылетел куда-то не туда", astronaut.getLocation(),  transfer.getDestination());
        Assert.assertEquals("Космноват должен был вылететь в космос, как конфетти", TransferWay.CONFETTI_LIKE_WAY,  transfer.getTransferWay());

    }

    @Test
    public void testTransferToSameLocation() {

        transfer = new AstronautTransfer(astronaut, Location.SPACE_SHIP);
        transfer.organizeTransfer();

        Assert.assertEquals("Нельзя отправить космонавта туда, где он находится сейчас", "Перемещение космонавта не требуется", outData.toString());

    }

    @Test (expected = NullPointerException.class)
    public void testTransferNullParameters() {

        transfer = new AstronautTransfer(null, null);
        transfer.organizeTransfer();

    }

    @Test
    public void testEngineStart() {

        ShipEngine.getEngineInfo().startTheEngine();
        Assert.assertTrue("Мотор не заработал", ShipEngine.getEngineInfo().isWorking);

    }

    @Test
    public void testEngineStop() {

        ShipEngine.getEngineInfo().stopTheEngine();
        Assert.assertFalse("Мотор не перестал работать", ShipEngine.getEngineInfo().isWorking);

    }

    @Test
    public void testRepetition() {

        ShipEngine.getEngineInfo().stopTheEngine();
        Assert.assertEquals("Нельзя повторно остановить двигатель", "Мотор и так не работает\n", outData.toString());

    }


}
