package br.com.dio.calc;

import java.util.stream.LongStream;

public enum Operation {
    SUM(n -> LongStream.of(n).reduce(0, Long::sum), "+"), 
    SUBTRACTION(n -> LongStream.of(n).reduce(0, (n1, n2) -> n1 - n2), "-");

    private final Calc operationCallback;

    private final String signal;

    private Operation(Calc operationCallback, String signal) {
        this.operationCallback = operationCallback;
        this.signal = signal;
    }

    public Calc getOperationCallback() {
        return operationCallback;
    }

    public String getSignal() {
        return signal;
    }
}
