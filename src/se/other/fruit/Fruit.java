package se.other.fruit;

/**
 * @author sukbear
 * @create 2018-12-17 10:09
 */
public class Fruit {
    private String shape;
    private Double weight;
    public Fruit(){}
    public Fruit(String shape, Double weight) {
        this.shape = shape;
        this.weight = weight;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


}
