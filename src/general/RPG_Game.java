package general;

import players.*;

public class RPG_Game {

    public static void startGame() {
        Boss boss = new Boss(500, 50);
        Warrior warrior = new Warrior(250, 20);
        Magic magic = new Magic(170, 20);
        Medic medic = new Medic(200, 0, 30);
        Hunter hunter = new Hunter(150, 25);
        Hero[] heroes = {warrior, medic, hunter, magic};
        printStatistic(boss, heroes);

        while (!isFinished(boss, heroes)) {
            round(boss, heroes);
        }

    }

    public static void round(Boss boss, Hero[] heroes) {
        heroesHit(boss, heroes);
        bossHit(boss, heroes);
        heroesApplyAbilities(boss, heroes);
        //medicApplyAbilities(boss, heroes);
        printStatistic(boss, heroes);
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && !(heroes[i] instanceof Medic)) {
                if (boss.getHealth() - heroes[i].getDamage() < 0) {
                    boss.setHealth(0);
                }
                else  {
                    boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                }
            }
        }
    }

    private static void bossHit(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    if (heroes[i].getHealth() - boss.getDamage() < 0) {
                        heroes[i].setHealth(0);
                    }
                    else {
                        heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
                    }
                }

            }
        }

    }

    private static void heroesApplyAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }

    public static void printStatistic(Boss boss, Hero[] heroes) {
        System.out.println("-----------------------");
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] instanceof Warrior) {
                System.out.println("Warrior health: " + heroes[i].getHealth());
            }
            else if (heroes[i] instanceof Medic) {
                System.out.println("Medic health: " + heroes[i].getHealth());
            }
        }
    }

    public static boolean isFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!");
            return true;
        }
        boolean isAllHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                isAllHeroesDead = false;
                break;
            }
        }
        if (isAllHeroesDead) {
            System.out.println("Boss won!!");
        }
        return isAllHeroesDead;
    }

}
