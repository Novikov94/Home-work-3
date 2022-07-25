import org.apache.log4j.Logger;

public class Calculation {
    private static final Logger logger = Logger.getLogger(Calculation.class.getName());
    private int first_num;
    private int second_num;

    public Calculation(int first_num, int second_num) {
        this.first_num = first_num;
        this.second_num = second_num;
    }

    public int getFirst_num() {
        return first_num;
    }

    public void setFirst_num(int first_num) {
        this.first_num = first_num;
    }

    public int getSecond_num() {
        return second_num;
    }

    public void setSecond_num(int second_num) {
        this.second_num = second_num;
        logger.info("Set the second number");
    }

    public int add() {
        logger.warn("Operation warning");
        return first_num + second_num;
    }

    public int sub() {
        logger.debug("Debug level log");
        return first_num - second_num;
    }

    public int mul() {
        return first_num * second_num;
    }

    public int div() {
        if (second_num == 0) {
            logger.error("ERROR: You can't dividing by 0");
        }
        return first_num / second_num;
    }
}
