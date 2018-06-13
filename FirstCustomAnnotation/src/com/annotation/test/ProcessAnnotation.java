package com.annotation.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class ProcessAnnotation {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Class demoClass = DemoClass.class;
		readAnnotation(demoClass);
		Method demoMethod = demoClass.getMethod("just", new Class[]{});
		readAnnotation(demoMethod);
	}

	private static void readAnnotation(AnnotatedElement element) {
		Annotation[] annotations = element.getAnnotations();
		for(Annotation annotation : annotations){
			if(annotation instanceof CustomAnnotation){
				CustomAnnotation custAnn = (CustomAnnotation) annotation;
				System.out.println(custAnn.author());
				System.out.println(custAnn.version());
			}
		}
	}
}
