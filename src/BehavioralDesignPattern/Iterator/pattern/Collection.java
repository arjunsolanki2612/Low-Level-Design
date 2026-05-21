package BehavioralDesignPattern.Iterator.pattern;

public interface Collection <T>{
    Iterator<T> createIterator();
}
