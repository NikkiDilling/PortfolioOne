public class ContainerVessel extends Vessel{
    int maxContainers;
    int loadedContainers;
    ContainerVessel(String name, int draft, int length, int width, String flagNation){
        super(name, draft, length, width, flagNation);
        this.maxContainers = 100;
    }
    public boolean loadingCargo(String cargoType, int containerNum){
        //load cargo only if the string matches
        if(cargoType.toLowerCase().equals("teu")){

            if(containerNum > 0 && containerNum + loadedContainers <= this.maxContainers){
                return setLoadedContainer(containerNum);
            }else{
                return false;
            }

        }
        return false;
    }

    public boolean setLoadedContainer(int containerNumber){

        if((this.loadedContainers+containerNumber) <= this.maxContainers){
            this.loadedContainers += containerNumber;
            return true;
        }

        return false;
    }
    public double loadFraction(){
        if(loadedContainers > 0){
            double fraction = (double) loadedContainers / maxContainers;
            return Math.min(1.0, Math.max(0.0, fraction));
        }else{
            return 0;
        }

    }
}
