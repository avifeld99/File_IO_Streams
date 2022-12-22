package objects_read_write.opdracht;

import java.io.Serializable;
import java.util.Objects;

public class Panda implements Serializable {

    private String name;
    private boolean edible;

    public Panda(String name, boolean edible) {
        this.name = name;
        this.edible = edible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEdible() {
        return edible;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Panda)) return false;
        Panda panda = (Panda) o;
        return edible == panda.edible && Objects.equals(name, panda.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, edible);
    }

    @Override
    public String toString() {
        return "Panda{" +
                "name='" + name + '\'' +
                ", edible=" + edible +
                '}';
    }
}
