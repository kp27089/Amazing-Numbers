package numbers;

public class Gapful implements Command{

    @Override
    public Boolean getResult(long num) {
        Boolean flag = false;
        String tempValue = Long.toString(num);
        if(tempValue.length()<3) {
            flag = false;
        } else {
            long num1 = Long.parseLong(tempValue.charAt(0)+""+tempValue.charAt(tempValue.length()-1));
            if(num%num1==0){
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;


    }
}
