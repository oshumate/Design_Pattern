package strategy;
public class Troll extends Character {
    public Troll(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "/^\\";
    }
}

