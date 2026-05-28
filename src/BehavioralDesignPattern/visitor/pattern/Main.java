package BehavioralDesignPattern.visitor.pattern;

import BehavioralDesignPattern.visitor.pattern.elements.FileSystemNodes;
import BehavioralDesignPattern.visitor.pattern.elements.ImageFile;
import BehavioralDesignPattern.visitor.pattern.elements.TextFile;
import BehavioralDesignPattern.visitor.pattern.elements.VideoFile;
import BehavioralDesignPattern.visitor.pattern.visitors.CompressionVisitor;
import BehavioralDesignPattern.visitor.pattern.visitors.FileSystemVisitor;
import BehavioralDesignPattern.visitor.pattern.visitors.SizeCalculatorVisitor;
import BehavioralDesignPattern.visitor.pattern.visitors.VirusScanVisitor;
import StructuralDesignPattern.composite.pattern.leaf.File;

public class Main {
    public static void main(String[] args) {
        FileSystemNodes textFile = new TextFile(
                "sample.txt",20
        );

        FileSystemNodes imageFile = new ImageFile(
                "sample.jpg",50
        );

        FileSystemNodes videoFile = new VideoFile(
                "sample.mp4",100
        );

        // =====================================================
        // Compression Visitor
        // =====================================================

        FileSystemVisitor compressionVisitor =
                new CompressionVisitor();

        textFile.accept(compressionVisitor);
        imageFile.accept(compressionVisitor);
        videoFile.accept(compressionVisitor);



        // =====================================================
        // Virus Scanner Visitor
        // =====================================================

        FileSystemVisitor virusScannerVisitor =
                new VirusScanVisitor();

        textFile.accept(virusScannerVisitor);
        imageFile.accept(virusScannerVisitor);
        videoFile.accept(virusScannerVisitor);



        // =====================================================
        // Size Calculator Visitor
        // =====================================================

        SizeCalculatorVisitor sizeCalculatorVisitor =
                new SizeCalculatorVisitor();

        textFile.accept(sizeCalculatorVisitor);
        imageFile.accept(sizeCalculatorVisitor);
        videoFile.accept(sizeCalculatorVisitor);

        System.out.println(
                "Total Size = " +
                        sizeCalculatorVisitor.getTotalSize()
        );
    }
}
