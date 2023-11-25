/**
 * Simulates a number game.
 * @author boaz ng and jade joo
 */
import java.util.Scanner;

public class Game
{
    private Problem problem;
    private ProblemGrader grader;

    /**
     *
     */
    public Game()
    {
        grader = new ProblemGrader();
        problem = new Problem(grader.getLevel());
    }

    /**
     * Returns the grader piv
     * @return grader
     */
    public ProblemGrader getGrader() { return grader; }

    /**
     * Returns the problem piv
     * @return the problem object
     */
    public Problem getProblem() { return problem; }

    /**
     * Prints the problem, inputs response and returns it.
     * @param sc The scanner used to read inputs
     * @return Returns the user response
     */
    public String promptUser(Scanner sc)
    {
        printStatus();
        System.out.println(problem.toString() + " = ");
        String response = sc.nextLine();
        return response;
    }

    /**
     * Prints the status - Level, Remaining Tries, and Points
     */
    public void printStatus()
    {
        System.out.println("Level " + grader.getLevel());
        System.out.println("Tries Remaining: " + grader.getTries());
        System.out.println("Points: " + grader.getPoints() + "\n");
    }

    /**
     * Resets the problem by calling the Problem constructor and
     * assigning it to the private instance variable problem.
     */
    public void resetProblem()
    {
        problem = new Problem(grader.getLevel());
        grader.setTries(2);
    }

}