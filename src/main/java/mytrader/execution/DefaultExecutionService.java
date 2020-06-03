package mytrader.execution;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import mytrader.model.Stock;

/**
 * Created by rajatkumar on 01/06/2020.
 */
public class DefaultExecutionService implements ExecutionService {
	
	//We can keep a single map if we have to maintain stock inventory.
	//But we are not doing that for this exercise. So 2 maps.
    public Map<String, Stock> boughtStocks = new ConcurrentHashMap<>();
    public Map<String, Stock> soldStocks = new ConcurrentHashMap<>();

    @Override
    public void buy(final String security, final double price, final int volume) {
        boughtStocks.computeIfAbsent(security, new Function<String, Stock>() {
            @Override
            public Stock apply(final String s) {
                System.out.printf("Buying %d stocks of %s at %f",volume, security, price);
                return new Stock(price, security, volume);
            }
        });
    }

    @Override
    public void sell(final String security, final double price, final int volume) {
        soldStocks.computeIfAbsent(security, new Function<String, Stock>() {
            @Override
            public Stock apply(final String s) {
            	System.out.printf("Selling %d stocks %s at %f",volume, security, price);
                return new Stock(price, security, volume);
            }
        });
    }

	public Map<String, Stock> getBoughtStocks() {
		return boughtStocks;
	}

	public void setBoughtStocks(Map<String, Stock> boughtStocks) {
		this.boughtStocks = boughtStocks;
	}

	public Map<String, Stock> getSoldStocks() {
		return soldStocks;
	}

	public void setSoldStocks(Map<String, Stock> soldStocks) {
		this.soldStocks = soldStocks;
	}
    
    
}
