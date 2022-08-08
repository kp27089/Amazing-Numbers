package numbers;

public class Jumping implements Command{
    @Override
    public Boolean getResult(long number) {
        String s=Long.toString(number);

        for(int i = 0 ; i < s.length()-1; i++){
            if((s.charAt(i)==s.charAt(i+1)-1) || (s.charAt(i)==s.charAt(i+1)+1)){

            } else {
                return false;
            }

        }


        return true;
    }
}
