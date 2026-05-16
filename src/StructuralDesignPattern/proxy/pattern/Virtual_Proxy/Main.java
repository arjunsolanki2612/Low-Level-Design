package StructuralDesignPattern.proxy.pattern.Virtual_Proxy;

public class Main {

    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        System.out.println("Image object created.");
        System.out.println("But real image is not loaded yet.");

        System.out.println();

        System.out.println("First display call:");
        image.display();

        System.out.println();

        System.out.println("Second display call:");
        image.display();
    }
}
