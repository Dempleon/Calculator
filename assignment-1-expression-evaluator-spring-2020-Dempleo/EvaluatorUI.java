import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;

public class EvaluatorUI extends JFrame implements ActionListener {
  private TextField txField = new TextField();
  private Panel buttonPanel = new Panel();
  private static Evaluator evaluator = new Evaluator();

  // total of 20 buttons on the calculator,
  // numbered from left to right, top to bottom
  // bText[] array contains the text for corresponding buttons
  private static final String[] bText = {
    "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3",
    "*", "0", "^", "=", "/", "(", ")", "C", "CE"
  };
  private Button[] buttons = new Button[ bText.length ];

  public static void main(String argv[]) {
    EvaluatorUI calc = new EvaluatorUI();
  }

  public EvaluatorUI() {

    setLayout( new BorderLayout() );

    add( txField, BorderLayout.NORTH );
    txField.setEditable( false );

    add( buttonPanel, BorderLayout.CENTER );
    buttonPanel.setLayout( new GridLayout( 5, 4 ));

    //create 20 buttons with corresponding text in bText[] array
    for ( int i = 0; i < 20; i++ ) {
      buttons[ i ] = new Button( bText[ i ]);
    }

    //add buttons to button panel
    for (int i=0; i<20; i++) {
      buttonPanel.add( buttons[ i ]);
    }

    //set up buttons to listen for mouse input
    for ( int i = 0; i < 20; i++ ) {
      buttons[ i ].addActionListener( this );
    }

    setTitle( "Calculator" );
    setSize( 400, 400 );
    setLocationByPlatform( true  );
    setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    setVisible( true );
  }

  public void actionPerformed( ActionEvent arg0 ) {
    // You need to fill in this fuction
    String expression = txField.getText();

    //if the button pressed is an int then append int to the end of the expression
    try {
      int numberPressed = Integer.parseInt(arg0.getActionCommand());
      txField.setText(expression + numberPressed );
    }
    catch (Exception e) {

      switch (arg0.getActionCommand()) {
        case "CE":
          txField.setText("");
          break;
        case "C":
          txField.setText(expression.substring(0, expression.length() - 1));
          break;
        case "+":
          txField.setText(expression + "+");
          break;
        case "-":
          txField.setText(expression + "-");
          break;
        case "*":
          txField.setText(expression + "*");
          break;
        case "/":
          txField.setText(expression + "/");
          break;
        case "(":
          txField.setText(expression + "(");
          break;
        case ")":
          txField.setText(expression + ")");
          break;
        case "^":
          txField.setText(expression + "^");
          break;
        case "=":
          txField.setText(String.valueOf(evaluator.eval(expression)));
          break;
      }
    }
  }
}
