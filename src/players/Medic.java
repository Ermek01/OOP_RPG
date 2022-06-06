package players;

public class Medic extends Hero {

    private int healPoint;

    public Medic(int health, int damage, int healPoints) {
        super(health, damage, SuperAbility.HEAL);
        this.healPoint = healPoints;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0 && heroes[i].getHealth() < 100) {
                    heroes[i].setHealth(heroes[i].getHealth() + healPoint);
                }
            }
        }
    }
}
