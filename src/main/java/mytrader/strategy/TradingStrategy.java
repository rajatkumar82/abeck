package mytrader.strategy;

import mytrader.price.DefaultPriceListener;
import mytrader.price.DefaultPriceSource;
import mytrader.price.PriceListener;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {
    public static void main(String args[]) {
        PriceListener ibmPriceListener = new DefaultPriceListener();
        DefaultPriceSource priceSource = new DefaultPriceSource();
        priceSource.addPriceListener(ibmPriceListener);
        priceSource.updateStock("IBM",155);
        priceSource.updateStock("IBM",50);
        priceSource.updateStock("IBM",50);
        priceSource.updateStock("IWBM",50);

    }
}
