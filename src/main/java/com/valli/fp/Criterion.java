package com.valli.fp;

/**
 * The concept of passing behaviour to a function via passing an object is not something new.  This is called
 * COMMAND Pattern (Read documentation further), which has been documented in Gof4 DP book.
 * Command Pattern finds heavy usage in functional programming paradigm
 */
@FunctionalInterface
interface Criterion<E> {
    boolean test(E element);

    default Criterion<E> negate() {
        return x -> !this.test(x);
    }

    default Criterion<E> and(Criterion<E> second){
        return x -> this.test(x) && second.test(x);
    }

    default Criterion<E> or(Criterion<E> second){
        return x -> this.test(x) || second.test(x);
    }
}
