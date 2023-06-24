import java.util.Scanner;
public class test1 {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println((scan.next().matches("[^A-Za-z0-9 ]")));
        }
    }
}
