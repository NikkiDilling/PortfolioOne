public abstract class Vessel {
    String name;
    String flagNation;
    int draft;
    int length;
    int width;

    Vessel(String name, int draft, int length, int width, String flagNation){
        this.name = name;
        this.draft = draft;
        this.length = length;
        this.width = width;
        this.flagNation = flagNation;
    }

    public abstract boolean loadingCargo(String s, int num);
    public abstract double loadFraction();

}
