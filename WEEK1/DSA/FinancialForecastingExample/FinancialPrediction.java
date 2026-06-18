import java.util.Scanner;

public class FinancialPrediction {

    // Recursive method for future value prediction
    public static double calculateFutureAmount(double currentAmount,
                                               double annualGrowth,
                                               int period) {

        if (period == 0) {
            return currentAmount;
        }

        return calculateFutureAmount(
                currentAmount,
                annualGrowth,
                period - 1
        ) * (1 + annualGrowth / 100);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Current Investment Amount: ");
        double currentAmount = sc.nextDouble();

        System.out.print("Enter Annual Growth Rate (%): ");
        double annualGrowth = sc.nextDouble();

        System.out.print("Enter Number of Years: ");
        int period = sc.nextInt();

        double predictedValue =
                calculateFutureAmount(currentAmount,
                                      annualGrowth,
                                      period);

        System.out.printf(
                "\nPredicted Future Value after %d years = %.2f",
                period,
                predictedValue
        );

        sc.close();
    }
}