package BehavioralDesignPattern.visitor.pattern.elements;

import BehavioralDesignPattern.visitor.pattern.visitors.FileSystemVisitor;

public class ImageFile extends FileSystemNodes{
    public ImageFile(String name, long size) {
        super(name, size);
    }

    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
