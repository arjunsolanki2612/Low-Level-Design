package BehavioralDesignPattern.visitor.pattern.elements;

import BehavioralDesignPattern.visitor.pattern.visitors.FileSystemVisitor;

public class TextFile extends FileSystemNodes {

    public TextFile(String name,long size) {
        super(name, size);
    }

        public void accept(FileSystemVisitor visitor) {
            visitor.visit(this);
        }
}

