public class RoRo extends Vessel{
    int totalLaneMeters;
    int loaded;
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
           if(cargoType.toLowerCase().equals("car")){
               if(this.loaded + (num * carLength) <= totalLaneMeters){
                   numberOfCars += num;
                   this.setLoaded();
                   return true;
               }else{
                   return false;
               }
           }else if(cargoType.toLowerCase().equals("truck")){
               if(this.loaded + (num * truckLength) <= totalLaneMeters){
                   numberOfTrucks += num;
                   this.setLoaded();
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

    public void setLoaded(){
        this.loaded = (numberOfCars*carLength) + (numberOfTrucks*truckLength);
    }

    public int getLoaded(){
        return this.loaded;
    }


    public double loadFraction(){
        if(this.loaded == 0){
            return 0;
        }else{
            double fraction = (double) this.loaded / this.totalLaneMeters;
            return Math.min(1.0, Math.max(0.0, fraction));
        }

    }
}
