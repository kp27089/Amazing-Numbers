package numbers;

public class Buzz implements Command{
    @Override
    public Boolean getResult(long num) {
        Boolean flag;
        long lastDigit = num % 10;

        if (num % 7 == 0) {
            flag = true;

            if (lastDigit == 7 && num % 7 == 0) {

            } else {

            }
        } else {
            if (lastDigit == 7) {
                flag = true;

            } else {
                flag = false;

            }
        }
        return flag;
    }


}
