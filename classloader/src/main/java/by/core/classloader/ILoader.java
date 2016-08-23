package by.core.classloader;

/**
 * Created by Denis on 14.08.2016.
 */
public interface ILoader {
    public static final int EXIT_SUCCESS = 0;
    public static final int EXIT_FAILURE = 1;

    public void load();
    public int run();
    public void unload();
}
