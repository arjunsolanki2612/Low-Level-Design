package StructuralDesignPattern.proxy.pattern.Virtual_Proxy;

public class ProxyImage implements Image {
    String filename;
    RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            System.out.println("RealImage object not created yet. Creating now...");
            realImage = new RealImage(filename);
        } else {
            System.out.println("RealImage already exists. Reusing existing object...");
        }

        realImage.display();
    }
}

