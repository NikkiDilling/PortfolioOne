public class Compartment {
    int maxCapacity; //cubic meters
    int loadedCapacity; //cubic meters

    Compartment(int maxCapacity){

        this.maxCapacity = maxCapacity;
    }

    public boolean isFull(){

        if(this.maxCapacity == this.loadedCapacity){
            return true;
        }else{
            return false;
        }
    }

    public void setLoadedCapacity(int capacity){
        this.loadedCapacity += capacity;
    }

    public Integer getloadedCapacity(){
        return this.loadedCapacity;
    }
    public Integer getCapacity(){
        if(this.maxCapacity > 0){
            return this.maxCapacity;
        }else{
            return null;
        }
    }
}
