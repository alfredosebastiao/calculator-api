package mz.alfredo.calculatorapi.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Request Output POJO used to return the Request Result
 * @author alfredosebastiao
 */
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
