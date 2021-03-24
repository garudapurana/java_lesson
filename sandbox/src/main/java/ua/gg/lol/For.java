package ua.gg.lol;

public class For {
    public static void main(String[] args) {
        int y=1;
        int k;
        int count=0;
        for(k=2;k<=6;k++){
            y = y + k;
            count++;
        }
        System.out.println("y = "+ y);
        System.out.println("k = "+k);
        System.out.println("count = "+ count);
    }
}
