
/**
 * Simulates a problem
 * @author boaz ng and jade joo
 */
public class Problem
{
    int number1;
    int number2;
    int answer;
    int level;

    /**
     * Generates a problem given the level.
     * @param level The level that the program is at.
     * 		  For all cases, number1 < 10 and number2 < 10
     *		  If level is 1, number1 + number2 < 10
     *		  If level is 2, number1 < 10 and number2 < 10
     *		  If level is 3, number1 - number2 >= 0
     */
    public Problem (int level)
    {
        this.level = level;
        if (level == 3)
        {
            this.number1 = (int)(10 * Math.random());
            this.number2 = (int)((this.number1 + 1) * Math.random());
            this.answer = this.number1 - this.number2;
        }
        else if (level == 2)
        {
            this.number1 = (int)(10 * Math.random());
            this.number2 = (int)(10 * Math.random());
            this.answer = this.number1 + this.number2;
        }
        else
        {
            this.number1 = (int)(10 * Math.random());
            this.number2 = (int)((10 - this.number1) * Math.random());
            this.answer = this.number1 + this.number2;
        }
    }

    /**
     * Returns the first number in the problem
     * @return the first number in the problem
     */
    public int getNumber1()
    {
        return this.number1;
    }

    /**
     * Returns the second number in the problem
     * @return the second number in the problem
     */
    public int getNumber2()
    {
        return this.number2;
    }

    /**
     * Returns the answer to the problem
     * @return
     */
    public int getAnswer()
    {
        return this.answer;
    }

    /**
     * Returns the problem as a string
     * @return If levels 1 or 2, returns "[number1] + [number2]"
     *         If level 3, returns "[number1] - [number2]"
     */
    @Override
    public String toString()
    {
        if (level == 3)
        {
            return (number1 + " - " + number2);
        }
        else
        {
            return(number1 + " + " + number2);
        }
    }
}