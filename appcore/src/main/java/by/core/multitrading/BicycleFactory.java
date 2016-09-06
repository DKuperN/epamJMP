package by.core.multitrading;

import by.core.servicie.BuildBicycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Denis on 16.08.2016.
 */
@Component
public class BicycleFactory {
    @Autowired
    private BuildBicycle buildBicycleService;

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    private int threadCount = 1;

    public BicycleFactory() {
    }

    public BicycleFactory(BuildBicycle buildBicycleService) {
        this.buildBicycleService = buildBicycleService;
    }
    private Thread thread;
    private Random r = new Random();
    /**
     * start creating bicycles in multitrading mode
     */
    public void startFactoryWork() {
        System.out.println("***");
        for (int i = 0; i < threadCount; i++) {
            System.out.println("Start creating on: " + i + " threads!");
            int finalI = i;
            thread = new Thread(() -> {
                buildBicycleService.testSavingInToDB(finalI);
            });
            thread.start();
        }

    }

}
