// Arup Guha
// 4/2/2013
// Solution to 2013 FHSPS Playoff Question: Stock

import java.util.*;

public class stock {

	private double[][] prices;
	private double fee;

	public stock(double myFee, double[][] stocks) {
		fee = myFee;
		prices = stocks;
	}

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();

		// Go through cases.
		for (int loop=1; loop<=numCases; loop++) {

			// Get all the stock data.
			int numDays = stdin.nextInt();
			double transFee = stdin.nextDouble();
			double myMoney = stdin.nextDouble();
			double[][] stocks = new double[2][numDays];

			// Read in both stock prices.
			for (int i=0; i<2; i++)
				for (int j=0; j<numDays; j++)
					stocks[i][j] = stdin.nextDouble();

			stock google = new stock(transFee, stocks);

			// Solve and print.
			System.out.printf("%.2f\n", google.maxCash(myMoney, 0, 0, 0));
		}
	}

	// Solves the problem recursively. Current situations is that you have cash and
	// shares number of stockNum shares on day number day. Returns best possible return.
	public double maxCash(double cash, int shares, int stockNum, int day) {

		// End of period, cash out.
		if (day == prices[0].length-1) {

			// Sell my stock.
			if (shares > 0)
				cash += (shares*prices[stockNum][day] - fee);
			return cash;
		}

		// Options if we have no stock now.
		if (shares == 0) {

			// Stay with no stock.
			double best = maxCash(cash, shares, stockNum, day+1);

			// Try buying either of our two stocks/
			for (int i=0; i<2; i++) {

				int newShares = (int)((cash-fee)/prices[i][day]);
				//System.out.println("I can buy "+newShares+" of stock "+i+" on day "+day);
				double temp = maxCash(cash - newShares*prices[i][day] - fee, newShares, i, day+1);
				if (temp > best)
					best = temp;
			}

			// This is the best we can do.
			return best;
		}

		// We have stock.
		else {
			
			// Option 1: Stay with our current stock.
			double best = maxCash(cash, shares, stockNum, day+1);

			// Option 2: Sell
			double temp = maxCash(cash + shares*prices[stockNum][day] - fee, 0, 0, day+1);
			if (temp > best)
				best = temp;

			// Option 3: Switch stock
			cash = cash + shares*prices[stockNum][day] - fee;
			int newShares = (int)((cash - fee)/prices[1-stockNum][day]);
			temp = maxCash(cash - newShares*prices[1-stockNum][day] - fee, newShares, 1-stockNum, day+1);
			if (temp > best)
				best = temp;

			return best;

		}
	}
}