public class RoRo extends Vessel{
    int totalLaneMeters;
    int numberOfCars;
    int numberOfTrucks;
    int carLength;
    int truckLength;
    RoRo(String name, int draft, int length, int width, String flagNation, int laneMeters){
        super(name, draft, length, width, flagNation);
        this.carLength = 8;
        this.truckLength = 10;
        this.totalLaneMeters = laneMeters;
    }
    public boolean loadingCargo(String cargoType, int num){

        try{
           if(cargoType.toLowerCase() == "car"){
               if(((numberOfCars*carLength) + (numberOfTrucks*truckLength)) + (num * carLength) <= totalLaneMeters){
                   numberOfCars += num;
                   return true;
               }else{
                   return false;
               }
           }else if(cargoType.toLowerCase() == "truck"){
               if(((numberOfCars*carLength) + (numberOfTrucks*truckLength)) + (num * truckLength) <= totalLaneMeters){
                   numberOfTrucks += num;
                   return true;
               }else{
                   return false;
               }
           }else{
               return false;
           }

        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public double loadFraction(){
        if((numberOfCars*carLength + numberOfTrucks*truckLength) == 0){
            return 0;
        }else{
            double difference = totalLaneMeters /(numberOfCars*carLength + numberOfTrucks*truckLength);
            return 1.0/difference;
        }

    }
}
