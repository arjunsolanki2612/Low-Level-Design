package StructuralDesignPattern.proxy.pattern.Virtual_Proxy;

public class RealImage implements Image{
    String filename;

    public RealImage(String filename){
        this.filename = filename;
        loadFromDisk();
    }

    public void loadFromDisk(){
        System.out.println("Loading image from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }

}
