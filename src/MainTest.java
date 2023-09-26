import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    void testTankerCompartmentsIntialized(){
        Tanker t = new Tanker("Mr.Tanker", 30,100,80, "dk");
        assertEquals(20, t.compartments[1].getCapacity());
    }

    @Test
    void testTankerCompartmentLoadNull(){
        Tanker t = new Tanker("Mr.Tanker", 30,100,80, "dk");
        assertEquals(false, t.loadingCargo(null, 5));
    }

    @Test
    void testTankerCompartmentLoadInvalidString(){
        Tanker t = new Tanker("Mr.Tanker", 30,100,80, "dk");
        assertEquals(false, t.loadingCargo("null", 5));
    }

    @Test
    void testTankerCompartmentIsFull(){
        Tanker t = new Tanker("Mr.Tanker", 30,100,80, "kr");
        t.loadingCargo("1", 5);
        t.loadingCargo("1", 15);
        assertEquals(true, t.compartments[1].isFull());
    }

    @Test
    void testContainerVesselContainerOverload(){
        ContainerVessel cV = new ContainerVessel("Mr.Tanker", 30,100,80, "ru");
        cV.loadingCargo("TEU",1);
        assertEquals(false, cV.loadingCargo("TEU",14));
    }

    @Test
    void testRoRoLoadFractionWithoutCargo(){
        RoRo roro = new RoRo("Mr.Tanker", 30,100,80, "ru",100);
        assertEquals(0, roro.loadFraction());
    }

    @Test
    void testRoRoLoadCargoTruck(){
        RoRo roro = new RoRo("Mr.Tanker", 30,100,80, "ru",100);
        assertEquals(true,roro.loadingCargo("truck",5));
    }

    @Test
    void testRoRoLoadFracionWithCargo(){
        RoRo roro = new RoRo("Mr.Tanker", 30,100,80, "ru",100);
            roro.loadingCargo("truck",5);
        assertEquals(0.5,roro.loadFraction());
    }



}
