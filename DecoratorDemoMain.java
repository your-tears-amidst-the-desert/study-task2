package main.java;

public class DecoratorDemoMain {
    public static void main(String[] args) throws Exception {
        Transport base = new SimpleTransport("Toyota", 2);
        Transport safe = VehicleUtils.synchronizedTransport(base);

        Thread t1 = new Thread(() -> {
            try {
                safe.addModel("Corolla", 2_000_000f);
            } catch (VehicleException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                safe.updateModelPrice("Model-1", 1_500_000f);
            } catch (VehicleException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        VehicleUtils.printAllPrices(safe);
    }
}
