package zse.oop;

import zse.oop.Simulation;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {

    private final List<Simulation> simulations;
    private final List<Thread> threads = new ArrayList<>();
    private ExecutorService threadPool;

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    // === SYNC ===
    public void runSync() {
        for (Simulation sim : simulations) {
            sim.run();
        }
    }

    // === ASYNC ===
    public void runAsync() {
        threads.clear();
        for (Simulation sim : simulations) {
            Thread t = new Thread(sim::run);
            threads.add(t);
            t.start();
        }
    }

    // === ASYNC with Thread Pool ===
    public void runAsyncInThreadPool() {
        threadPool = Executors.newFixedThreadPool(4);
        for (Simulation sim : simulations) {
            threadPool.submit(sim::run);
        }
    }

    // === wait for completion ===
    public void awaitSimulationsEnd() {
        try {
            // wait for async threads
            for (Thread t : threads) {
                t.join();
            }
            // wait for thread pool
            if (threadPool != null) {
                threadPool.shutdown();
                threadPool.awaitTermination(10, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
