package br.com.brunoneofiti.app.city.model;

import java.util.Comparator;

public class City {

    private String name;
    private String provinces;
    private String country;

    
    public City() {
		super();
	}
    
    public City(String name) {
        this.name = name;
        this.provinces = null;
        this.country = null;
    }
	
    public City(String name, String provinces, String country) {
        this.name = name;
        this.country = country;
        this.provinces = provinces;
    }
    
    public static Comparator<City> CityNameComparator = new Comparator<City>() {
		
		public int compare(City c1, City c2) {
			//ascending order
			return c1.getName().toUpperCase().compareTo(c2.getName().toUpperCase());
		}
	};
    
	@Override
	public String toString() {
		return "City [name=" + name + ", provinces=" + provinces + ", country=" + country + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof City)) {
			return false;
		}
		City other = (City) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	public String getName() {
		return name;
	}
	public String getCountry() {
		return country;
	}


	public String getProvinces() {
		return provinces;
	}
    
}