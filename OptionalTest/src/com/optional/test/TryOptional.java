package com.optional.test;

import java.util.NoSuchElementException;
import java.util.Optional;

public class TryOptional {
	public static void main(String[] args) {
		
		Optional<Person> nikhil = Optional.ofNullable(new Person());
		Optional<Car> honda = Optional.ofNullable(new Car()); 
		Optional<Insurance> insurance = Optional.ofNullable(new Insurance()); 
		
		//insurance.get().setName("LIC");
		
		//honda.get().setInsurance(insurance);
		
		nikhil.get().setCar(honda);
		
		//System.out.println(nikhil.isPresent());
		
		//if(nikhil.get().getCar().get().getInsurance().isPresent())
		//{
			System.out.println(getCarInsuranceName(nikhil));
			System.out.println(getCarInsuranceNameType2(nikhil));
		//}
	}
	
	//only map
	private static String getCarInsuranceName(Optional<Person> person)
	{
		//System.out.println(person.flatMap(guy->guy.getCar()).map(car -> car.getInsurance()));
		try{
		return person.map(guy -> guy.getCar())
		.map(car -> car.get().getInsurance())
		.map(insurance -> insurance.get().getName()).orElse("xyz");
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		return null;
	}
	
	//with flatmap
	private static String getCarInsuranceNameType2(Optional<Person> person)
	{
		return person.flatMap(guy -> guy.getCar())
				.flatMap(car -> car.getInsurance())
				.map(insurance -> insurance.getName()).orElse("xyz");
	}
}
