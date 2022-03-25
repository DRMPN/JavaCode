public class Fighter {
    public String name;
    public int health, damagePerAttack;

    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }
}

public class Kata {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {

        Fighter attacker = fighter1, defender = fighter2;

        if (firstAttacker.equals(defender.name)) {
            attacker = fighter2;
            defender = fighter1;
        }

        while (true) {
            if ((defender.health -= attacker.damagePerAttack) <= 0)
                return attacker.name;
            if ((attacker.health -= defender.damagePerAttack) <= 0)
                return defender.name;
        }

    }
}