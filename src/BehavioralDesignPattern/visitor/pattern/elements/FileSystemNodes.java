package BehavioralDesignPattern.visitor.pattern.elements;

import BehavioralDesignPattern.visitor.pattern.visitors.FileSystemVisitor;

public abstract class FileSystemNodes {
    protected String name;
    protected long size;

    public FileSystemNodes(String name, long size){
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public abstract void accept(FileSystemVisitor visitor);

}
