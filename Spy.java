package numbers;

public class Spy implements Command{
    @Override
    public Boolean getResult(long number){
        long sumMultiplication = 1;
        long sumAddition = 0;

        while(number!=0){
            long reminder = number % 10;
            sumMultiplication *= reminder;
            sumAddition += reminder;
            number /=10;
        }
        return sumAddition == sumMultiplication;
    }


}
