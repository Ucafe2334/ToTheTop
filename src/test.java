import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();

        for(int i = 1; i<=10; i++){
            if (ch == i){
                System.out.println(i);
            }
        }
    }

}
