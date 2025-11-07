package stream.deep;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StreamCollectors {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("John", "Jane", "Adam", "Eve");

        List<String> toList = names.stream().collect(Collectors.toList());
        List<String> toList2 = names.stream().toList();

        Set<String> toSet = names.stream().collect(Collectors.toSet());
        // there is no toSet()

        TreeSet<String> treeSet = names.stream().collect(Collectors.toCollection(TreeSet::new));


    }
}
