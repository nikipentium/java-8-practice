package com.ideacrest.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionsLambdaPractice {
	
	final static int LEGAL_VOTING_AGE = 18;
	final static List<String> VALID_DOCUMENTS = Arrays.asList("aadhaar","voter-id");
	
	static ArrayList<Person> list = new ArrayList<Person>() {
		private static final long serialVersionUID = 1L;
		{
			add(new Person("Nikhil",Arrays.asList("aadhaar","voter-id") , 18));
			add(new Person("Piyush",Arrays.asList() , 28));
			add(new Person("Oj",Arrays.asList() , 15));
			add(new Person("Lola",Arrays.asList("voter-id") , 25));
		}
	};
	
	public static void main(String[] args) {

		//displayNames(list);
		System.out.println("Those who can vote are :");
		//displayVoters(list);
		//displayVotersAndNonVoters(list);
		//more generalized!
		processPersons(list,p->p.getName() ,canVote(LEGAL_VOTING_AGE,VALID_DOCUMENTS) , System.out::println);
	}
	
	public static Predicate<Person> canVote(int legalVotingAge, List<String> validDocuments) {
		return p -> p.getAge() >= legalVotingAge && p.getDocuments().containsAll(validDocuments);
	}
	
	public static void displayNames(List<Person> list)
	{
		list.forEach(person -> System.out.println(person.getName()));
		//list.forEach(System.out::println);
	}
	
	public static void displayVoters(List<Person> list)
	{
		list.stream().filter(canVote(LEGAL_VOTING_AGE,VALID_DOCUMENTS)).forEach(p -> System.out.println(p.getName()));;
	}

	public static void displayVotersAndNonVoters(List<Person> list)
	{
		Map<Boolean,List<Person>> peopleMap= list.stream().collect(Collectors.partitioningBy(canVote(LEGAL_VOTING_AGE,VALID_DOCUMENTS)));
		peopleMap.forEach((canVote,peopleList) -> {
			if(canVote)
				peopleList.forEach(p->System.out.println(p.getName()+" can Vote"));
			else
				peopleList.forEach(p->System.out.println(p.getName()+" cannot Vote"));
		});
	}
	public static <X,T> void processPersons(List<X> personList, Function<X,T> mapper, Predicate<X> eligibiltyCriteria, Consumer<T> action)
	{
		personList.stream().filter(eligibiltyCriteria).map(mapper).forEach(action);
	}
}
