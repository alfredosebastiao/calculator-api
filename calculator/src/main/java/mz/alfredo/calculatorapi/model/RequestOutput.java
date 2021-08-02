package mz.alfredo.calculatorapi.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@ToString
public class RequestOutput implements Serializable {
    private BigDecimal result;

    public RequestOutput(BigDecimal result) {
        this.result = result;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }
}
