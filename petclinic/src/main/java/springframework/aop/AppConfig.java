package springframework.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springframework.beans.RateService;
import springframework.beans.impl.RateServiceImpl;
import springframework.modules.Currency;
import springframework.modules.Rate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibm on 2016/2/24.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "springframework.aop")
public class AppConfig {
    @Bean(name="rateService")
    public RateService getRateService() {
        Currency usd = new Currency(1, "USD");
        Currency cny = new Currency(2, "CNY");
        Currency hkd = new Currency(3, "HKD");

        List<Rate> rates = new ArrayList<Rate>();
        rates.add(new Rate(usd, cny, new BigDecimal("10.0000011111888888")));
        rates.add(new Rate(hkd, cny, new BigDecimal("0.8")));


        RateServiceImpl rateService = new RateServiceImpl();
        rateService.setRates(rates);

        return rateService;
    }

    @Bean(name="performanceLoggingAspect")
    public PerformanceLoggingAspect getPerformanceLoggingAspect(){
        return new PerformanceLoggingAspect();
    }
}
