public class EvaluatorTester {
  public static void main(String[] args) {
    Evaluator evaluator = new Evaluator();

    for ( String arg : args ) {
      System.out.format( "%s = %d\n", arg, evaluator.eval( arg ) );
    }

    String expression1 = "2+3-5*((2-3)*2-5*2+3*(2-3-5-5*6)+4/2)*2-9";
    String expression2 = "3+2-9+8*2 + (3+9-8/2)";
    String expression3 = "3^2 + (2^4) +(4+5)";
    String expression4 = "3^2/2 +(4+5)";
    String expression5 = "3^2/2";
    String expression6 = "3^2";
    String expression7 = "(6-12*2)/3";
    String expression8 = "2-(3/10)+2-5";
    String expression9 = "(1+2)*3";
    String expression10 = "2-(3/10)+2-5";
    String expression11 = "((2-3)*2-5*2+3*(2-3-5-5*6)+4/2)";
    String expression12 = "(2-3)*2-5*2+3*(2-3-5-5*6)";
    String expression13 = "(2-3-5-5*6)";
    String expression14 = "(2-3)*2-5*2";
    String expression15 = "(2-3)*2-5*2-3";

    System.out.println(evaluator.eval(expression1) + ":1176");
    System.out.println(evaluator.eval(expression2) + ":20");
    System.out.println(evaluator.eval(expression3) + ":34");
    System.out.println(evaluator.eval(expression4) + ":13");
    System.out.println(evaluator.eval(expression5) + ":4");
    System.out.println(evaluator.eval(expression6) + ":9");
    System.out.println(evaluator.eval(expression7) + ":-6");
    System.out.println(evaluator.eval(expression8) + ":-1");
    System.out.println(evaluator.eval(expression9) + ":9");
    System.out.println(evaluator.eval(expression10) + ":-1");
    System.out.println(evaluator.eval(expression11) + ":-118");
    System.out.println(evaluator.eval(expression12) + ":-120");
    System.out.println(evaluator.eval(expression13) + ":-36");
    System.out.println(evaluator.eval(expression14) + ":-12");
    System.out.println(evaluator.eval(expression15) + ":-15");


  }
}
