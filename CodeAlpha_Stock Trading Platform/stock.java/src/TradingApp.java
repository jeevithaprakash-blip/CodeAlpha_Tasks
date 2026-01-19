import java.util.ArrayList;
import java.util.Scanner;

public class TradingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        User user = new User("Investor", 10000);

        ArrayList<Stockkk> market = new ArrayList<>();
        market.add(new Stockkk("AAPL", 150));
        market.add(new Stockkk("GOOG", 2800));
        market.add(new Stockkk("TSLA", 700));

        while (true) {
            System.out.println("\n--- Stock Trading Platform ---");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    System.out.println("\nMarket Data:");
                    for (int i = 0; i < market.size(); i++) {
                        Stockkk s = market.get(i);
                        System.out.println(
                            (i + 1) + ". " + s.getSymbol() +
                            " - ₹" + s.getPrice()
                        );
                    }
                }

                case 2 -> {
                    System.out.print("Select stock number: ");
                    int index = sc.nextInt() - 1;

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();

                    user.buyStockkk(market.get(index), qty);
                }

                case 3 -> {
                    System.out.print("Select stock number: ");
                    int index = sc.nextInt() - 1;

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();

                    user.sellStock(market.get(index), qty);
                }

                case 4 -> user.displayPortfolio();

                case 5 -> {
                    System.out.println("Exiting Trading Platform...");
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
