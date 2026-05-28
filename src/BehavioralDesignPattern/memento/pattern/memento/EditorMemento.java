package BehavioralDesignPattern.memento.pattern.memento;

public final class EditorMemento {
    private final String text;

    public EditorMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
