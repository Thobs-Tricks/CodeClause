import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Please Enter your expression below:\nN.B: Enter C to Exit!");

        Scanner scan = new Scanner(System.in);

        boolean run = true;

        do
        {
            String exp = scan.nextLine();

            if(exp.equalsIgnoreCase("C"))
            {
                System.out.println("Exited.");
                run = false;

            }else
            {
                double result1 = 0;

                if(exp.contains("+"))
                {
                    ArrayList<Double> values = calculate(exp, "+");
                    
                    result1 = (values.get(0) + values.get(1));
                    System.out.println("= " + result1);

                }else if(exp.contains("-"))
                {
                    ArrayList<Double> values = calculate(exp, "-");
                    
                    result1 = (values.get(0) - values.get(1));                    
                    System.out.println("= " + result1);

                }else if(exp.contains("*"))
                {
                    ArrayList<Double> values = calculate(exp, "*");
                    
                    result1 = (values.get(0) * values.get(1));
                    System.out.println("= " + result1);

                }else if(exp.contains("/"))
                {
                    ArrayList<Double> values = calculate(exp, "/");
                    
                    if(values.get(1) == 0 || exp.contains("//") || exp.contains("/*"))
                    {
                        System.err.println("MATHS ERROR!!!");

                    }else if(exp.contains("/-"))
                    {
                        result1 = (values.get(0) / (- values.get(1)));
                        System.out.println("= " + result1);
                    }else
                    {
                        result1 = (values.get(0) / values.get(1));
                        System.out.println("= " + result1);
                    }
                    
                }else
                {
                    System.err.println("Wrong Expression!!");
                }
            }
        }while(run);
    }

    public static ArrayList<Double> calculate(String exp, String ope)
    {
        //separting the values based on an opeartor
        StringTokenizer st = new StringTokenizer(exp, ope);
        double value1 = Double.parseDouble(st.nextToken());
        double value2 = Double.parseDouble(st.nextToken());
        System.out.println(value1 + " " + value2);

        ArrayList<Double> dblValues = new ArrayList<>();

        dblValues.add(value1);
        dblValues.add(value2);

        return dblValues;
    }
}
