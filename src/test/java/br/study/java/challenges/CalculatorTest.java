package br.study.java.challenges;

import junit.framework.TestCase;

/**
 * The goal test the implementation of the simple calculator which uses fluent syntax:
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

public class CalculatorTest extends TestCase{

    public void testNullOperator() {
        int result = Calculator.getInstance().one().two().two().exec();
        assertEquals(0, result);
    }

    public void testNullArguments() {
        int result = Calculator.getInstance().plus().exec();
        assertEquals(0, result);
    }

    public void testOnePlusTwo() {
        int result = Calculator.getInstance().one().plus().two().exec();
        assertEquals(3, result);
    }

    public void testFiveMinusSix() {
        int result = Calculator.getInstance().five().minus().six().exec();
        assertEquals(-1, result);

    }

    public void testSevenTimesTwo() {
        int result = Calculator.getInstance().seven().times().two().exec();
        assertEquals(14, result);
    }

    public void testNineDivided_byThree() {
        int result = Calculator.getInstance().nine().divided_by().three().exec();
        assertEquals(3, result);
    }

    public void testMoreThenTwoArgumentsInstance2() {
        int result = Calculator.getInstance().one().plus().two().three().exec();
        assertEquals(3, result);
    }

    public void testMoreThenTwoArgumentsInstance3() {
        int quantityArguments = 3;
        int result = Calculator.getInstance(quantityArguments).one().plus().two().three().exec();
        assertEquals(6, result);
    }

}
