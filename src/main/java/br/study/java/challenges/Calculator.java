package br.study.java.challenges;

/**
 * The goal is to implement simple calculator which uses fluent syntax:
 *
 * Calc.new.one.plus.two # Should return 3 <br />
 * Calc.new.five.minus.six # Should return ­1 <br />
 * Calc.new.seven.times.two # Should return 14 <br />
 * Calc.new.nine.divided_by.three # Should return 3 <br />
 *
 * There are only four operations that are supported (plus, minus, times, divided_by) and 10 digits (zero, one, two,
 * three, four, five, six, seven, eight, nine).
 *
 * Each calculation consists of one operation only.
 *
 * @author fabiana.araujo
 *
 */
public class Calculator {

    enum Operator {
        PLUS, MINUS, TIMES, DIVIDED_BY
    }

    private int[] params;
    private int index;
    private Operator operator;

    private Calculator() {

    }

    public static Calculator getInstance(int nuArguments) {
        Calculator calculator = new Calculator();
        calculator.params = new int[nuArguments];
        return calculator;
    }

    public static Calculator getInstance() {
        Calculator calculator = new Calculator();
        calculator.params = new int[2];
        return calculator;
    }

    public Calculator one() {
        addParams(1);
        return this;
    }

    public Calculator two() {
        addParams(2);
        return this;
    }

    public Calculator three() {
        addParams(3);
        return this;
    }

    public Calculator four() {
        addParams(4);
        return this;
    }

    public Calculator five() {
        addParams(5);
        return this;
    }

    public Calculator six() {
        addParams(6);
        return this;
    }

    public Calculator seven() {
        addParams(7);
        return this;
    }

    public Calculator eight() {
        addParams(8);
        return this;
    }

    public Calculator nine() {
        addParams(9);
        return this;
    }

    public Calculator plus() {
        operator = Operator.PLUS;
        return this;
    }

    public Calculator minus() {
        operator = Operator.MINUS;
        return this;
    }

    public Calculator times() {
        operator = Operator.TIMES;
        return this;
    }

    public Calculator divided_by() {
        operator = Operator.DIVIDED_BY;
        return this;
    }

    public int exec() {

        int result = 0;

        if (operator == null) {
            return result;
        }

        switch (operator) {

        case PLUS:
            for (int arg : params) {
                result += arg;
            }
            break;
        case MINUS:
            result = params[0];
            for (int i = 1; i < params.length; i++) {
                result -= params[i];
            }
            break;
        case TIMES:
            result = 1;
            for (int arg : params) {
                result *= arg;
            }
            break;
        case DIVIDED_BY:
            result = params[0];
            for (int i = 1; i < params.length; i++) {
                result = params[i] != 0 ? result / params[1] : 0;
            }
        }

        return result;
    }

    private void addParams(int param) {
        if (index < params.length) {
            params[index++] = param;
        }
    }

}
