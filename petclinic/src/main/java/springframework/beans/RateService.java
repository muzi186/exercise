package springframework.beans;

import springframework.modules.Currency;
import springframework.modules.Rate;

import java.math.BigDecimal;

/**
 * Created by ibm on 2016/2/24.
 */

public interface RateService {
    BigDecimal retrieveRate(Currency from, Currency to);
    Rate identifyRate(Currency from, Currency to);
}
