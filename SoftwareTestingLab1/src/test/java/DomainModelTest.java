import model.*;
import org.junit.*;

public class DomainModelTest {

    private Astronaut astronaut;
    private AstronautTransfer transfer;
    private AirFlow airFlow;


    @After
    public void resettingTestData() {
        ShipEngine.getEngineInfo().isWorking = false;
    }

    @Test
    public void testAstronautStartingLocation() {

        astronaut = new Astronaut("Ford");
        Assert.assertEquals("Космонавт еще не выходил в космос и должен сейчас быть на корабле", Location.SPACE_SHIP, astronaut.getLocation());
    }

    @Test
    public void testTransferAstronautToSpace() {

        astronaut = new Astronaut("Ford");

        transfer = new AstronautTransfer(astronaut, Location.OUTER_SPACE);
        transfer.organizeTransfer();

        Assert.assertEquals(astronaut.getName() + " вылетел куда-то не туда", astronaut.getLocation(),  transfer.getDestination());
        Assert.assertEquals("Космноват должен был вылететь в космос, как конфетти", TransferWay.CONFETTI_LIKE_WAY,  transfer.getTransferWay());

    }

    @Test
    public void testTransferToSameLocation() {

        astronaut = new Astronaut("Ford");

        transfer = new AstronautTransfer(astronaut, Location.SPACE_SHIP);
        String actualValue = transfer.organizeTransfer();

        Assert.assertEquals("Нельзя отправить космонавта туда, где он находится сейчас", "Перемещение космонавта не требуется", actualValue);

    }

    @Test (expected = NullPointerException.class)
    public void testTransferNullParameters() {

        transfer = new AstronautTransfer(null, null);
        transfer.organizeTransfer();

    }

    @Test
    public void testEngineInitialState() {
        Assert.assertFalse("Изначально мотор должен быть выключен", ShipEngine.getEngineInfo().isWorking);
    }

    @Test
    public void testEngineStart() {

        ShipEngine.getEngineInfo().startTheEngine();
        Assert.assertTrue("Мотор не заработал", ShipEngine.getEngineInfo().isWorking);

    }

    @Test
    public void testEngineStop() {

        ShipEngine.getEngineInfo().startTheEngine();
        ShipEngine.getEngineInfo().stopTheEngine();
        Assert.assertFalse("Мотор не перестал работать", ShipEngine.getEngineInfo().isWorking);

    }

    @Test
    public void testEngineActionRepetition() {

        String actualStop = ShipEngine.getEngineInfo().stopTheEngine();
        Assert.assertEquals("Нельзя повторно остановить двигатель", "Мотор и так не работает", actualStop);
        ShipEngine.getEngineInfo().startTheEngine();
        String actualRun = ShipEngine.getEngineInfo().startTheEngine();
        Assert.assertEquals("Нельзя повторно запустить двигатель", "Мотор уже запущен", actualRun);

    }

    @Test
    public void testAirFlowBeginningState() {

        airFlow = new AirFlow();

        Assert.assertEquals("Изначально никакого воздушного потока нет", AirFlowIntensity.NO_FLOW, airFlow.getIntensity());
        Assert.assertFalse("Только рев может вырваться в пустоту", airFlow.isInTheVoid());

    }

    @Test
    public void testAirFlowIncreasing() {

        airFlow = new AirFlow();

        ShipEngine.getEngineInfo().startTheEngine();
        airFlow.moveToWhistle();
        Assert.assertEquals("Должен был появиться свист", AirFlowIntensity.GENTLE_WHISTLE, airFlow.getIntensity());
        Assert.assertFalse("Свист не может вырваться в пустоту", airFlow.isInTheVoid());
        airFlow.moveToRoar();
        Assert.assertEquals("Свист не стал ревом", AirFlowIntensity.AIR_ROAR, airFlow.getIntensity());
        Assert.assertTrue("Рев должен вырываться в пустоту", airFlow.isInTheVoid());

    }

    @Test
    public void testAirFlowDecreasing() {

        airFlow = new AirFlow();

        ShipEngine.getEngineInfo().startTheEngine();
        airFlow.moveToWhistle();
        airFlow.moveToRoar();
        ShipEngine.getEngineInfo().stopTheEngine();

        airFlow.moveToWhistle();
        Assert.assertEquals("Рев должен был стать свистом", AirFlowIntensity.GENTLE_WHISTLE, airFlow.getIntensity());
        Assert.assertFalse("Свист не может вырваться в пустоту", airFlow.isInTheVoid());
        airFlow.moveToNoFlow();
        Assert.assertEquals("Свист не пркратился", AirFlowIntensity.NO_FLOW, airFlow.getIntensity());
        Assert.assertFalse("Только рев может вырываться в пустоту", airFlow.isInTheVoid());

    }

    @Test
    public void testFlowMovingThroughStep() {

        airFlow = new AirFlow();
        ShipEngine.getEngineInfo().startTheEngine();

        String actualToRoar = airFlow.moveToRoar();
        Assert.assertEquals("Нельзя перейти к реву, не став свистом","Невозможно стать ревом, не пройдя стадию свиста", actualToRoar);

        airFlow.moveToWhistle();
        airFlow.moveToRoar();
        ShipEngine.getEngineInfo().stopTheEngine();
        String actualToNoFlow = airFlow.moveToNoFlow();
        Assert.assertEquals("Нельзя перейти к этой стадии, не переходя в свист","Рев не может стихнуть так сразу, ему нужно стать свистом", actualToNoFlow);

    }

    @Test
    public void testMovingToSameConditions() {

        airFlow = new AirFlow();
        ShipEngine.getEngineInfo().startTheEngine();

        String actualToNoFlow = airFlow.moveToNoFlow();
        Assert.assertEquals("Неправильно обработан переход к одному и тому же состоянию","Все и так тихо, ни свиста, ни рева", actualToNoFlow);
        airFlow.moveToWhistle();
        String actualToWhistle = airFlow.moveToWhistle();
        Assert.assertEquals("Неправильно обработан переход к одному и тому же состоянию","Свист не может перейти в свист", actualToWhistle);
        airFlow.moveToRoar();
        String actualToRoar = airFlow.moveToRoar();
        Assert.assertEquals("Неправильно обработан переход к одному и тому же состоянию","Рев не может перейти в рев", actualToRoar);

    }

    @Test
    public void testAirFlowIncreasingWithEngineTurnOff() {

        airFlow = new AirFlow();

        String actualToWhistle = airFlow.moveToWhistle();
        Assert.assertEquals("Свист не раздастся, если двигатель не работает","Мотор не работает. Все еще тишина...", actualToWhistle);
        Assert.assertEquals("Интенсивность потока не должна была измениться", AirFlowIntensity.NO_FLOW, airFlow.getIntensity());
        Assert.assertFalse("Воздух не может вырваться в пустоту", airFlow.isInTheVoid());

        ShipEngine.getEngineInfo().startTheEngine();
        airFlow.moveToWhistle();
        ShipEngine.getEngineInfo().stopTheEngine();

        String actualToRoar = airFlow.moveToRoar();
        Assert.assertEquals("Свист не станет ревом, если двигатель не работает","Свист не может стать ревом, мотор перестал работать", actualToRoar);
        Assert.assertEquals("Интенсивность потока не должна была измениться", AirFlowIntensity.GENTLE_WHISTLE, airFlow.getIntensity());
        Assert.assertFalse("Свист не стал ревом и не может вырваться в пустоту", airFlow.isInTheVoid());

    }

    @Test
    public void testAirFlowDecreasingWithEngineTurnOn() {

        airFlow = new AirFlow();
        ShipEngine.getEngineInfo().startTheEngine();
        airFlow.moveToWhistle();
        airFlow.moveToRoar();

        String actualToWhistle = airFlow.moveToWhistle();
        Assert.assertEquals("Рев не может стать свистом, двигатель работает","Двигатель работает по полной! Рев не может стать свистом", actualToWhistle);
        Assert.assertEquals("Интенсивность потока не должна была измениться", AirFlowIntensity.AIR_ROAR, airFlow.getIntensity());
        Assert.assertTrue("Двигатель включен, рев не стих и может вырваться в пустоту", airFlow.isInTheVoid());

        ShipEngine.getEngineInfo().stopTheEngine();
        airFlow.moveToWhistle();
        ShipEngine.getEngineInfo().startTheEngine();

        String actualToNoFlow = airFlow.moveToNoFlow();
        Assert.assertEquals("Свист не может прекратиться, двигатель работает!","Тоненький свист не может прекратиться, пока мотор работает", actualToNoFlow);
        Assert.assertEquals("Интенсивность потока не должна была измениться", AirFlowIntensity.GENTLE_WHISTLE, airFlow.getIntensity());
        Assert.assertFalse("Свист не может вырваться в пустоту", airFlow.isInTheVoid());

    }

}
