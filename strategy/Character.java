package strategy;

public class Character {
    protected String name;
    private WeaponBehavior weaponBehavior;

    public Character(String name) {
        this.name = name;
        this.weaponBehavior = new WeaponNone();
    }

    public void attack() {
        weaponBehavior.attack();
    }

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    @Override
    public String toString() {
        return this.name + " the " + this.getClass().getSimpleName();
    }
}
