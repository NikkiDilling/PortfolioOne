public class Tanker extends Vessel{
    Compartment[] compartments;
    Tanker(String name, int draft, int length, int width, String flagNation){
        super(name, draft, length, width, flagNation);

        this.compartments = new Compartment[10];

        for(int i = 0; i < compartments.length ; i++){
            this.compartments[i] = new Compartment(20);
        }


    }
    public boolean loadingCargo(String containerNum, int capacity){

        try{
            int fillContainer = Integer.parseInt(containerNum);

            if(fillContainer >= 0 && fillContainer < 11){
                this.compartments[fillContainer].setLoadedCapacity(capacity);
                return true;
            }else{
                return false;
            }


        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }

    }
    public double loadFraction(){
        int compartmentsInUse = 0;
        for(int i = 0; i < 10; i++){
            if(this.compartments[i].getloadedCapacity() > 0){
                compartmentsInUse++;
            }
        }
        if(compartmentsInUse > 0){
            double fraction = (double) compartmentsInUse / 10;
            return Math.min(1.0, Math.max(0.0, fraction));
        }else{
            return 0;
        }

    }


}
