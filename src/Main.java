import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        coffeeMachine.start();



        while (!coffeeMachine.getState().equals(State.CLOSING))

            coffeeMachine.work(sc.next());
    }



}
