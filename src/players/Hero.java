package players;

public abstract class Hero extends GameEntity implements HavingSuperAbility {

    private SuperAbility superAbilty;

    public Hero(int health, int damage, SuperAbility superAbilty) {
        super(health, damage);
        this.superAbilty = superAbilty;
    }
}
