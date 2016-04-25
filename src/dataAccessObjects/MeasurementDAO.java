package dataAccessObjects;

import java.util.ArrayList;
import java.util.List;

import beans.MeasureType;

/*
 * This DataAccessObject Class contains data that's stored and returned in a List Collection
 * The returned list object can then be accessed in the JSP page using JSTL(Java Server Pages Tag Library) & EL(Expression language)
*/
public class MeasurementDAO {

	public static List<MeasureType> measureType() throws Exception{
		
		List<MeasureType> measureType = new ArrayList<MeasureType>();
		
		measureType.add(new MeasureType("Number"));
		measureType.add(new MeasureType("Pinch"));
		measureType.add(new MeasureType("Teaspoon"));
		measureType.add(new MeasureType("Tablespoon"));
		measureType.add(new MeasureType("Fl.oz"));
		measureType.add(new MeasureType("Cup"));
		measureType.add(new MeasureType("Pint"));
		measureType.add(new MeasureType("ml"));
		measureType.add(new MeasureType("Litre"));
		measureType.add(new MeasureType("Pound"));
		measureType.add(new MeasureType("Ounce"));
		measureType.add(new MeasureType("mg"));
		measureType.add(new MeasureType("g"));
		measureType.add(new MeasureType("kg"));
		measureType.add(new MeasureType("Meter"));
		measureType.add(new MeasureType("Inch"));
		measureType.add(new MeasureType("cm"));
		measureType.add(new MeasureType("mm"));
		
		return measureType;
	}
}