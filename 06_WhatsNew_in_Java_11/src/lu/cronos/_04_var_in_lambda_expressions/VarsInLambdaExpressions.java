package lu.cronos._04_var_in_lambda_expressions;

interface Calcul{
	int sum(int a, int b);
}
public class VarsInLambdaExpressions {

	public static void main(String[] args) {
		
		 Calcul cal = (var a,  var b)-> a+b;		
		 int result = cal.sum(10, 20);
		 System.out.println(result);
		 
		 //Points To Remember
		 /*
		    (var s1, s2) -> s1 + s2      //no skipping allowed
            (var s1, String y) -> s1 + y //no mixing allowed

             var s1 -> s1 //not allowed. Need parentheses if you use var in lambda.
		  */
	}
}
