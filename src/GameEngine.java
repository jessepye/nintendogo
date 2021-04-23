import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class GameEngine {
    public User user;
//    private ArrayList<Character> availableCharacters;
//    {character:isCought}
    public HashMap<Character, Boolean> allCharacters;

    public GameEngine(User user) {
        allCharacters = new HashMap<>();
        createAllChars(user);
    }
    // create all characters(mario, peach, bowser, luigi, yoshi, daisy, rosalina, toad)
    public void createAllChars(User user) {
        Character peach = new Character(
                "Peach",
                "Peach has an affinity for the color pink, which accents her gentle personality and kind temperament. Peach's gentle nature and role as the damsel are often represented with her heart abilities and crown emblem.", 50);
        Character mario = new Character(
                "Mario",
                "His trademark abilities have been his jumping and stomping powers, with which he defeats most of his enemies, and his ability to gain even more powers with a plethora of items, such as the Super Mushroom, the Fire Flower, and the Super Star.",
                80);
        Character bowser = new Character(
                "Bowser",
                "He is a large, powerful, fire-breathing Koopa who leads the Koopa Troop, an antagonistic organization of turtle-like creatures.",
                100
        );
        Character luigi = new Character(
                "Luigi",
                " Luigi's notable traits include his green cap, his smooth mustache, his cowardly personality, his Italian accent, his heavy use of power-ups, and a superior jumping ability to Mario.",
                50
        );
        Character yoshi = new Character(
                "Yoshi",
                "He has flutter-jumping and egg-laying abilities, his rideability as a steed, and exclaiming his own name.",
                50
        );
        Character daisy = new Character(
                "Daisy",
                "Her attire, special abilities, personal emblems, and general representations are often flowers.",
                50
        );
        Character rosalina = new Character(
                "Rosalina",
                "Rosalina's defining traits are her tall height, her reserved personality, and a wide array of otherworldly abilities",
                50
        );
        Character toad = new Character(
                "Toad",
                "Toad's defining traits are his cartoonish and cutesy appearance, his optimism and humble, his sometimes cowardly personality, and his characteristic smile and voice.",
                50
        );

        allCharacters.put(peach, false);
        allCharacters.put(mario, false);
        allCharacters.put(luigi, false);
        allCharacters.put(bowser, false);
        allCharacters.put(daisy, false);
        allCharacters.put(rosalina, false);
        allCharacters.put(toad, false);
        allCharacters.put(yoshi, false);

        Character[] defaultChars = new Character[3];
        defaultChars[0] = mario;
        defaultChars[1] = peach;
        defaultChars[2] = yoshi;

        addDefaultChars(user, defaultChars);
    }
    // add default characters to user's pocket(mario, peach, yoshi)
    public void addDefaultChars(User user, Character[] chars) {

        for (Character i : chars) {
            user.pocket.add(i);
            allCharacters.put(i, true);
        }
    }

    // check pocket: print out user's characters
    public void checkPocket(User user) {
        System.out.println("In your pocket, you have: " + "\n");
        for (Character c : user.pocket) {
            System.out.println("Name: " + c.name + ", Power: " + c.power);
        }
    }

    // print options from pocket
    public void printPocketOptions(User user) {
        System.out.println("Please choose character from your pocket:");
        for (int i = 0; i < user.pocket.size(); i++) {
            System.out.println(i + 1 + ": " + user.pocket.get(i).name);
        }
    }

    public void printAvailability() {

    }

    // catch: 1. let user choose 1 character from the pocket;
    //        2. display the available characters to catch;
    //        3. let these two fight: -win: put into pocket -lose: nothing happens
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to nintendogo!");
        // 1. make an user instance with input name<string>
        System.out.println("What is your name?");
//        String name = sc.nextLine();
        String name = sc.next();
        System.out.println("Your name is: " + name);
        User user = new User(name);
        GameEngine ge = new GameEngine(user);
        ge.checkPocket(user);

        ge.printPocketOptions(user);
        // 2. list options for user to play with
//        {1. check pocket; 2. catch a new character}

    }
}
