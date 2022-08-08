package numbers;

public class Duck implements Command{
    @Override
    public Boolean getResult(long num) {
        boolean flag = false;
        long tempNum = num;
        while (tempNum > 0) {
            if (tempNum % 10 == 0) {
                flag = true;
            }
            tempNum /= 10;
        }
        return flag;
    }
}
