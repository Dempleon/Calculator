package Operators;

public class Operand {
  private int value;

  public Operand( String token ) {
    this.value = Integer.parseInt(token);
  }

  public Operand( int operand ) {
    this.value = operand;
  }

  public int getValue() {
    return this.value;
  }

  public static boolean check( String token ) {
    try{
      Integer.parseInt(token);
      return true;
    } catch (Exception e){
      return false;
    }
  }
}
