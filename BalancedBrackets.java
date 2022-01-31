import java.util.*;
 
public class BalancedBrackets{
 
    public boolean isBracketBalance(String exp)
    {
        
        Deque<Character> stack= new ArrayDeque<Character>();
 
        for (int i = 0; i < exp.length(); i++)
        {
            char x = exp.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            {

                stack.push(x);
                continue;
            }
 
        
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 

        return (stack.isEmpty());
    }
 
    public static void main(String[] args)
    {
	BalancedBrackets bb=new BalancedBrackets();
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter the brackets to checked if it is balanced :-   ");
        String exp = sc.nextLine();
 
        if (bb.isBracketBalance(exp))
            System.out.println("The entered String has Balanced Brackets");
        else
            System.out.println("The entered Strings do not contain Balanced Brackets ");
    }
}