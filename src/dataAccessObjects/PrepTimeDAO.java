package dataAccessObjects;

import java.util.ArrayList;
import java.util.List;

/*
 * This DataAccessObject Class contains data that's stored and returned in a List Collection
 * The returned list object can then be accessed in the JSP page using JSTL(Java Server Pages Tag Library) & EL(Expression language)
*/
public class PrepTimeDAO {	
	
	public static List<Double> prepTime() throws Exception {
		List<Double> prepTime = new ArrayList<Double>();

		prepTime.add(new Double (0.15));
	    prepTime.add(new Double (0.30));
	    prepTime.add(new Double (0.45));
	    prepTime.add(new Double (1.00));
	    prepTime.add(new Double (1.15));
	    prepTime.add(new Double (1.30));
	    prepTime.add(new Double (1.45));
	    prepTime.add(new Double (2.00));
	    prepTime.add(new Double (2.15));
	    prepTime.add(new Double (2.30));
	    prepTime.add(new Double (2.45));
	    prepTime.add(new Double (3.00));
	    prepTime.add(new Double (3.15));
	    prepTime.add(new Double (3.30));
	    prepTime.add(new Double (3.45));
	    prepTime.add(new Double (4.00));
	    prepTime.add(new Double (4.15));
	    prepTime.add(new Double (4.30));
	    prepTime.add(new Double (4.45));
	    prepTime.add(new Double (5.00));
	    prepTime.add(new Double (5.15));
	    prepTime.add(new Double (5.30));
	    prepTime.add(new Double (5.45));
	    prepTime.add(new Double (6.00));
		
		return prepTime;
	}
}