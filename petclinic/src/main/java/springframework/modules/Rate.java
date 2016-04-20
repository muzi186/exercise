package springframework.modules;

import java.math.BigDecimal;

/**
 * Created by ibm on 2016/2/24.
 */
public class Rate {
    private Currency from;
    private Currency to;
    private BigDecimal rate;

    public Rate() {
    }

    public Rate(Currency from, Currency to, BigDecimal rate) {
        this.from = from;
        this.to = to;
        this.rate = rate;
    }

    public Currency getFrom() {
        return from;
    }

    public void setFrom(Currency from) {
        this.from = from;
    }

    public Currency getTo() {
        return to;
    }

    public void setTo(Currency to) {
        this.to = to;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }


}
