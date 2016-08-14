package by.core.classloader;

/**
 * Created by Denis on 14.08.2016.
 */
public class LoaderPrinter implements ILoader {

    public void load() {
        System.out.println("Module " + this.getClass() + " loading ...");
    }

    public int run() {
        System.out.println("Module " + this.getClass() + " running ...");
        return ILoader.EXIT_SUCCESS;
    }

    public void unload() {
        System.out.println("Module " + this.getClass() + " inloading ...");
    }
}
