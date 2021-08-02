package mz.alfredo.calculatorapi.model;

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
