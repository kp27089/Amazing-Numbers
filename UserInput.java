package numbers;


import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class UserInput {
    final Scanner scanner = new Scanner(System.in);
    private String[] tempNumber;
    private long number;


    public UserInput(String[] tempNumber, long number) {
        this.tempNumber = tempNumber;
        this.number = number;
    }


    public UserInput() {

    }

    public void runApp() {
        textMenu();
        UserInput user = new UserInput();
        do {


            System.out.println("Enter a request");


            tempNumber = scanner.nextLine().split(" ");
            number = Long.parseLong(tempNumber[0]);

            System.out.println();
            NumberFormat format = NumberFormat.getInstance(new Locale("en", "US"));
            IsNatural isnatural = new IsNatural();
            Buzz buzz = new Buzz();
            Duck duck = new Duck();
            Palidromic palidromic = new Palidromic();
            Gapful gapeful = new Gapful();
            Odd odd = new Odd();
            Spy spy = new Spy();
            Square square = new Square();
            Square sunny = new Square();
            Jumping jumping = new Jumping();
            Happy happy = new Happy();
            if (tempNumber.length == 1 && number == 0) {
                System.out.println("Goodbye!");

            } else if (!isnatural.getResult(Long.parseLong(tempNumber[0]))) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else if (tempNumber.length > 1 && (!isnatural.getResult(Long.parseLong(tempNumber[1])))) {
                System.out.println("The second parameter should be a natural number.");
            } else if (tempNumber.length == 1) {
                long happyTemp = (long)number;

                System.out.println("Properties of " + format.format(number));
                System.out.println("        buzz: " + buzz.getResult(number));
                System.out.println("        duck: " + duck.getResult(number));
                System.out.println(" palindromic: " + palidromic.getResult(number));
                System.out.println("      gapful: " + gapeful.getResult(number));
                System.out.println("        even: " + !odd.getResult(number));
                System.out.println("         odd: " + odd.getResult(number));
                System.out.println("         spy: " + spy.getResult(number));
                System.out.println("      square: " + square.getResult(number));
                System.out.println("       sunny: " + square.getResult(number+1));
                System.out.println("       happy: " + happy.getResult(happyTemp));
                System.out.println("         sad: " + !happy.getResult(happyTemp));
                System.out.println("     jumping: " + jumping.getResult(number));


            } else if (tempNumber.length == 2 && isnatural.getResult(Long.parseLong(tempNumber[1]))) {
                long counter = 0;
                while (counter < Long.parseLong(tempNumber[1])) {
                    long tempNum = Long.parseLong(tempNumber[0]) + counter;
                    System.out.print(tempNum + " is ");
                    if (buzz.getResult(tempNum)) {
                        System.out.print("buzz, ");
                    }
                    if (duck.getResult(tempNum)) {
                        System.out.print("duck, ");
                    }
                    if (jumping.getResult(tempNum)) {
                        System.out.print("jumping, ");
                    }

                    if (palidromic.getResult(tempNum)) {
                        System.out.print("palindromic, ");
                    }
                    if (gapeful.getResult(tempNum)) {
                        System.out.print("gapeful, ");
                    }
                    if (spy.getResult(tempNum)) {
                        System.out.print("spy, ");
                    }

                    if (square.getResult(tempNum)) {
                        System.out.print("square, ");
                    }

                    if (sunny.getResult(tempNum + 1)) {
                        System.out.print("sunny, ");
                    }

                    if (happy.getResult(tempNum)) {
                        System.out.print("happy, ");
                    }

                    if (!happy.getResult(tempNum)) {
                        System.out.print("sad, ");
                    }


                    if (!odd.getResult(tempNum)) {
                        System.out.print("even");
                    }
                    if (odd.getResult(tempNum)) {
                        System.out.print("odd");
                    }

                    System.out.println();
                    counter++;
                }
            } else if (tempNumber.length == 3) {
                String tempWord = tempNumber[2].toUpperCase().substring(1);
                if (Property.contains(tempNumber[2].charAt(0) == '-' ? tempWord : tempNumber[2].toUpperCase())) {
                    long counter = 0;
                    long occurancyCounter = 0;
                    while (occurancyCounter < Long.parseLong(tempNumber[1])) {
                        long tempNum = Long.parseLong(tempNumber[0]) + counter;
                        if (occurrence(tempNum, tempNumber[2].toLowerCase())) {

                            System.out.print(tempNum + " is ");
                            if (buzz.getResult(tempNum)) {
                                System.out.print("buzz, ");
                            }
                            if (duck.getResult(tempNum)) {
                                System.out.print("duck, ");
                            }
                            if (palidromic.getResult(tempNum)) {
                                System.out.print("palindromic, ");
                            }
                            if (gapeful.getResult(tempNum)) {
                                System.out.print("gapeful, ");
                            }
                            if (spy.getResult(tempNum)) {
                                System.out.print("spy, ");
                            }

                            if (square.getResult(tempNum)) {
                                System.out.print("square, ");
                            }

                            if (happy.getResult(tempNum)) {
                                System.out.print("happy, ");
                            }

                            if (!happy.getResult(tempNum)) {
                                System.out.print("sad, ");
                            }


                            if (sunny.getResult(tempNum + 1)) {
                                System.out.print("sunny, ");
                            }

                            if (jumping.getResult(tempNum)) {
                                System.out.print("jumping, ");
                            }

                            if (!odd.getResult(tempNum)) {
                                System.out.print("even");
                            }

                            if (odd.getResult(tempNum)) {
                                System.out.print("odd");
                            }
                            System.out.println();
                            counter++;
                            occurancyCounter++;
                        } else
                            counter++;


                    }
                    System.out.println();

                } else {
                    falseResult(tempNumber[2].toUpperCase());
                }


            } else if (tempNumber.length >= 4) {

                int falseResults = 0;
                for (int i = 2; i < tempNumber.length; i++) {
                    String tempWord = tempNumber[i].toUpperCase().substring(1);
                    if (!Property.contains(tempNumber[i].charAt(0) == '-' ? tempWord : tempNumber[i].toUpperCase())) {
                        falseResults++;
                    }
                }
                if (falseResults == 1) {
                    for (int i = 2; i < tempNumber.length; i++) {
                        if (!Property.contains(tempNumber[i].toUpperCase())) {
                            falseResult(tempNumber[i].toUpperCase());
                        }
                    }
                } else if (falseResults > 1) {
                    falseResult(tempNumber, falseResults);
                }
                else if (exclusivePropertiesOfArray(tempNumber)) {
                } else {
                    long counter = 0;
                    long occurancyCounter = 0;

                    while (occurancyCounter < Long.parseLong(tempNumber[1])){
                        long tempNum = Long.parseLong(tempNumber[0]) + counter;
                        if(occuranceArray(tempNumber, tempNum)){

                            System.out.print(tempNum + " is ");
                            if (buzz.getResult(tempNum)) {
                                System.out.print("buzz, ");
                            }
                            if (duck.getResult(tempNum)) {
                                System.out.print("duck, ");
                            }
                            if (jumping.getResult(tempNum)) {
                                System.out.print("jumping, ");
                            }

                            if (palidromic.getResult(tempNum)) {
                                System.out.print("palindromic, ");
                            }
                            if (gapeful.getResult(tempNum)) {
                                System.out.print("gapeful, ");
                            }
                            if (spy.getResult(tempNum)) {
                                System.out.print("spy, ");
                            }

                            if (square.getResult(tempNum)) {
                                System.out.print("square, ");
                            }

                            if (sunny.getResult(tempNum + 1)) {
                                System.out.print("sunny, ");
                            }

                            if (happy.getResult(tempNum)) {
                                System.out.print("happy, ");
                            }

                            if (!happy.getResult(tempNum)) {
                                System.out.print("sad, ");
                            }

                            if (!odd.getResult(tempNum)) {
                                System.out.print("even");
                            }
                            if (odd.getResult(tempNum)) {
                                System.out.print("odd");
                            }
                            System.out.println();
                            counter++;
                            occurancyCounter++;
                        } else
                            counter++;


                    }

                }

            }


        } while (number != 0);
    }


    public boolean exclusiveProperties(String test1, String test2) {
        if (test1.equalsIgnoreCase("ODD") && test2.equalsIgnoreCase("EVEN")
                || test1.equalsIgnoreCase("EVEN") && test2.equalsIgnoreCase("ODD")) {
            return true;
        } else if (test1.equalsIgnoreCase("Duck") && test2.equalsIgnoreCase("Spy")
                || test1.equalsIgnoreCase("Spy") && test2.equalsIgnoreCase("Duck")) {
            return true;
        } else if (test1.equalsIgnoreCase("Sunny") && test2.equalsIgnoreCase("Square")
                || test2.equalsIgnoreCase("Sunny") && test1.equalsIgnoreCase("Square")) {
            return true;


        } else if (test1.equalsIgnoreCase("-ODD") && test2.equalsIgnoreCase("-EVEN")
                || test2.equalsIgnoreCase("-EVEN") && test1.equalsIgnoreCase("-ODD")) {
            return true;


        } else if (test1.equalsIgnoreCase("ODD") && test2.equalsIgnoreCase("-ODD")
                || test2.equalsIgnoreCase("-ODD") && test1.equalsIgnoreCase("ODD")) {
            return true;


        } else if (test1.equalsIgnoreCase("Even") && test2.equalsIgnoreCase("-Even")
                || test2.equalsIgnoreCase("Even") && test1.equalsIgnoreCase("-Even")) {
            return true;


        } else if (test1.equalsIgnoreCase("Duck") && test2.equalsIgnoreCase("-Duck")
                || test2.equalsIgnoreCase("Duck") && test1.equalsIgnoreCase("-Duck")) {
            return true;


        } else if (test1.equalsIgnoreCase("happy") && test2.equalsIgnoreCase("-happy")
                || test2.equalsIgnoreCase("happy") && test1.equalsIgnoreCase("-happy")) {
            return true;


        } else if (test1.equalsIgnoreCase("gapful") && test2.equalsIgnoreCase("-gapful")
                || test2.equalsIgnoreCase("gapful") && test1.equalsIgnoreCase("-gapful")) {
            return true;


        } else if (test1.equalsIgnoreCase("Spy") && test2.equalsIgnoreCase("-Spy")
                || test2.equalsIgnoreCase("Spy") && test1.equalsIgnoreCase("-Spy")) {
            return true;


        } else if (test1.equalsIgnoreCase("duck") && test2.equalsIgnoreCase("-duck")
                || test2.equalsIgnoreCase("duck") && test1.equalsIgnoreCase("-duck")) {
            return true;


        } else if (test1.equalsIgnoreCase("-"+test1) && test2.equalsIgnoreCase("-"+test2)
                || test2.equalsIgnoreCase("duck") && test1.equalsIgnoreCase("-duck")) {
            return true;


        }
        return false;
    }

    public boolean exclusivePropertiesOfArray(String[] testForExc){
        for(int i = 2;  i < testForExc.length-1; i++){
            for(int j = i+1; j < testForExc.length;j++){
                if(exclusiveProperties(testForExc[i], testForExc[j])){
                    System.out.println("The request contains mutually exclusive properties: [" + tempNumber[i] +
                            ", " + tempNumber[j] + "]");
                    System.out.println("There are no numbers with these properties.");

                    return true;
                }
            }
        }
        return false;
    }


    public void textMenu() {
        System.out.println("Welcome to Amazing Numbers!\n");

        System.out.println("Supported requests:");

        System.out.println("- enter a natural number to know its properties; ");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be printed;");
        System.out.println("- two natural numbers and a property to search for");
        System.out.println("- two natural numbers and two properties to search for;");
        System.out.println("- separate the parameters with one space");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }


    public void falseResult(String test) {
        System.out.println("The property [" + test.toUpperCase() + "] is wrong.");
        System.out.print("Available properties: [");

        String genInfoValues = "";
        boolean firstRun = true;
        for (Property info : Property.values()) {
            if (firstRun) {
                firstRun = false;
                genInfoValues += info.name();
            } else {
                genInfoValues += ", " + info.name();
            }
        }

        System.out.print(genInfoValues);
        System.out.print("]\n\n");
    }


    public void falseResult(String test, String test2) {


        System.out.println("The properties [" + test.toUpperCase() + ", " + test2.toUpperCase() + "] are wrong.");
        System.out.print("Available properties: [");

        String genInfoValues = "";
        boolean firstRun = true;
        for (Property info : Property.values()) {
            if (firstRun) {
                firstRun = false;
                genInfoValues += info.name();
            } else {
                genInfoValues += ", " + info.name();
            }
        }

        System.out.print(genInfoValues);
        System.out.print("]\n\n");
    }

    public void falseResult(String[] test, int numberOfFalses) {
        int counter = 0;
        for (int i = 2; i < test.length; i++) {
            if (!Property.contains(test[i].toUpperCase())){
                counter++;
                if (counter == 1) {
                    System.out.print("The properties [" + test[i].toUpperCase() + ", ");
                } else if (counter == numberOfFalses) {
                    System.out.println(test[i].toUpperCase() + "] are wrong.");
                    break;
                } else {
                    System.out.print(test[i].toUpperCase() + ", ");

                }

            }
        }

        System.out.print("Available properties: [");

        String genInfoValues = "";
        boolean firstRun = true;
        for (Property info : Property.values()) {
            if (firstRun) {
                firstRun = false;
                genInfoValues += info.name();
            } else {
                genInfoValues += ", " + info.name();
            }
        }

        System.out.print(genInfoValues);
        System.out.print("]\n\n");
    }


    public boolean occurrence(long number, String property) {
        Buzz buzz = new Buzz();
        Duck duck = new Duck();
        Palidromic palidromic = new Palidromic();
        Gapful gapeful = new Gapful();
        Odd odd = new Odd();
        Spy spy = new Spy();
        Square square = new Square();
        Square sunny = new Square();
        Jumping jumping = new Jumping();
        Happy happy = new Happy();

        if (property.equals("buzz") && buzz.getResult(number)) {
            return true;
        } else if (property.equals("duck") && duck.getResult(number)) {
            return true;
        } else if (property.equals("jumping") && jumping.getResult(number)) {
            return true;
        } else if (property.equals("palindromic") && palidromic.getResult(number)) {
            return true;
        } else if (property.equals("gapful") && gapeful.getResult(number)) {
            return true;
        } else if (property.equals("odd") && odd.getResult(number)) {
            return true;
        } else if (property.equals("even") && !odd.getResult(number)) {
            return true;
        } else if (property.equals("spy") && spy.getResult(number)) {
            return true;
        } else if (property.equals("square") && square.getResult(number)) {
            return true;
        } else if (property.equals("happy") && happy.getResult(number)) {
            return true;
        } else if (property.equals("sad") && !happy.getResult(number)) {
            return true;
        } else if (property.equals("sunny") && sunny.getResult(number + 1)) {
            return true;
        } else if (property.equals("-even") && odd.getResult(number)) {
            return true;
        } else if (property.equals("-odd") && !odd.getResult(number)) {
            return true;
        } else if (property.equals("-buzz") && !buzz.getResult(number)) {
            return true;
        } else if (property.equals("-duck") && !duck.getResult(number)) {
            return true;
        } else if (property.equals("-jumping") && !jumping.getResult(number)) {
            return true;
        } else if (property.equals("-palindromic") && !palidromic.getResult(number)) {
            return true;
        } else if (property.equals("-gapful") && !gapeful.getResult(number)) {
            return true;

        } else if (property.equals("-spy") && !spy.getResult(number)) {
            return true;
        } else if (property.equals("-square") && !square.getResult(number)) {
            return true;
        } else if (property.equals("-happy") && !happy.getResult(number)) {
            return true;
        } else if (property.equals("-sad") && happy.getResult(number)) {
            return true;
        } else if (property.equals("-sunny") && !sunny.getResult(number + 1)) {
            return true;
        }

        else
            return false;


    }

    public boolean occuranceArray(String[] arr, long number){
        Buzz buzz = new Buzz();
        Duck duck = new Duck();
        Palidromic palidromic = new Palidromic();
        Gapful gapeful = new Gapful();
        Odd odd = new Odd();
        Spy spy = new Spy();
        Square square = new Square();
        Square sunny = new Square();
        Jumping jumping = new Jumping();
        Happy happy = new Happy();

        for(int i = 2; i < arr.length; i++){
            if (arr[i].equals("buzz") && buzz.getResult(number)) {
                continue;
            } else if (arr[i].equals("duck") && duck.getResult(number)) {
                continue;
            } else if (arr[i].equals("jumping") && jumping.getResult(number)) {
                continue;
            } else if (arr[i].equals("palindromic") && palidromic.getResult(number)) {
                continue;
            } else if (arr[i].equals("gapful") && gapeful.getResult(number)) {
                continue;
            } else if (arr[i].equals("odd") && odd.getResult(number)) {
                continue;
            } else if (arr[i].equals("even") && !odd.getResult(number)) {
                continue;
            } else if (arr[i].equals("spy") && spy.getResult(number)) {
                continue;
            } else if (arr[i].equals("square") && square.getResult(number)) {
                continue;
            } else if (arr[i].equals("sunny") && sunny.getResult(number + 1)) {
                continue;
            } else if (arr[i].equals("happy") && happy.getResult(number)) {
                continue;
            } else if (arr[i].equals("sad") && !happy.getResult(number)) {
                continue;
            }else if (arr[i].equals("-duck")) {
                continue;
            } else if (arr[i].equals("-spy") && !spy.getResult(number)) {
                continue;

            }else
                return false;
        }



        return true;
    }


}