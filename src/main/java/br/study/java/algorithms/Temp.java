package br.study.java.algorithms;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToLongFunction;
import java.util.function.LongSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class Temp {

	public static void main (String[] args) {
		
		testFunction() ;
		
	}
	
	private static void testFunction() {
		
		Function<String, Integer> f = (s) -> s.length();
		System.out.println(f.apply("teste"));
		
		// IntFunction, LingFunction, DoubleFunction
		IntFunction<String> iF = (i) -> "i: "+ i;
		System.out.println(iF.apply(10));
		
		// ToDoubleFunction, ToLongFunction
		ToIntFunction<String> i  = (x)-> Integer.parseInt(x);
	    System.out.println(i.applyAsInt("2"));
	    
	    // IntToLongFunction, LongToDoubleFunction, IntToDoubleFunction
	    IntToLongFunction itl = (x) -> Long.MAX_VALUE-x;
	    System.out.println(itl.applyAsLong(2));
	    
	    // Special type - Function
	    UnaryOperator<String> up  = (x)-> x.toUpperCase();
	    System.out.println(up.apply("teste"));
	    
	    // Special type - BiFunction
	    BinaryOperator<String> bo = (x, y) -> x.concat(y); 
	    System.out.println(bo.apply("teste", "New"));
		
	}
	
	private static void testConsumer() {
		
		Consumer<Integer> c = (t) -> System.out.println(t);
		c.accept(10);
		
		IntConsumer ic = (t) -> System.out.println(t * 3);
		ic.accept(10);
		
		// LongConsumer, DoubleConsumer
		
		IntConsumer ic2 = (t) -> System.out.println(t - 3);
		ic2.andThen(ic).accept(10);
		
		BiConsumer<Integer, Integer> biC = (t,u) -> System.out.println(t - u);
		biC.accept(3, 10);
		
	}
	
	private static void testPredicate() {
		
		Predicate<String> p = (t) -> t.length()<10;
		System.out.println(p.test("teste"));
		
		IntPredicate ip = (t) -> t < 10;
		System.out.println(ip.test(4));
		
		// LongPredicate, DoublePredicate 
		
		// default - and, or, negate
		System.out.println(p.negate());
		
		// static method
		System.out.println(Predicate.isEqual(ip));
		
		BiPredicate<Integer, Integer> bp = (t,u) -> t%u == 0;
		System.out.println(bp.test(10, 5));
	}
	private static void testSupplier() {
		String t = "One";
		// T get()
		Supplier<String> s = () -> t.toUpperCase();
		System.out.println(s.get());
		
		Integer one = 1;
		// T get()
		IntSupplier is = () -> one+1;
		System.out.println(is.getAsInt());
		
		Long two = 2L;
		// T get()
		LongSupplier ls = () -> two+1;
		System.out.println(ls.getAsLong());
		
		BooleanSupplier bs = () -> two > 1L;
		System.out.println(bs.getAsBoolean());
		
		// BooleanSupplier, DoubleSupplier
	}
}
