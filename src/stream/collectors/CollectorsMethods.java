package stream.collectors;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CollectorsMethods {

    // 1. Visited COLLECTORS office
    // 2. there was LIST SET and MAP of applicants
    // 3. I received JOINING letter
    // 4. I started COUNTING of applicants
    // 5. Using AVERAGINGINT and SUMMERIZINGINT i get stats
    // 6. Then found MIN and MAX salary applicant
    // 7. I GROUPED by them as per area
    // 8 Then i PARTITIONED on selected vs Rejected
    // 9 Then after MAPPING and REDUCING, Asked the to COLLECTANDTHEN go back
    public static void main(String[] args) {

        //========= toList
        List<String> list = Stream.of("A", "B", "C")
                .collect(Collectors.toList());
        System.out.println("1. toList::"+list); // [A, B, C]

        //========= toSet
        Set<Integer> set = Stream.of(1, 2, 2, 3)
                .collect(Collectors.toSet());
        System.out.println("2. toSet::"+set); // [1, 2, 3]

        //========= toMap
        List<Student> students = List.of(
                new Student(1, "Alice"),
                new Student(2, "Bob")
               // new Student(2, "Bob2") // Exception duplicate key
        );

        Map<Integer, String> map = students.stream()
                .collect(Collectors.toMap(s -> s.id, s -> s.name));
        System.out.println("3. toMap::"+map);

        //========= joining
        String result = Stream.of("Java", "Spring", "Boot")
                .collect(Collectors.joining(""));
        System.out.println("4. joining ::"+result); // JavaSpringBoot

        String result2 = Stream.of("Java", "Spring", "Boot")
                .collect(Collectors.joining(", "));
        System.out.println("4.1 joining delimiter ::"+result2); // Java, Spring, Boot

        String result3 = Stream.of("Java", "Spring", "Boot")
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("4.2 joining prefix and suffix ::"+result3); // [Java, Spring, Boot]

        //========= counting
        long count = Stream.of("A", "B", "C")
                .collect(Collectors.counting());
        System.out.println("5. counting ::"+count);

        //========= summarizingInt() / summarizingDouble() / summarizingLong()
        IntSummaryStatistics stats = Stream.of(10, 20, 30, 40)
                .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("6. summarizingInt ::"+stats); //{count=4, sum=100, min=10, average=25.000000, max=40}
        System.out.println("Max is:"+stats.getMax());

        DoubleSummaryStatistics stats2 = DoubleStream.of(23.5,55.0,243.6)
                .boxed()
                .collect(Collectors.summarizingDouble(d -> d));
        System.out.println("6.1 summarizingDouble ::"+stats2);

        LongSummaryStatistics stats3 = LongStream.of(23L,55L,2433L)
                .boxed()
                .collect(Collectors.summarizingLong(l -> l));
        System.out.println("6.2 summarizingLong ::"+stats3);

        //========= averagingInt() / averagingDouble() / averagingLong()
        double avg = Stream.of(10, 20, 30)
                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("7 averagingInt ::"+avg); // 20.0

        //========= maxBy() / minBy()
        Optional<Integer> maxVal = Stream.of(10, 3, 45, 28)
                .collect(Collectors.maxBy(Integer::compareTo));
        System.out.println("8 maxBy() :::"+maxVal.get()); // 45

        Optional<Integer> minVal = Stream.of(10, 3, 45, 28)
                .collect(Collectors.minBy(Integer::compareTo));
        System.out.println("8.1 minBy() :::"+minVal.get()); // 3

        //========= groupingBy
        List<Employee> emps = List.of(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> byDept = emps.stream()
                .collect(Collectors.groupingBy(e -> e.dept));
        System.out.println("9 groupingBy:: "+byDept);

        //========= partitioningBy
        List<Integer> numbers = List.of(5, 10, 15, 20);
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n > 10));
        System.out.println("10 partitioned:: "+partitioned);

        Map<Boolean, List<Integer>> partitioned2 = numbers.stream().collect(
                Collectors.partitioningBy(n-> n % 2 == 0)
        );
        System.out.println("10.1 partitioned:: "+partitioned2);


        //========= mapping
        Map<String, List<String>> namesByDept = emps.stream()
                .collect(Collectors.groupingBy(
                        e -> e.dept,
                        Collectors.mapping(e -> e.name, Collectors.toList())
                ));
        System.out.println("11. mapping :: "+namesByDept);
// {HR=[Alice, Carol], IT=[Bob]}


        //========= reducing, Equivalent to stream.reduce(0, Integer::sum) but in collector form.
        int total = Stream.of(10, 20, 30)
                .collect(Collectors.reducing(0, (a, b) -> a + b));
        System.out.println("12. reducing :: "+total); // 60

        int total2 = Stream.of(10, 20, 30).reduce(0, Integer::sum);
        System.out.println("12.1 reducing :: "+total2); // 60

        //========= collectingAndThen , Apply one collector, then apply a finishing function (post-processing).
        List<String> immutableList = Stream.of("A", "B", "C")
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));



    }
}

class Student {
    int id; String name;
    Student(int id, String name) { this.id = id; this.name = name; }
}

class Employee {
    String dept;
    String name;
    Employee(String name, String dept) { this.name = name; this.dept = dept; }
}