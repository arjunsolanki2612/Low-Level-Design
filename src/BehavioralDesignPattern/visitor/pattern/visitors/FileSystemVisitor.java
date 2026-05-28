package BehavioralDesignPattern.visitor.pattern.visitors;

import BehavioralDesignPattern.visitor.pattern.elements.ImageFile;
import BehavioralDesignPattern.visitor.pattern.elements.TextFile;
import BehavioralDesignPattern.visitor.pattern.elements.VideoFile;

public interface FileSystemVisitor {
    public void visit(ImageFile imageFile);
    public void visit(TextFile textFile);
    public void visit(VideoFile videoFile);
}
