package mytrader.price;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by rajatkumar on 01/06/2020.
 */
public class DefaultPriceSource implements PriceSource {
    private final List<PriceListener> priceListeners = new ArrayList<>();

    @Override
    public void addPriceListener(final PriceListener listener) {
        priceListeners.add(listener);
    }

    @Override
    public void removePriceListener(final PriceListener listener) {
        priceListeners.remove(listener);

    }

    public void updateStock(final String securityName, final double price) {
        priceListeners.forEach(new Consumer<PriceListener>() {
            @Override
            public void accept(final PriceListener priceListener) {
                priceListener.priceUpdate(securityName, price);
            }
        });

    }
}
