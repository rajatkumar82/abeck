package mytrader.price;

import mytrader.execution.DefaultExecutionService;
import mytrader.execution.ExecutionService;

/**
 * Created by rajatkumar on 01/06/2020.
 */
public class DefaultPriceListener implements PriceListener {
    private ExecutionService executionService = new DefaultExecutionService();

    private final double threshold = 50.00;
    
    @Override
    public void priceUpdate(final String security, final double price) {

        if ("IBM".equalsIgnoreCase(security)) {
            if (price <= threshold) {
                executionService.buy(security, price, 100);
            }
        }
    }
}
