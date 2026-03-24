package main.java;

public class SynchronizedTransportDecorator implements Transport {
    private final Transport delegate;

    public SynchronizedTransportDecorator(Transport delegate) {
        if (delegate == null) {
            throw new IllegalArgumentException("Transport не должен быть null");
        }
        this.delegate = delegate;
    }

    @Override
    public synchronized String getBrand() {
        return delegate.getBrand();
    }

    @Override
    public synchronized void setBrand(String brand) {
        delegate.setBrand(brand);
    }

    @Override
    public synchronized String[] getAllModelNames() {
        return delegate.getAllModelNames();
    }

    @Override
    public synchronized float[] getAllModelPrices() {
        return delegate.getAllModelPrices();
    }

    @Override
    public synchronized float getModelPrice(String modelName) throws VehicleException, VehicleError {
        return delegate.getModelPrice(modelName);
    }

    @Override
    public synchronized void updateModelPrice(String modelName, float newPrice) throws VehicleException {
        delegate.updateModelPrice(modelName, newPrice);
    }

    @Override
    public synchronized void addModel(String modelName, float modelPrice) throws VehicleException, VehicleError {
        delegate.addModel(modelName, modelPrice);
    }

    @Override
    public synchronized void updateModelName(String oldName, String newName) throws VehicleException {
        delegate.updateModelName(oldName, newName);
    }

    @Override
    public synchronized void removeModel(String modelName) throws VehicleException {
        delegate.removeModel(modelName);
    }

    @Override
    public synchronized int getModelCount() {
        return delegate.getModelCount();
    }
}
