public class CoffeeMachine {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;
    private State state;

    public State getState() {
        return state;
    }

    public CoffeeMachine(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;

    }

    void start() {
        this.state = State.READY;
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    void chooseAction(String s) {
        switch (s) {
            case "buy":
                this.state = State.CHOOSING_COFFEE;
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                break;
            case "fill":
                this.state = State.FILLING_WATER;
                System.out.println("Write how many ml of water do you want to add: ");
                break;
            case "remaining":
                showRemaining();
                start();
                break;
            case "exit":
                this.state = State.CLOSING;
                break;
            case "take":
                take();
                start();
                break;



        }

    }



    void chooseCoffee(String s) {


        switch (s) {
            case "1":
                this.state = State.ESPRESSO;
                buy();
                break;
            case "2":
                this.state = State.CAPPUCCINO;
                buy();
                break;
            case "3":
                this.state = State.LATTE;
                buy();
                break;

            case "back":
                this.state = State.READY;
                break;
        }


    }

    void work(String s) {

        switch (state) {
            case READY:
                this.state = State.CHOOSING_ACTION;
                chooseAction(s);
                break;
            case CHOOSING_COFFEE:
                chooseCoffee(s);
                break;
            case FILLING_WATER:
            case FILLING_MILK:
            case FILLING_BEANS:
            case FILLING_CUPS:
                fill(s);
                break;


        }

    }


    private void buy() {


//        state = State.CHOOSING_COFFEE;


        switch (state) {
            case READY:
                break;
            case ESPRESSO:
                if (this.water < 250) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }
                if (this.coffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }
                if (this.cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 250;
                    this.coffeeBeans -= 16;
                    this.money += 4;
                    this.cups -= 1;
//                    System.out.println();

                    break;
                }

            case CAPPUCCINO:

                if (this.water < 350) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }
                if (this.coffeeBeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }
                if (this.cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                }
                if (this.milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else {

                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 350;
                    this.milk -= 75;
                    this.coffeeBeans -= 20;
                    this.money += 7;
                    this.cups-= 1;
//                    System.out.println();

                    break;
                }

            case LATTE:


                if (this.water < 200) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }
                if (this.coffeeBeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }
                if (this.cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                }
                if (this.milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else {

                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 200;
                    this.milk -= 100;
                    this.coffeeBeans -= 12;
                    this.money += 6;
                    this.cups -= 1;
//                    System.out.println();

                    break;
                }

        }
        System.out.println();
        start();

    }

    private void fill(String s) {
        switch(this.state){

            case FILLING_WATER:
                this.water += Integer.parseInt(s);
                this.state = State.FILLING_MILK;
                System.out.println("Write how many ml of milk do you want to add: ");
                break;
            case FILLING_MILK:

                this.milk += Integer.parseInt(s);
                this.state = State.FILLING_BEANS;
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                break;
            case FILLING_BEANS:

                this.coffeeBeans += Integer.parseInt(s);
                this.state = State.FILLING_CUPS;
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                break;
            case FILLING_CUPS:

                this.cups += Integer.parseInt(s);
                System.out.println();
                start();
                break;



        }
//        System.out.println("Write how many ml of water do you want to add: ");
//        water += sc.nextInt();
//        System.out.println("Write how many ml of milk do you want to add: ");
//        milk += sc.nextInt();
//        System.out.println("Write how many grams of coffee beans do you want to add: ");
//        coffeeBeans += sc.nextInt();
//        System.out.println("Write how many disposable cups of coffee do you want to add: ");
//        cups += sc.nextInt();

    }
    private void showRemaining() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.coffeeBeans + " of coffee beans");
        System.out.println(this.cups + " of disposable cups");
        System.out.println(this.money + " of money");
        System.out.println();
    }

    private void take() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
        System.out.println();
    }
}
