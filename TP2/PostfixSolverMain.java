import java.io.*;

public class PostfixSolverMain 
{
	public static void main(String[] args) throws IOException 
	{
        String s1 = "0 1 or";
        String s2 = "0 0 or";
        String s3 = "1 1 or";
        String s4 = "1 0 or";

        try {
            if (!solve(s1) || solve(s2) || !solve(s3) || !solve(s4)) {
                System.out.println("Erreur : résultat de l'opération or invalide.");
                return;
            }
        }
        catch (ParsingErrorException ex) {
            System.out.println("Erreur : le solveur a rencontré un problème.");
        }

        String s5 = "0 0 and";
        String s6 = "0 1 and";
        String s7 = "1 0 and";
        String s8 = "1 1 and";

        try {
            if (solve(s5) || solve(s6) || solve(s7) || !solve(s8)) {
                System.out.println("Erreur : résultat de l'opération and invalide.");
                return;
            }
        }
        catch (ParsingErrorException ex) {
            System.out.println("Erreur : le solveur a rencontré un problème.");
        }

        String s9 = "0 not";
        String s10 = "1 not";

        try {
            if (!solve(s9) || solve(s10)) {
                System.out.println("Erreur : résultat de l'opération not invalide.");
                return;
            }
        }
        catch (ParsingErrorException ex) {
            System.out.println("Erreur : le solveur a rencontré un problème.");
        }

        System.out.print("PostfixSolver: It's all good");
     }
	 
	 public static boolean solve(String input) throws ParsingErrorException
     {
        // À compléter
        ArrayStack<Boolean> stack = new ArrayStack<>();
        //L'expression est séparée en tokens selon les espaces.
        for (String token : input.split("\\s")) {
        	if (token.equals("1"))
        	{ stack.push(true); }
        	
        	else if (token.equals("0"))
        	{ stack.push(false);}
        	
        	else if (token.equals("not"))
        	{ stack.push(!stack.pop());}
        	
        	else if (token.equals("and"))
        	{
        		boolean temp1 = stack.pop();
        		boolean temp2 = stack.pop();
        		if (temp1 ==true && temp2 == true)
        		{stack.push(true);}
        		
        		else {stack.push(false);}
        	}
        	
        	else if (token.equals("or"))
        	{
        		boolean temp1 = stack.pop();
        		boolean temp2 = stack.pop();
        		if (temp1 ==false && temp2 == false)
        		{stack.push(false);}
        		
        		else {stack.push(true);}
        	}
        	
        }
        	return stack.pop();
    }
}
