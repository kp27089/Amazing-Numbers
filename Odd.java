package numbers;

public class Odd implements Command{
    @Override
    public Boolean getResult(long number) {
        if (number % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }


}
