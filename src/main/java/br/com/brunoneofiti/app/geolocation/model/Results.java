package br.com.brunoneofiti.app.geolocation.model;

import java.util.List;

public class Results {

	private List<AddressComponent> addressComponents;
	
	private String formattedAddress;

	private Geometry geometry;
	
	private String placeId;
	
	private String types;
	
	
	
	public List<AddressComponent> getAddressComponents() {
		return addressComponents;
	}

	public void setAddressComponents(List<AddressComponent> addressComponents) {
		this.addressComponents = addressComponents;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "Results [addressComponents=" + addressComponents + ", formattedAddress=" + formattedAddress
				+ ", geometry=" + geometry + ", placeId=" + placeId + ", types=" + types + "]";
	}

	
}