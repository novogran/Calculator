package novogran.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    TextView textView;
    Button delete,division,seven,eight,nine,multiply,four,five,six,minus,one,two,three,plus,zero,dot,equality,openBracket,closeBracket,btnA,
    btnB,btnC,btnD,btnE,btnF;
    boolean checkPoint = true;
    int openSkobka = 0;
    int closeSkobka = 0;
    String result;
    int otvet;
    int otvetHex;
    double s;
    int system = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(this);
        delete.setOnLongClickListener(this);

        division = (Button) findViewById(R.id.division);
        division.setOnClickListener(this);

        openBracket = (Button) findViewById(R.id.openBracket);
        openBracket.setOnClickListener(this);

        closeBracket = (Button) findViewById(R.id.closeBracket);
        closeBracket.setOnClickListener(this);

        seven = (Button) findViewById(R.id.seven);
        seven.setOnClickListener(this);

        eight = (Button) findViewById(R.id.eight);
        eight.setOnClickListener(this);

        nine = (Button) findViewById(R.id.nine);
        nine.setOnClickListener(this);

        multiply = (Button) findViewById(R.id.multiply);
        multiply.setOnClickListener(this);

        four = (Button) findViewById(R.id.four);
        four.setOnClickListener(this);

        five = (Button) findViewById(R.id.five);
        five.setOnClickListener(this);

        six = (Button) findViewById(R.id.six);
        six.setOnClickListener(this);

        minus = (Button) findViewById(R.id.minus);
        minus.setOnClickListener(this);

        one = (Button) findViewById(R.id.one);
        one.setOnClickListener(this);

        two = (Button) findViewById(R.id.two);
        two.setOnClickListener(this);

        three = (Button) findViewById(R.id.three);
        three.setOnClickListener(this);

        plus = (Button) findViewById(R.id.plus);
        plus.setOnClickListener(this);

        zero = (Button) findViewById(R.id.zero);
        zero.setOnClickListener(this);

        dot = (Button) findViewById(R.id.dot);
        dot.setOnClickListener(this);

        equality = (Button) findViewById(R.id.equally);
        equality.setOnClickListener(this);

        if(findViewById(R.id.btnA)!=null || findViewById(R.id.btnB)!=null ||
                findViewById(R.id.btnC)!=null || findViewById(R.id.btnD)!=null) {
            btnA = (Button) findViewById(R.id.btnA);
            btnA.setOnClickListener(this);

            btnB = (Button) findViewById(R.id.btnB);
            btnB.setOnClickListener(this);

            btnC = (Button) findViewById(R.id.btnC);
            btnC.setOnClickListener(this);

            btnD = (Button) findViewById(R.id.btnD);
            btnD.setOnClickListener(this);

            btnE = (Button) findViewById(R.id.btnE);
            btnE.setOnClickListener(this);

            btnF = (Button) findViewById(R.id.btnF);
            btnF.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radioButtonBin:
                zero.setEnabled(true);
                one.setEnabled(true);
                two.setEnabled(false);
                three.setEnabled(false);
                four.setEnabled(false);
                five.setEnabled(false);
                six.setEnabled(false);
                seven.setEnabled(false);
                eight.setEnabled(false);
                nine.setEnabled(false);
                dot.setEnabled(false);
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setEnabled(false);
                btnE.setEnabled(false);
                btnF.setEnabled(false);
                if (textView.getText().toString().isEmpty()) {
                    system = 2;
                    return;
                }
                if(system == 8){
                    int h = Integer.parseInt(textView.getText().toString(),8);
                    textView.setText(""+Integer.toString(h,2));
                }
                else if(system == 10){
                    int h = Integer.parseInt(textView.getText().toString());
                    textView.setText(""+Integer.toString(h,2));

                }
                else if(system == 16){
                    BigInteger h = new BigInteger(textView.getText().toString(),16);
                    int g = h.intValue();
                    textView.setText(""+Integer.toBinaryString(g));
                }
                system = 2;
                break;
            case R.id.radioButtonOct:
                zero.setEnabled(true);
                one.setEnabled(true);
                two.setEnabled(true);
                three.setEnabled(true);
                four.setEnabled(true);
                five.setEnabled(true);
                six.setEnabled(true);
                seven.setEnabled(true);
                eight.setEnabled(false);
                nine.setEnabled(false);
                dot.setEnabled(false);
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setEnabled(false);
                btnE.setEnabled(false);
                btnF.setEnabled(false);
                if (textView.getText().toString().isEmpty()) {
                    system = 8;
                    return;
                }
                if(system == 2){
                    int h = Integer.parseInt(textView.getText().toString(),2);
                    textView.setText(""+Integer.toString(h,8));
                }
                else if(system == 10){
                    int h = Integer.parseInt(textView.getText().toString());
                    textView.setText(""+Integer.toString(h,8));

                }
                else if(system == 16){
                    BigInteger h = new BigInteger(textView.getText().toString(),16);
                    int g = h.intValue();
                    textView.setText(""+Integer.toString(g,8));
                }
                system = 8;
                break;
            case R.id.radioButtonDec:
                zero.setEnabled(true);
                one.setEnabled(true);
                two.setEnabled(true);
                three.setEnabled(true);
                four.setEnabled(true);
                five.setEnabled(true);
                six.setEnabled(true);
                seven.setEnabled(true);
                eight.setEnabled(true);
                nine.setEnabled(true);
                dot.setEnabled(true);
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setEnabled(false);
                btnE.setEnabled(false);
                btnF.setEnabled(false);
                if (textView.getText().toString().isEmpty()) {
                    system = 10;
                    return;
                }
                if(system == 2){
                    int h = Integer.parseInt(textView.getText().toString(),2);
                    textView.setText(""+Integer.toString(h));
                }
                else if(system == 8){
                    int h = Integer.parseInt(textView.getText().toString(),8);
                    textView.setText(""+Integer.toString(h));

                }
                else if(system == 16){
                    BigInteger h = new BigInteger(textView.getText().toString(),16);
                    int g = h.intValue();
                    textView.setText(""+Integer.toString(g));
                }
                system = 10;
                break;
            case R.id.radioButtonHex:
                zero.setEnabled(true);
                one.setEnabled(true);
                two.setEnabled(true);
                three.setEnabled(true);
                four.setEnabled(true);
                five.setEnabled(true);
                six.setEnabled(true);
                seven.setEnabled(true);
                eight.setEnabled(true);
                nine.setEnabled(true);
                dot.setEnabled(false);
                btnA.setEnabled(true);
                btnB.setEnabled(true);
                btnC.setEnabled(true);
                btnD.setEnabled(true);
                btnE.setEnabled(true);
                btnF.setEnabled(true);
                if (textView.getText().toString().isEmpty()) {
                    system = 16;
                    return;
                }
                if(system == 2){
                    BigInteger h = new BigInteger(textView.getText().toString(),2);
                    int g = h.intValue();
                    textView.setText(""+Integer.toString(g,16));
                }
                else if(system == 8){
                    BigInteger h = new BigInteger(textView.getText().toString(),8);
                    int g = h.intValue();
                    textView.setText(""+Integer.toString(g,16));

                }
                else if(system == 10){
                    BigInteger h = new BigInteger(textView.getText().toString());
                    int g = h.intValue();
                    textView.setText(""+Integer.toString(g,16));
                }
                system = 16;
                break;
            case R.id.btnA:
                textView.setText(textView.getText().toString() + "a");
                break;
            case R.id.btnB:
                textView.setText(textView.getText().toString() + "b");
                break;
            case R.id.btnC:
                textView.setText(textView.getText().toString() + "c");
                break;
            case R.id.btnD:
                textView.setText(textView.getText().toString() + "d");
                break;
            case R.id.btnE:
                textView.setText(textView.getText().toString() + "e");
                break;
            case R.id.btnF:
                textView.setText(textView.getText().toString() + "f");
                break;
            case R.id.openBracket:
                openSkobka++;
                if(!isEnded() && !textView.getText().toString().isEmpty() && !textView.getText().toString().endsWith("("))
                    textView.setText(textView.getText().toString() + "*(");
                else
                textView.setText(textView.getText().toString() + "(");
                break;
            case R.id.closeBracket:
                if(textView.getText().toString().endsWith("(") || isEnded())
                    return;
                if (openSkobka == 0)
                    return;
                else if (closeSkobka < openSkobka) {
                    closeSkobka++;
                    textView.setText(textView.getText().toString() + ")*");
                }
                break;
            case R.id.delete:
                if (textView.getText().toString().endsWith(".")) {
                    checkPoint = true;
                }
                if (isEnded()) {
                    if (checkPoint)
                        checkPoint = true;
                    else if (!checkPoint)
                        checkPoint = false;
                }
                if (textView.getText().toString().isEmpty()) {
                    return;
                }
                textView.setText(textView.getText().toString().substring(0, textView.length() - 1));
                break;
            case R.id.division:
                checkPoint = true;
                if (textView.getText().toString().endsWith(".")) {
                    return;
                }
                if (isEnded() || textView.getText().toString().isEmpty() || textView.getText().toString().endsWith("(")) {
                    return;
                }
                textView.setText(textView.getText().toString() + "/");
                break;
            case R.id.seven:
                textView.setText(textView.getText().toString() + "7");
                checkZeroBegin(textView.getText().toString());
                break;
            case R.id.eight:
                textView.setText(textView.getText().toString() + "8");
                checkZeroBegin(textView.getText().toString());
                break;
            case R.id.nine:
                textView.setText(textView.getText().toString() + "9");
                checkZeroBegin(textView.getText().toString());
                break;
            case R.id.multiply:
                checkPoint = true;
                if (textView.getText().toString().endsWith(".")) {
                    return;
                }
                if (isEnded() || textView.getText().toString().isEmpty() || textView.getText().toString().endsWith("(")) {
                    return;
                }
                textView.setText(textView.getText().toString() + "*");
                break;
            case R.id.four:
                textView.setText(textView.getText().toString() + "4");
                checkZeroBegin(textView.getText().toString());
                break;
            case R.id.five:
                textView.setText(textView.getText().toString() + "5");
                checkZeroBegin(textView.getText().toString());
                break;
            case R.id.six:
                textView.setText(textView.getText().toString() + "6");
                checkZeroBegin(textView.getText().toString());
                break;
            case R.id.minus:
                checkPoint = true;
                if (textView.getText().toString().endsWith(".")) {
                    return;
                }
                if (isEnded() || textView.getText().toString().isEmpty() || textView.getText().toString().endsWith("(")) {
                    return;
                }
                textView.setText(textView.getText().toString() + "-");
                break;
            case R.id.one:
                textView.setText(textView.getText().toString() + "1");
                checkZeroBegin(textView.getText().toString());
                break;
            case R.id.two:
                textView.setText(textView.getText().toString() + "2");
                checkZeroBegin(textView.getText().toString());
                break;
            case R.id.three:
                textView.setText(textView.getText().toString() + "3");
                checkZeroBegin(textView.getText().toString());
                break;
            case R.id.plus:
                checkPoint = true;
                if (textView.getText().toString().endsWith(".")) {
                    return;
                }
                if (isEnded() || textView.getText().toString().isEmpty() || textView.getText().toString().endsWith("(")) {
                    return;
                }
                textView.setText(textView.getText().toString() + "+");
                break;
            case R.id.zero:
                if (textView.getText().equals("0")) {
                    return;
                }
                textView.setText(textView.getText().toString() + "0");
                break;
            case R.id.dot:
                if (isEnded() || textView.getText().toString().isEmpty()) {
                    return;
                }
                if (textView.getText().toString().endsWith(".")) {
                    return;
                }
                if (checkPoint) {
                    textView.setText(textView.getText().toString() + ".");
                }
                checkPoint = false;
                break;
            case R.id.equally:
                if (textView.getText().toString().isEmpty() || textView.getText().toString().endsWith("(") || isEnded()) {
                    return;
                }
                for (int i = 0; i < textView.length(); i++) {
                    if ((textView.getText().charAt(i) == '/' && textView.getText().charAt(i + 1) == '0' &&
                            textView.getText().charAt(i + 2) != '.') || textView.getText().toString().endsWith("/0")) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    }
                }
                if(system==16) {
                    BigInteger s = evalHex(textView.getText().toString());
                    otvetHex = s.intValue();
                    textView.setText(""+Integer.toHexString(otvetHex));
                }
                else
                    s = eval(textView.getText().toString());
                    otvet = (int)s;
                if(system == 2){
                    textView.setText(""+Integer.toBinaryString(otvet));
                }
                else if(system == 8){
                    textView.setText(""+Integer.toString(otvet,8));

                }
                else if(system == 10){
                    textView.setText(""+s);
                }
                if (textView.getText().toString().endsWith(".0")) {
                    textView.setText(textView.getText().toString().substring(0, textView.length() - 2));
                }
                if (textView.getText().toString().contains("E")) {
                    double value = Double.parseDouble(textView.getText().toString());
                    NumberFormat formatter = new DecimalFormat("###.###########################");
                    result = formatter.format(value);
                    result = result.replace(',', '.');
                    textView.setText("" + result);
                }
                break;
        }
    }
    @Override
    public boolean onLongClick(View v) {
        checkPoint = true;
        textView.setText("");
        return true;
    }

    public boolean isEnded() {
        return textView.getText().toString().endsWith("/") ||
                textView.getText().toString().endsWith("*") ||
                textView.getText().toString().endsWith("+") ||
                textView.getText().toString().endsWith("-");
    }

    boolean isDelim(char c) {
        return c == ' ';
    }

    boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }
    void processOperator(LinkedList<Double>st, char op) {
        double r = st.removeLast();
        double l = st.removeLast();
        int m = (int)r;
        int n = (int)l;
        double c = 0,d = 0;
        if(system==2){
            double a,b;
            a = Integer.parseInt(String.valueOf(m),2);
            b = Integer.parseInt(String.valueOf(n),2);
            c = b;
            d = a;
        }
        else if(system==8){
            double a,b;
            a = Integer.parseInt(String.valueOf(m),8);
            b = Integer.parseInt(String.valueOf(n),8);
            c = b;
            d = a;
        }
        else if(system==10){
            c = l;
            d = r;
        }
        else if(system==16){
            BigInteger a,b;
            a = new BigInteger(String.valueOf(m),16);
            b = new BigInteger(String.valueOf(n),16);
            c = b.doubleValue();
            d = a.doubleValue();
        }
        switch (op) {
            case '+':
                st.add(c + d);
                break;
            case '-':
                st.add(c - d);
                break;
            case '*':
                st.add(c * d);
                break;
            case '/':
                st.add(c / d);
                break;
        }
    }

    public double eval(String s) {
        LinkedList<Double> st = new LinkedList<>();
        LinkedList<Character> op = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
                if (isDelim(c))
                    continue;
                if (c == '(')
                    op.add('(');
                else if (c == ')') {
                    while (op.getLast() != '(')
                        processOperator(st, op.removeLast());
                    op.removeLast();
                } else if (isOperator(c)) {
                    while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                        processOperator(st, op.removeLast());
                        op.add(c);
                } else {
                    String operand = "";
                    while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.'))
                        operand += s.charAt(i++);
                        --i;
                        st.add(Double.parseDouble(operand));
                }
            }
        while (!op.isEmpty())
            processOperator(st, op.removeLast());
        return st.get(0);
    }

    public void checkZeroBegin(String s) {
        if(system!=10){
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(0) == '0' && !isOperator(s.charAt(1)) && s.charAt(1)!='.') {
                textView.setText(textView.getText().toString().substring(1));
                return;
            }
            if (isOperator(s.charAt(i)) && s.charAt(i + 1) == '0') {
                if (s.charAt(s.length()-2)!='.' && !isOperator(s.charAt(s.length()-2))) {
                    textView.setText(s.substring(0, i + 1) + s.substring(s.length() - 1));
                    return;
                }
                return;
            }
        }
    }

    void processOperatorHex(LinkedList<BigInteger> str, char op) {
        BigInteger r = str.removeLast();
        BigInteger l = str.removeLast();
        long c, d;
        BigInteger a, b;
        a = new BigInteger(String.valueOf(r));
        b = new BigInteger(String.valueOf(l));
        c = b.longValue();
        d = a.longValue();
        switch (op) {
            case '+':
                str.add(BigInteger.valueOf(c + d));
                break;
            case '-':
                str.add(BigInteger.valueOf(c - d));
                break;
            case '*':
                str.add(BigInteger.valueOf(c * d));
                break;
            case '/':
                str.add(BigInteger.valueOf(c / d));
                break;
        }
    }
    public BigInteger evalHex(String s) {
        LinkedList<BigInteger> str = new LinkedList<>();
        LinkedList<Character> op = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDelim(c))
                continue;
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperatorHex(str, op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    processOperatorHex(str, op.removeLast());
                op.add(c);
            } else {
                String operand = "";
                while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == 'a' || s.charAt(i) == 'b'
                        || s.charAt(i) == 'c' || s.charAt(i) == 'd' || s.charAt(i) == 'e' || s.charAt(i) == 'f' ))
                    operand += s.charAt(i++);
                --i;
                str.add(new BigInteger(operand,16));
            }
        }
        while (!op.isEmpty())
            processOperatorHex(str, op.removeLast());
        return str.get(0);
    }
}