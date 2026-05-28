package BehavioralDesignPattern.memento.pattern.caretaker;

import BehavioralDesignPattern.memento.pattern.memento.EditorMemento;

import java.util.Stack;

public class HistoryManager {
    private final Stack<EditorMemento> history = new Stack<>();

    public void save(EditorMemento memento){
        history.push(memento);
    }

    public EditorMemento undo(){
        if(history.isEmpty()){
            return null;
        }
        return history.pop();
    }

}
