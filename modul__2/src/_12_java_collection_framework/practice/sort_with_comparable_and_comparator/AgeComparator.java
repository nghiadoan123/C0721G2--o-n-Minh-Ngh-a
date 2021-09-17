package _12_java_collection_framework.practice.sort_with_comparable_and_comparator;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getAge().compareTo(student2.getAge());
//        if (student1.getAge() > student2.getAge()) {
//            return 1;
//        } else if (student1.getAge() == student2.getAge()) {
//            return 0;
//        } else {
//            return -1;
//        }
    }
}
