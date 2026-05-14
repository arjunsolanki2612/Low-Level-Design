package StructuralDesignPattern.composite.pattern.leaf;

import StructuralDesignPattern.composite.pattern.component.FileSystemComponent;

public class File implements FileSystemComponent {
    private String name;
    public File(String name){
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}
