package Operators;

public class PowerOperator extends Operator {
    @Override
    public int priority() {
        return 4;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        Operand result = new Operand( (int) Math.pow(op2.getValue(), op1.getValue()));
        return result;
    }
}
