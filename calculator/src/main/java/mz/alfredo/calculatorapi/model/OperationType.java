package mz.alfredo.calculatorapi.model;

/**
 * ENUM that represents REST operations available
 * @author alfredosebastiao
 */
public enum OperationType {

    SUM("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("x"),
    DIVIDE("/");

    private final String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
