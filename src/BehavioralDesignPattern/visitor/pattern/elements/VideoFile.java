package BehavioralDesignPattern.visitor.pattern.elements;

import BehavioralDesignPattern.visitor.pattern.visitors.FileSystemVisitor;

public class VideoFile extends FileSystemNodes{

    public VideoFile(String name, long size){
        super(name,size);
    }

    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
