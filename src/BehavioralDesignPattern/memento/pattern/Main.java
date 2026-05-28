package BehavioralDesignPattern.memento.pattern;

import BehavioralDesignPattern.memento.pattern.caretaker.HistoryManager;
import BehavioralDesignPattern.memento.pattern.originator.TextEditor;

public class Main {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();
        HistoryManager history = new HistoryManager();

        editor.write("Arjun");
        editor.showText();
        history.save(editor.save());

        //2nd

        editor.write("Arjun SDE");
        editor.showText();
        history.save(editor.save());

        //3rd

        editor.write("Arjun SDE Google");
        editor.showText();

        System.out.println("After 1st undo");
        editor.restore(history.undo());
        editor.showText();

        System.out.println("After second undo");
        editor.restore(history.undo());
        editor.showText();
    }
}
