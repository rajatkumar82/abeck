import org.junit.Assert;
import org.junit.Test;

import mytrader.execution.DefaultExecutionService;

public class DefaultExecutionServiceTest {

    @Test
    public void testBuy() {
        String security = "IBM";
        double price = 51.00;
        int volume = 100;
        DefaultExecutionService service = new DefaultExecutionService();
        service.buy(security, price, volume);
        //Assert that 100 IBM shares are bought
        Assert.assertTrue(service.getBoughtStocks().containsKey(security));
        Assert.assertEquals(100, service.getBoughtStocks().get(security).getVolume());
        
        //Execute 1 more buying request
        service.buy(security, price, volume);
        
        //No addition to volume as single buy request
        Assert.assertEquals(100, service.getBoughtStocks().get(security).getVolume());
    }
    
    @Test
    public void testSell() {
        String security = "IBM";
        double price = 50.00;
        int volume = 100;
        DefaultExecutionService service = new DefaultExecutionService();
        service.sell(security, price, volume);
        //Assert that 100 IBM shares are bought
        Assert.assertTrue(service.getSoldStocks().containsKey(security));
        Assert.assertEquals(100, service.getSoldStocks().get(security).getVolume());
        
        //Execute 1 more buying request
        service.sell(security, price, volume);
        
        //No more selling allowed as there is single sell request
        Assert.assertEquals(100, service.getSoldStocks().get(security).getVolume());
    }
}