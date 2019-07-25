package com.test.task1;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
	
	private static final String FOS_COMSCI = "Computer Science";
	private static final String FOS_BUST = "Business Studies";
	private static final String FOS_PHY = "Physics";
	
	private static University university = new University();
	
	/**
	 * @return The names of students who study computer science
	 */
	public static Collection<String> listComputerScienceStudentNames() {
		List<String> comsciStudents = new ArrayList<>();
		
		university.getStudents().stream()
				.filter(s -> FOS_COMSCI.equalsIgnoreCase(s.getFieldOfStudy()))
				.collect(Collectors.toList())
				.forEach(s -> comsciStudents.add(s.getName()));
		
		return comsciStudents;
	}
	
	/**
	 * @param fieldOfStudy An optional filter. If provided then the result contains only
	 * those students studying that field. Otherwise all graduated students will be returned.
	 * @return The set of graduated students matching the filter.
	 */
	public static Collection<Student> listGraduatedStudents(Optional<String> fieldOfStudy) {
		Predicate<Student> hasGraduated = s -> s.getHasGraduated() == true;
		Predicate<Student> isEqualToFieldOfStudy = s -> s.getFieldOfStudy().equalsIgnoreCase(fieldOfStudy.get());
		
		return university.getStudents().stream()
				.filter(hasGraduated.and(isEqualToFieldOfStudy))
				.collect(Collectors.toList());
	}
	
	/**
	 * @return A Map containing a list of students per each subject that they study (i.e. the key is their fieldOfStudy).
	 */
	public static Map<String, List<Student>> groupStudentsByFieldOfStudy() {
		List<String> subjectList = new ArrayList<>();
		subjectList.add(FOS_COMSCI);
		subjectList.add(FOS_BUST);
		subjectList.add(FOS_PHY);
		
		/**
		 * not yet working
		 */
//		university.getStudents().stream()
//			//.filter(s -> subjectList.stream().anyMatch(subj -> subj.equalsIgnoreCase(s.getFieldOfStudy())))
//			.flatMap(subjectList -> subjectList.stream().map(sl -> new AbstractMap.SimpleImmutableEntry<>(subjectList, sl) {
//			}))
//			.filter()
//			.findFirst();
			
		return null;
	}


	
	public static void main(String[] args) {
		//System.out.println(listComputerScienceStudentNames());
		
//		Collection<Student> graduatedStudents = listGraduatedStudents(Optional.empty());
//		Collection<Student> gradStudWithFOS = listGraduatedStudents(Optional.of(FOS_BUST));
//		Collection<Student> gradStudWithFOS = listGraduatedStudents(Optional.of(FOS_PHY));
		System.out.println("pause to inspect collection");
		
		groupStudentsByFieldOfStudy();
	}
}