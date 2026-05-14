package StructuralDesignPattern.composite.pattern;

import StructuralDesignPattern.composite.pattern.composite.Folder;
import StructuralDesignPattern.composite.pattern.leaf.File;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("Resume.pdf");
        File file2 = new File("Batch.xml");

        Folder moviesFolder = new Folder("Movies");

        File movie1 = new File("Avengers.mp4");
        File movie2 = new File("Batman.mp4");

        moviesFolder.add(movie1);
        moviesFolder.add(movie2);

        Folder root = new Folder("Root");

        root.add(file1);
        root.add(file2);
        root.add(moviesFolder);

        root.showDetails();


    }
}
