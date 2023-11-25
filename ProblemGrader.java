/**
 * Simulates a problem grader and stores level,
 * tries remaining, and points
 * @author boaz ng and jade joo
 */
public class ProblemGrader
{
    private int level;
    private int triesRemaining;
    private int points;
    private boolean win;

    /**
     * Creates a "problem grader", sets level, tries
     * remaining, points
     */
    public ProblemGrader()
    {
        this.level = 1;
        this.triesRemaining = 2;
        this.points = 0;
        this.win = false;
    }

    /**
     * Returns the level of the player
     * @return the level
     */
    public int getLevel() { return this.level; }

    /**
     * Returns the number of tries remaining on a problem
     * @return the tries remaining
     */
    public int getTries() { return this.triesRemaining; }

    /**
     * Returns the number of points
     * @return the number of points
     */
    public int getPoints() { return this.points; }

    /**
     * Returns win status
     * @return win status
     */
    public boolean getWinStatus() {return this.win; }

    public void setTries(int a) { this.triesRemaining = a; }

    /**
     * Compares answer with input
     * @param userInput The user's input
     * @param answer The correct answer
     * @return If input = answer, returns 1
     *         If input != answer but 1 try remaining, returns -1
     *         If input != answer and no tries remaining, returns 0
     */
    public int gradeAnswer(String userInput, int answer)
    {
        int input = 100;
        try
        {
            input = Integer.parseInt(userInput);
        }
        catch(NumberFormatException e) // if not an integer, does not affect pivs
        {
            System.out.println("Please enter an integer!\n");
            return(-1);
        }
        if (input == answer)
        {
            return(correctAnswer());
        }
        else
        {
            return(wrongAnswer());
        }
    }

    /**
     * Modifies PIVs as if there were a correct answer and prints
     * @return 1
     */
    public int correctAnswer()
    {

        System.out.println("Correct answer!\n");
        points ++;
        if (points == 5) // 5 points advances to the next level
        {
            level ++;
            points = 0;
            if (level > 3)
            {
                this.win = true;
                System.out.println("You win!");
            }
        }
        return(1);
    }

    /**
     * Modifies pivs accordingly to an incorrect answer and prints
     * @return 0 if no tries remaining, otherwise returns -1
     */
    public int wrongAnswer()
    {
        triesRemaining --;
        System.out.println("Wrong answer.\n");
        if (triesRemaining == 0) // No tries remaining
        {
            triesRemaining = 2;
            return(0);
        }
        return(-1); // 1 try left
    }

}