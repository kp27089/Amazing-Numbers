package numbers;

public class IsNatural extends UserInput implements Command{



    @Override
    public Boolean getResult(long number) {
        return number >= 0 ? true : false;
    }
}

