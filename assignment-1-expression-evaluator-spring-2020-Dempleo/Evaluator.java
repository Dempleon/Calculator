import Operators.Operand;
import Operators.Operator;

import java.util.*;

public class Evaluator {
  private Stack<Operand> operandStack;
  private Stack<Operator> operatorStack;

  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "+-*^/() ";

  public Evaluator() {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }

  public int eval( String expression ) {
    String token;

    this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );

    while ( this.tokenizer.hasMoreTokens() ) {
      // filter out spaces
      if ( !( token = this.tokenizer.nextToken() ).equals( " " )) {
        // check if token is an operand
        if ( Operand.check( token )) {
          operandStack.push( new Operand( token ));
        } else {
          if ( ! Operator.check( token )) {
            System.out.println( "*****invalid token******" );
            System.exit( 1 );
          }

          Operator newOperator = Operator.getOperator(token);

          if(token.equals("(")){
            operatorStack.push(newOperator);
            continue;
          }
          // if token = ) dont push to stack, process stack until ( then pop
          if(token.equals(")")){
            while (operatorStack.peek().priority() != 0) {
              process();
            }
            operatorStack.pop();
            continue;
          }

          if (!operatorStack.isEmpty()) {
            if (operatorStack.peek().priority() < newOperator.priority()) {
              operatorStack.push(newOperator);
              continue;
            }
            //loop to process the stack as long as its not empty
            while (!operatorStack.isEmpty()){
              if (operatorStack.peek().priority() >= newOperator.priority()) {
                process();
              }
              else {
                break;
              }
            }
          }

          operatorStack.push( newOperator );
        }
      }
    }

    // when the entire expression is tokenized, loop to process
    while(!operatorStack.isEmpty()){
      process();
    }


    return operandStack.pop().getValue();
  }

  // Method to process the stack
  private void process(){
    Operand operand1 = operandStack.pop();
    Operand operand2 = operandStack.pop();
    Operator operator = operatorStack.pop();
    operandStack.push(operator.execute(operand1, operand2));
  }

}


