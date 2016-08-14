package by.core.classloader;

import java.io.File;

/**
 * Created by Denis on 14.08.2016.
 */
public class LoaderRunner {
    public static void main(String[] args) {
//        String modulePath = "e:\\PROJECTS\\JMP\\classloader\\src\\main\\hotfolder\\";
        String modulePath = "e:\\PROJECTS\\JMP\\classloader\\src\\main\\java\\testHotFolder\\";
        /**
         * Создаем загрузчик модулей.
         */
        MyLoader loader = new MyLoader(modulePath, ClassLoader.getSystemClassLoader());

        /**
         * Получаем список доступных модулей.
         */
        File dir = new File(modulePath);
        String[] modules = dir.list();

        /**
         * Загружаем и исполняем каждый модуль.
         */
        for (String module: modules) {
            try {
                String moduleName = module.split(".class")[0];
                Class clazz = loader.loadClass(moduleName);
                LoaderPrinter execute = (LoaderPrinter) clazz.newInstance();

                execute.load();
                execute.run();
                execute.unload();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }
}
