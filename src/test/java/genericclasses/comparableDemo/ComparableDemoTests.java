package genericclasses.comparableDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ComparableDemoTests {
    //When working with custom types, or trying to compare objects that aren't directly comparable,
    //we need to make use of a comparison strategy. We can build one simply buy making use of the Comparator or Comparable interfaces.
    /** Comparable Interface
    As the name suggests, Comparable is an interface that defines a strategy for comparing an object with other objects of the same type.
    This is called the class's “natural ordering”.
    Accordingly, in order to be able to sort, we must define our objects class as comparable by implementing the Comparable interface.
     */

    @Test
    public void testComparableOne(){
        List<Player> playerList = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        Player player4 = new Player(79, "Matt", 87);
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
        System.out.println("Original list: \n" + playerList);
        System.out.println();
        Collections.sort(playerList);
        System.out.println("Collection sorted by ranking: \n" + playerList);
        Collections.sort(playerList, Collections.reverseOrder());
        System.out.println();
        System.out.println("List after reverse sorting: \n" + playerList);
//        if(player1 == player4){
//            System.out.println("Players are equals");
//        }else {
//            System.out.println("Players are not equals");
//        }
    }

}
