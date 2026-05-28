package BehavioralDesignPattern.visitor.pattern.visitors;

import BehavioralDesignPattern.visitor.pattern.elements.ImageFile;
import BehavioralDesignPattern.visitor.pattern.elements.TextFile;
import BehavioralDesignPattern.visitor.pattern.elements.VideoFile;

public class CompressionVisitor implements FileSystemVisitor{

    @Override
    public void visit(ImageFile imageFile) {
        System.out.println("Compressing image: " + imageFile.getName());
    }

    @Override
    public void visit(TextFile textFile){
        System.out.println("Compressing Text: "+ textFile.getName());
    }

    @Override
    public void visit(VideoFile videoFile){
        System.out.println("Compressing Video: "+ videoFile.getName());
    }
}
