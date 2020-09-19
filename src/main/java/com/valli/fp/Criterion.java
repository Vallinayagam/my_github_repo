package com.valli.fp;

/**
 * The concept of passing behaviour to a function via passing an object is not something new.  This is called
 * COMMAND Pattern (Read documentation further), which has been documented in Gof4 DP book.
 * Command Pattern finds heavy usage in functional programming paradigm
 */
@FunctionalInterface
interface Criterion<E> {
    boolean test(E element);

    public static <E> Criterion<E> negate(Criterion<E> criterion) {
        return x -> !criterion.test(x);
    }

    public static <E> Criterion<E> and(Criterion<E> first, Criterion<E> second){
        return x -> first.test(x) && second.test(x);
    }

    public static <E> Criterion<E> or(Criterion<E> first, Criterion<E> second){
        return x -> first.test(x) || second.test(x);
    }
}
