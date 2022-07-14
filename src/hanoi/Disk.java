package hanoi;

public class Disk {
    private int length;


    public Disk(int length){
        this.length = length;
    }

    public String getVisualLength(int totalLength){
        return " ".repeat((totalLength - length)/2) + "x".repeat(length) + " ".repeat((totalLength - length)/2);
    }
}
