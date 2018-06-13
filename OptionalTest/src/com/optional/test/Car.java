package com.optional.test;

import java.util.Optional;

public class Car {

	private Optional<Insurance> insurance;

	Car(){
		insurance = Optional.empty();
	}
	public Optional<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(Optional<Insurance> insurance) {
		this.insurance = insurance;
	}
	
}
