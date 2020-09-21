//package com.valli.fp;
//
///**
// * The concept of passing behaviour to a function via passing an object is not something new.  This is called
// * COMMAND Pattern (Read documentation further), which has been documented in Gof4 DP book.
// * Command Pattern finds heavy usage in functional programming paradigm
// */
//@FunctionalInterface
//interface Predicate<E> {
//    boolean test(E element);
//
//    default Predicate<E> negate() {
//        return x -> !this.test(x);
//    }
//
//    default Predicate<E> and(Predicate<E> second){
//        return x -> this.test(x) && second.test(x);
//    }
//
//    default Predicate<E> or(Predicate<E> second){
//        return x -> this.test(x) || second.test(x);
//    }
//}
