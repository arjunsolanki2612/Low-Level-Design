package BehavioralDesignPattern.memento.pattern.originator;

import BehavioralDesignPattern.memento.pattern.memento.EditorMemento;

public class TextEditor {
    private String text;

    public void write(String text) {
        this.text = text;
    }

    public void showText() {
        System.out.println("Current Text: "+text);
    }

    public EditorMemento save() {
        return new EditorMemento(text);
    }

    public void restore(EditorMemento memento) {
        text = memento.getText();
    }
}
