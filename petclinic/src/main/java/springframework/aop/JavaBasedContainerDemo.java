package springframework.aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springframework.beans.RateService;
import springframework.modules.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by ibm on 2016/2/24.
 */
public class JavaBasedContainerDemo {

    public static void main(String... args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        RateService rateService = ctx.getBean("rateService", RateService.class);

        System.out.println(rateService.getClass());

        BigDecimal rate = rateService.retrieveRate(new Currency(1,"USD"), new Currency(2,"CNY"));


        System.out.println(rate.doubleValue());

        rate.setScale(8, RoundingMode.HALF_UP);
        System.out.println(rate.doubleValue());
    }
}
