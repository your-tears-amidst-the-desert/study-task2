package main.java;

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleTransport implements Transport {
    private String brand;
    private final Map<String, Float> models = new LinkedHashMap<>();

    public SimpleTransport(String brand, int initialSize) {
        this.brand = brand;
        for (int i = 1; i <= initialSize; i++) {
            models.put("Model-" + i, 100_000f * i);
        }
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String[] getAllModelNames() {
        return models.keySet().toArray(new String[0]);
    }

    @Override
    public float[] getAllModelPrices() {
        float[] result = new float[models.size()];
        int i = 0;
        for (Float price : models.values()) {
            result[i++] = price;
        }
        return result;
    }

    @Override
    public float getModelPrice(String modelName) throws VehicleException {
        Float value = models.get(modelName);
        if (value == null) {
            throw new VehicleException("Модель не найдена: " + modelName);
        }
        return value;
    }

    @Override
    public void updateModelPrice(String modelName, float newPrice) throws VehicleException {
        if (!models.containsKey(modelName)) {
            throw new VehicleException("Модель не найдена: " + modelName);
        }
        models.put(modelName, newPrice);
    }

    @Override
    public void addModel(String modelName, float modelPrice) throws VehicleException {
        if (models.containsKey(modelName)) {
            throw new VehicleException("Модель уже существует: " + modelName);
        }
        models.put(modelName, modelPrice);
    }

    @Override
    public void updateModelName(String oldName, String newName) throws VehicleException {
        if (!models.containsKey(oldName)) {
            throw new VehicleException("Модель не найдена: " + oldName);
        }
        if (models.containsKey(newName)) {
            throw new VehicleException("Новое имя уже занято: " + newName);
        }
        float price = models.remove(oldName);
        models.put(newName, price);
    }

    @Override
    public void removeModel(String modelName) throws VehicleException {
        if (!models.containsKey(modelName)) {
            throw new VehicleException("Модель не найдена: " + modelName);
        }
        models.remove(modelName);
    }

    @Override
    public int getModelCount() {
        return models.size();
    }
}
