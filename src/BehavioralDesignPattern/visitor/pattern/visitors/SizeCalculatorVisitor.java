package BehavioralDesignPattern.visitor.pattern.visitors;


import BehavioralDesignPattern.visitor.pattern.elements.ImageFile;
import BehavioralDesignPattern.visitor.pattern.elements.TextFile;
import BehavioralDesignPattern.visitor.pattern.elements.VideoFile;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private long totalSize = 0;

    @Override
    public void visit(TextFile textFile) {

        totalSize += textFile.getSize();

        System.out.println(
                "Adding text file size: " + textFile.getSize()
        );
    }

    @Override
    public void visit(ImageFile imageFile) {

        totalSize += imageFile.getSize();

        System.out.println(
                "Adding image file size: " + imageFile.getSize()
        );
    }

    @Override
    public void visit(VideoFile videoFile) {

        totalSize += videoFile.getSize();

        System.out.println(
                "Adding video file size: " + videoFile.getSize()
        );
    }

    public long getTotalSize() {
        return totalSize;
    }
}
