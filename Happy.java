package numbers;

public class Happy implements Command {
    @Override
    public Boolean getResult(long number){

        long tempNumber = returnNumber(number);
        while(tempNumber!=number && tempNumber!=1 && tempNumber > 4){
            if(number <= 4){
                return false;
            }
            tempNumber =  returnNumber(tempNumber);

        }
        if(tempNumber == 1){
            return true;
        } else {
            return false;
        }

    }



    public long returnNumber(long number) {
        long temp = 0;
        long sum = 0;

        while (number > 0) {

            temp =  number % 10;
            sum += temp * temp;
            number /= 10;
        }



        return sum;

    }

}
