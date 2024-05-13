package pkg;

// imports
import java.util.Random;
import java.util.ArrayList;
import java.time.LocalTime;

/**
 * Scramble class that generates a scramble and stores metadata about it (time taken to complete, time created etc.)
 * 
 * @author Danny Bunyan-Carroll
 * @since 13/05/2024
 */
public class Scramble {
    
    private ArrayList<String> scramble;
    private final LocalTime timeCreated;

    public Scramble() {
        this.scramble = generateScramble();
        this.timeCreated = LocalTime.now();
    }

    private ArrayList<String> generateScramble() {
        
        // initialise local variables
        int upperBound = 20;
        int lowerBound = 10;
        int scrambleLength;
        int scrambleInstructionIndex;
        int prime;
        String[] scrambleInstructions = {"R", "L", "U", "D", "B", "F", "u", "d", "r", "l", "f", "b", "M", "E", "S"};
        ArrayList<String> generatedScramble = new ArrayList<String>();
        Random rand = new Random();
        
        // generate scrambleLength
        scrambleLength = rand.nextInt(upperBound - lowerBound) + lowerBound;

        // generate scrambleLength amount of instructions, and add them to the generatedScramble arrayList
        for (int i = 0; i < scrambleLength; i++) {

            // generate random number that decides whether or not the instruction is a prime or not
            prime = rand.nextInt(2);

            // generate index of instruction
            scrambleInstructionIndex = rand.nextInt(scrambleInstructions.length);

            // check if prime is 0 or 1
            switch (prime) {
                case 0: // append normal instruction
                    generatedScramble.add(scrambleInstructions[scrambleInstructionIndex]);
                    break;
            
                case 1: // append prime instruction
                    generatedScramble.add(scrambleInstructions + "'");
                    break;

            }
        }

        return generatedScramble;

    }
}
