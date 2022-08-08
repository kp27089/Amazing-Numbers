package numbers;

public class Square implements Command{
    @Override
    public Boolean getResult(long number){
        double result = Math.sqrt(number);
        return result%1==0;

        }

    }

