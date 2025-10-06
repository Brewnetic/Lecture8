// Import Scanner class to read user input from the console
import java.util.Scanner;

// Main class containing the entry point of the program
public class RPGExample {
    
    // Main method - where the program starts
    public static void main(String[] args) {
        
        // Create Scanner object to read keyboard input
        Scanner scanner = new Scanner(System.in);
        
        // Create an array to store 3 Character objects
        // *** CONCEPT: POLYMORPHISM ***
        // This demonstrates POLYMORPHISM - the array is of type Character (parent class)
        // but it will hold Warrior, Mage, and Archer objects (child classes)
        Character[] party = new Character[_______];
        
        System.out.println("Welcome to RPG Character Creator!\n");
        
        // Loop to create 3 characters
        for (int i = 0; i < _______; i++) {
            
            // Ask for character name
            System.out.print("Character " + (i + 1) + " Name: ");
            String name = scanner._______();
            
            // Print blank line for formatting
            System.out.println();
            
            // Ask for character class
            System.out.print("Character " + (i + 1) + " Class (Warrior/Mage/Archer): ");
            String characterClass = scanner._______();
            
            // Print blank line for formatting
            System.out.println();
            
            // Create the appropriate character type based on user input
            // Use if-else to check the characterClass string
            // *** CONCEPT: POLYMORPHISM ***
            // This demonstrates POLYMORPHISM - storing child objects in parent type array
            if (characterClass._______("_______")) {
                party[i] = new _______(_______);
            } else if (characterClass._______("_______")) {
                party[i] = new _______(_______);
            } else if (characterClass._______("_______")) {
                party[i] = new _______(_______);
            }
        }
        
        // Print battle simulation header
        System.out.println("=== Battle Simulation ===\n");
        
        // Loop through the party array
        // For each character, call the attack() method and print the result
        // *** CONCEPT: POLYMORPHISM & OVERRIDING ***
        // This demonstrates POLYMORPHISM and METHOD OVERRIDING
        // Even though party[i] is type Character, it will call the child class's attack() method
        for (int i = 0; i < party._______; i++) {
            System.out.println(party[i]._______());
            System.out.println();
        }
        
        // Print leveling up header
        System.out.println("=== Leveling Up ===\n");
        
        // Loop through the party array again
        // For each character, call the levelUp() method
        // *** CONCEPT: INTERFACE ***
        // This demonstrates INTERFACE IMPLEMENTATION
        // All characters implement the Playable interface which requires levelUp()
        for (int i = 0; i < party._______; i++) {
            party[i]._______();
            System.out.println();
        }
        
        // Close the scanner to free up resources
        scanner.close();
    }
}


// ============================================
// INTERFACE: Playable
// ============================================

// Create an interface called Playable
// *** CONCEPT: INTERFACE ***
// Interfaces define a CONTRACT - methods that implementing classes MUST provide
_______ Playable {
    
    // Declare an abstract method called levelUp() that returns void
    // Interface methods are abstract by default (no implementation, just signature)
    // This forces any class that implements Playable to provide a levelUp() method
    _______ levelUp();
}


// ============================================
// BASE CLASS: Character
// ============================================

// Create a class called Character that implements Playable
// *** CONCEPT: INTERFACE ***
// This means Character MUST provide an implementation for the levelUp() method
class Character _______ Playable {
    
    // Public properties that child classes will inherit
    // These are accessible from outside the class
    public String name;
    public int health;
    public int level;
    
    // CONSTRUCTOR OVERLOADING #1
    // *** CONCEPT: OVERLOADING ***
    // Constructor that takes only name as a parameter
    // This is CONSTRUCTOR OVERLOADING - multiple constructors with different parameters
    public Character(String _______) {
        // Set the name property to the name passed in
        this._______ = name;
        // Set health to 100 (default health)
        this._______ = 100;
        // Set level to 1 (starting level)
        this._______ = 1;
    }
    
    // CONSTRUCTOR OVERLOADING #2
    // *** CONCEPT: OVERLOADING ***
    // Constructor that takes name AND health as parameters
    // This demonstrates CONSTRUCTOR OVERLOADING - same constructor name, different parameters
    public Character(String name, int _______) {
        // Set the name property to the name passed in
        this._______ = name;
        // Set the health property to the health passed in
        this._______ = health;
        // Set level to 1 (starting level)
        this._______ = 1;
    }
    
    // METHOD OVERLOADING #1
    // *** CONCEPT: OVERLOADING ***
    // Method called attack() with NO parameters that returns a String
    // This is the base version of attack() that child classes will override
    public String _______() {
        return name + " attacks!";
    }
    
    // METHOD OVERLOADING #2
    // *** CONCEPT: OVERLOADING ***
    // Method called attack() that takes a String parameter called target
    // This is METHOD OVERLOADING - same method name, different parameters
    // Java knows which version to call based on whether you pass an argument or not
    public String attack(String _______) {
        return name + " attacks " + target + "!";
    }
    
    // Implement the levelUp() method from the Playable interface
    // *** CONCEPT: INTERFACE & OVERRIDING ***
    // Use @Override annotation to indicate we're implementing the interface method
    // This implements the contract from the Playable interface
    _______
    public void levelUp() {
        // Increment level by 1
        _______++;
        // Print leveling up message
        System.out.println(name + " leveled up to level " + level + "!");
    }
}


// ============================================
// CHILD CLASS: Warrior
// ============================================

// Create a class called Warrior that extends Character
// "extends Character" means Warrior inherits all properties and methods from Character
// Warrior IS-A Character (inheritance relationship)
class Warrior _______ Character {
    
    // Constructor that takes name as a parameter
    // Call super(name) to initialize the parent class
    // super() calls the parent class's constructor
    // This will set the name, health (to default 100), and level (to 1)
    public Warrior(String name) {
        _______(_______);
    }
    
    // Override the attack() method (the one with NO parameters)
    // *** CONCEPT: OVERRIDING ***
    // Use @Override annotation to indicate we're replacing the parent's method
    // This replaces the parent's attack() method with warrior-specific behavior
    // This is METHOD OVERRIDING - same signature, different implementation
    _______
    public String attack() {
        return name + " swings a mighty sword!";
    }
}


// ============================================
// CHILD CLASS: Mage
// ============================================

// Create a class called Mage that extends Character
class Mage _______ Character {
    
    // Constructor that takes name as a parameter
    // Call super(name) to initialize the parent class
    public Mage(String name) {
        _______(_______);
    }
    
    // Override the attack() method (the one with NO parameters)
    // *** CONCEPT: OVERRIDING ***
    // Use @Override annotation to indicate we're replacing the parent's method
    // This demonstrates METHOD OVERRIDING - Mage's version of attack()
    _______
    public String attack() {
        return name + " casts a powerful spell!";
    }
}


// ============================================
// CHILD CLASS: Archer
// ============================================

// Create a class called Archer that extends Character
class Archer _______ Character {
    
    // Constructor that takes name as a parameter
    // Call super(name) to initialize the parent class
    public Archer(String name) {
        _______(_______);
    }
    
    // Override the attack() method (the one with NO parameters)
    // *** CONCEPT: OVERRIDING ***
    // Use @Override annotation to indicate we're replacing the parent's method
    // This demonstrates METHOD OVERRIDING - Archer's version of attack()
    _______
    public String attack() {
        return name + " shoots a precise arrow!";
    }
}