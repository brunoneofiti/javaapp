package br.com.brunoneofiti.app.common.util;

public final class EqualsUtil {

	static public boolean areEqual(boolean objOne, boolean objTwo){
		return objOne == objTwo;
	}

	static public boolean areEqual(char objOne, char objTwo){
		return objOne == objTwo;
	}
	
	/**
	* Implementation Note
	* Note that byte, short, and int are handled by this method, through implicit conversion
	 * @param objOne
	 * @param objTwo
	 * @return
	 */
  static public boolean areEqual(long objOne, long objTwo){
		return objOne == objTwo;
	}
  
	static public boolean areEqual(float objOne, float objTwo){
		return Float.floatToIntBits(objOne) == Float.floatToIntBits(objTwo);
	}
	
	static public boolean areEqual(double objOne, double objTwo){
		return Double.doubleToLongBits(objOne) == Double.doubleToLongBits(objTwo);
	}
	
	static public boolean areEqual(String objOne, String objTwo){
		return objOne.equals(objTwo);
	}
	
	/**
	* Possibly-null object field.
	*
	* Includes type-safe enumerations and collections, but does not include
	* arrays. See class comment.
	*/
	static public boolean areEqual(Object objOne, Object objTwo){
		return objOne == null ? objTwo == null : objOne.equals(objTwo);
	}	
}