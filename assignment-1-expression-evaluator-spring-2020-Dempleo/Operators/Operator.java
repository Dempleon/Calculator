package Operators;


import java.util.HashMap;

public abstract class Operator {
  // The Operators.Operator class should contain an instance of a HashMap
  // This map will use keys as the tokens we're interested in,
  // and values will be instances of the Operators.

  // Example:
  // Where does this declaration go? What should its access level be?
  // Class or instance variable? Is this the right declaration?
  // HashMap operators = new HashMap();
  // operators.put( "+", new AdditionOperator() );
  // operators.put( "-", new SubtractionOperator() );

  public abstract int priority();
  public abstract Operand execute(Operand op1, Operand op2 );

  //
  private static HashMap<String, Operator> operatorsMap = new HashMap<String, Operator>() {
    {
      put("+", new AddOperator());
      put("-", new SubtractOperator());
      put("*", new MultiplyOperator());
      put("/", new DivideOperator());
      put("^", new PowerOperator());
      put("(", new LeftPar());
      put(")", new RightPar());
    }
  };

  public static boolean check( String token ) {
    if (operatorsMap.containsKey(token)){
      return true;
    }
    return false;
  }

  //A function to return an operator from the hashmap based on the input token
  static public Operator getOperator(String token) {
    return operatorsMap.get(token);
  }
}
