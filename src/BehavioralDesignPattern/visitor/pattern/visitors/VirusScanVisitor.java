package BehavioralDesignPattern.visitor.pattern.visitors;

import BehavioralDesignPattern.visitor.pattern.elements.ImageFile;
import BehavioralDesignPattern.visitor.pattern.elements.TextFile;
import BehavioralDesignPattern.visitor.pattern.elements.VideoFile;

public class VirusScanVisitor implements FileSystemVisitor {

    @Override
    public void visit(TextFile textFile) {

        System.out.println(
                "Scanning text file: " + textFile.getName()
        );
    }

    @Override
    public void visit(ImageFile imageFile) {

        System.out.println(
                "Scanning image file: " + imageFile.getName()
        );
    }

    @Override
    public void visit(VideoFile videoFile) {

        System.out.println(
                "Scanning video file: " + videoFile.getName()
        );
    }
}
