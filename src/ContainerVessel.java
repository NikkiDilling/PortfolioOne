public class ContainerVessel extends Vessel{
    int maxContainers;
    int loadedContainers;
    ContainerVessel(String name, int draft, int length, int width, String flagNation){
        super(name, draft, length, width, flagNation);
        this.maxContainers = 14;
    }
    public boolean loadingCargo(String cargoType, int containerNum){
        //load cargo only if the string matches
        if(cargoType.toLowerCase().equals("teu")){

            if(containerNum > 0 && containerNum <= this.maxContainers){
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
            int difference = maxContainers/loadedContainers;
            return 1/difference;
        }else{
            return 0;
        }

    }
}
