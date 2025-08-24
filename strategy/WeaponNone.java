package strategy;

public class WeaponNone extends WeaponBehavior {
    @Override
    public void attack() {
        System.out.println("No Weapon Needed");
    }
}

