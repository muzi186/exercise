package springframework.modules;

/**
 * Created by ibm on 2016/2/24.
 */
public class Currency {
    private int id;
    private String name;

    public Currency() {
    }

    public Currency(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!this.getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }
        Currency other = (Currency) obj;

        if (!(this.getId() == other.getId())) {
            return false;
        }

        return (this.getName() == null ? (other.getName() == null) : (this.getName().equals(other.getName())));
    }
}
