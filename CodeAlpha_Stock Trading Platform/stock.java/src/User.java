import java.util.HashMap;

class User {
    private String name;
    private double cash;
    private HashMap<String, Integer> portfolio = new HashMap<>();

    public User(String name, double cash) {
        this.name = name;
        this.cash = cash;
    }

    public void buyStockkk(Stockkk stockkk, int quantity) {
        double cost = stockkk.getPrice() * quantity;

        if (cash >= cost) {
            cash -= cost;
            portfolio.put(
                stockkk.getSymbol(),
                portfolio.getOrDefault(stockkk.getSymbol(), 0) + quantity
            );
            System.out.println("Stock purchased successfully!");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void sellStock(Stockkk stockkk, int quantity) {
        int owned = portfolio.getOrDefault(stockkk.getSymbol(), 0);

        if (owned >= quantity) {
            portfolio.put(stockkk.getSymbol(), owned - quantity);
            cash += stockkk.getPrice() * quantity;
            System.out.println("Stock sold successfully!");
        } else {
            System.out.println("Not enough stocks to sell.");
        }
    }

    public void displayPortfolio() {
        System.out.println("\nPortfolio:");
        portfolio.forEach((k, v) ->
            System.out.println("Stock: " + k + " | Quantity: " + v)
        );
        System.out.println("Cash Balance: ₹" + cash);
    }
}
