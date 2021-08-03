package mz.alfredo.calculatorapi.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * RequestInput POJO used to get the request params and operationType
 * @author alfredosebastiao
 */
@Data
@NoArgsConstructor
@ToString
public class RequestInput implements Serializable {
    private String clientId;
    private BigDecimal a;
    private BigDecimal b;
    private String operationType;

    public RequestInput(String clientId, BigDecimal a, BigDecimal b, String operationType) {
        this.clientId = clientId;
        this.a = a;
        this.b = b;
        this.operationType = operationType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public BigDecimal getB() {
        return b;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
