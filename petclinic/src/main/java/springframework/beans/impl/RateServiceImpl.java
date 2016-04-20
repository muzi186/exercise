package springframework.beans.impl;

import springframework.beans.RateService;
import springframework.modules.Currency;
import springframework.modules.Rate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibm on 2016/2/24.
 */
public class RateServiceImpl implements RateService {
    private List<Rate> rates = new ArrayList<Rate>();

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    @Override
    public BigDecimal retrieveRate(Currency from, Currency to) {
        Rate rate = identifyRate(from, to);
        return rate == null ? new BigDecimal("0") : rate.getRate();
    }

    public Rate identifyRate(Currency from, Currency to) {
        if (rates == null || rates.isEmpty()) {
            return null;
        }

        Rate expectedRate = null;
        for (Rate r : rates) {
            if (r.getFrom().equals(from) && r.getTo().equals(to)) {
                expectedRate = r;
                break;
            }
        }

        return expectedRate;
    }
}
