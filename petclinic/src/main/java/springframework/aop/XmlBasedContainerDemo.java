package springframework.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springframework.beans.RateService;
import springframework.modules.Currency;

import java.math.BigDecimal;

/**
 * Created by ibm on 2016/2/25.
 */
public class XmlBasedContainerDemo {
    public static void main(String...args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/aop/rateService.xml");
        RateService rs = ctx.getBean("rateService", RateService.class);

        BigDecimal rate = rs.retrieveRate(new Currency(1,"USD"), new Currency(2,"CNY"));

        System.out.println(rate);
    }
}
