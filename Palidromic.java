package numbers;

public class Palidromic implements Command {
    @Override
    public Boolean getResult(long num) {

        long tempNumber = num;
        long palinDromicNum = 0;
        while (tempNumber != 0) {
            long tempLoopVariable = tempNumber % 10;
            palinDromicNum = palinDromicNum * 10 + tempLoopVariable;
            tempNumber /= 10;
        }


        return palinDromicNum == num;


    }
}
