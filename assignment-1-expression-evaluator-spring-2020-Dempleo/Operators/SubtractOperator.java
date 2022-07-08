package Operators;

public class SubtractOperator extends Operator {
    @Override
    public int priority() {
        return 2;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        Operand result = new Operand(op2.getValue() - op1.getValue());
        return result;
    }
}
