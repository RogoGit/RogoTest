import org.junit.Assert;
import org.junit.Test;

public class LeftistHeapTest {

    // testing basic functions

    @Test
    public void testHeapCreationInsertion() {

        LeftistHeap heap = new LeftistHeap();

        heap.insert(5);
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(40);
        heap.insert(0);
        heap.insert(25);

        String expectedValue = heap.printHeap();
        String actualValue = "20 30 15 40 10 5 25 0 ";

        Assert.assertEquals("Ошибка при создании левацкой кучи", expectedValue, actualValue);

    }

    @Test
    public void testHeapClear() {

        LeftistHeap heap = new LeftistHeap();

        heap.insert(5);
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(40);
        heap.insert(0);
        heap.insert(25);

        heap.clear();

        String expectedValue = heap.printHeap();
        String actualValue = "";

        Assert.assertEquals("Ошибка при очистке кучи", expectedValue, actualValue);

    }

    @Test
    public void testHeapDeleteMin() {

        LeftistHeap heap = new LeftistHeap();

        heap.insert(5);
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(40);
        heap.insert(0);
        heap.insert(25);

        Integer deleted = heap.deleteMin();     // is deleted value correct
        String actualStructure = "20 30 15 40 25 10 5 ";    // is tree elements order correct after delete
        String expectedStructure = heap.printHeap();

        Assert.assertEquals("Неправильная структура дерева при удалении мимнимального элемента", expectedStructure, actualStructure);
        Assert.assertEquals("Значение удаленного элемента неправильное", deleted, (Integer) 0);

    }

    // testing unusual cases

    @Test
    public void testEmptyHeapDeleteMin() {

        LeftistHeap heap = new LeftistHeap();

        Integer deleted = heap.deleteMin();

        String expectedValue = heap.printHeap();
        String actualValue = "";

        Assert.assertEquals("Ошибка при удалении минимального элемента в пустой куче", expectedValue, actualValue);
        Assert.assertNull("Минимальное ", deleted);
    }

    @Test
    public void testOneElementDelete() {

        LeftistHeap heap = new LeftistHeap();

        heap.insert(5);
        heap.deleteMin();

        String expectedValue = heap.printHeap();
        String actualValue = "";

        Assert.assertEquals("Ошибка при удалении единственного элемента", expectedValue, actualValue);

    }

    @Test
    public void testOneElementHeapCreation() {

        LeftistHeap heap = new LeftistHeap();

        heap.insert(5);

        String expectedValue = heap.printHeap();
        String actualValue = "5 ";

        Assert.assertEquals("Ошибка при создании кучи с одной вершиной", expectedValue, actualValue);

    }

    // testing leftist heap sValues

    @Test
    public void testElementsSValues() {

        LeftistHeap heap = new LeftistHeap();

        heap.insert(5);
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(40);
        heap.insert(25);


        String expectedValue = heap.showSValues();
        String actualValue = "0 0 1 0 0 1 2 ";

        Assert.assertEquals("Ошибка при подсчете s-value элементов", expectedValue, actualValue);

    }

}
