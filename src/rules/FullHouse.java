package rules;

import exceptions.RuleNotAvailableException;
import dices.Dice;

import java.util.ArrayList;
import java.util.List;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: solution to lab 02: Yahtzee game<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public class FullHouse extends AbstractRule {



    /**
     * Creates a new rule object.
     *
     * @param rule type of this object.
     */
    public FullHouse(Rule rule) {
        super(rule);
    }

    /**
     * Method calculates the value for this rule based on the fact wether dices build a full house or not.
     * This Method checks, if the rule FULL_HOUSE has already been set once.
     * If so, the value of object variable value is anything but -1. So first it
     * is checked, if value is anything but -1. If so, the RuleNotAvailableException
     * is thrown. If the rule is not used twice, it uses assistance method testOfAKind,
     * to check, if there are any dice-values more than one time in the list of dices.
     * This method returns an ArrayList of integers, in which the appearence of same
     * dices is stored. Then it is checked, if the number 3 and the number 2 occurs in the
     * result of the method call testOfAKind. If so, a full house has appeared in the
     * list of dices. If so, the full house value of 25 ist stored in sum and
     * handled over to value.
     * @param cup list of all dice in the game.
     * @throws RuleNotAvailableException if rule has already been set.
     */
    @Override
    public void calculateValue(List<Dice> cup) throws RuleNotAvailableException {

        int sum = 0;
        ArrayList<Integer> counterList;

        if (getValue() != -1) {
            throw new RuleNotAvailableException("You can not use this rule twice!");
        }
        else {
            counterList = testOfAKind(cup);
            if (counterList.contains(AMOUNT_OF_THREE_OF_A_KIND) && counterList.contains(AMOUNT_OF_TWO_OF_A_KIND)) {
                sum = VALUE_OF_FULLHOUSE;
            }
        }
        setValue(sum);
    }
}
