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
    void testTankerLoadFractionWithCargo(){
        Tanker t = new Tanker("Mr.Tanker", 30,100,80, "kr");
        t.loadingCargo("1", 5);
        t.loadingCargo("1", 15);
        t.loadingCargo("2", 15);
        assertEquals(0.2, t.loadFraction(),0.01);
    }

    @Test
    void testTankerLoadFractionWithoutCargo(){
        Tanker t = new Tanker("Mr.Tanker", 30,100,80, "kr");
        assertEquals(0, t.loadFraction(),0.01);
    }

    @Test
    void testContainerVesselContainerOverload(){
        ContainerVessel cV = new ContainerVessel("Mr.Container", 30,100,80, "ru");
        cV.loadingCargo("TEU",1);
        assertEquals(false, cV.loadingCargo("TEU",100));
    }

    @Test
    void testContainerVesselLoadFraction(){
        ContainerVessel cV = new ContainerVessel("Mr.Container", 30,100,80, "ru");
        cV.loadingCargo("TEU",1);
        assertEquals(0.01, cV.loadFraction(), 0.01);
    }

    @Test
    void testRoRoLoadCargoTruck(){
        RoRo roro = new RoRo("Mr.Roro", 30,100,80, "ru",100);
        assertEquals(true,roro.loadingCargo("truck",5));
    }

    @Test
    void testRoRoLoadCargoInvalidString(){
        RoRo roro = new RoRo("Mr.Roro", 30,100,80, "ru",100);
        assertEquals(false,roro.loadingCargo("cyckle",5));
    }
    @Test
    void testRoRoLoadFractionWithoutCargo(){
        RoRo roro = new RoRo("Mr.Roro", 30,100,80, "ru",100);
        assertEquals(0, roro.loadFraction());
    }

    @Test
    void testRoRoLoadFracionWithCargo(){
        RoRo roro = new RoRo("Mr.Roro", 30,100,80, "ru",100);
            roro.loadingCargo("truck",5);
            roro.loadingCargo("truck",2);
            assertEquals(0.7,roro.loadFraction(), 0.01);
    }



}
