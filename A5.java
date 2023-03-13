import java.util.*;

public class A5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of locations for production and consumption:");
        int n = input.nextInt();
        int minProductionCost = Integer.MAX_VALUE;
        int minConsumptionCost = Integer.MAX_VALUE;
        for (int i = 0; i < n * n; i++) {
            System.out.printf("Enter the cost of production and consumption for location (%d,%d): ", i / n + 1,
                    i % n + 1);
            int cost = input.nextInt();
            if (i / n == i % n && cost < minProductionCost) {
                minProductionCost = cost;
            }
            if (i / n != i % n && cost < minConsumptionCost) {
                minConsumptionCost = cost;
            }
        }
        int optimizedPrice = Math.min(minProductionCost, minConsumptionCost);
        System.out.println("The optimized price of the product is: " + optimizedPrice);
        input.close();
    }
}