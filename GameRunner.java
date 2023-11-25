import java.util.Scanner;

/**
 * Runs the game until user wins.
 * @author boaz ng and jade joo
 */
public class GameRunner
{
    public static void main (String[] args)
    {
        Game game = new Game();
        ProblemGrader grader = game.getGrader();
        while(!grader.getWinStatus())
        {
            Problem p = game.getProblem();
            int grade = grader.gradeAnswer(game.promptUser
                    (new Scanner(System.in)), p.getAnswer());
            if (grade == 1) // Answered correctly, produce new problem
            {
                game.resetProblem();
            }
            if (grade == 0) // Answered incorrectly and
            {               // ran out of tries. Generates new problem.
                game.resetProblem();
            }
            // Answered incorrectly, 1 more try
        }
    }
}