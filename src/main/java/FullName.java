import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FullName{
    public static void main(String[] args) {
        String surName = "Java";
       String[] surName1 = {"J", "A","V","A"};
        List<String> firstName = Arrays.asList(new String[]{"C", "C++", "C#", "P"});
        int size = firstName.size();
        IntStream.range(0, size).forEach((n)-> System.out.println(fullName(surName,firstName).get(n++)));
        IntStream.range(0, size).forEach((n)-> System.out.println(fullName1(surName1,firstName).get(n++)));
//        AtomicInteger i = new AtomicInteger();
//        firstName.forEach((n)->
//                System.out.println(fullName(surName,firstName).get(i.getAndIncrement()))
//        );
    }


    public static List<String>  fullName(String surName, List<String> firstName){
        List<String> fullName = new ArrayList<>();
        for (String fName : firstName) {
            fullName.add(fName+" "+surName);
        }
        return fullName;
    }

    public static List<String>  fullName1(String[] surName, List<String> firstName){
        List<String> fullName = new ArrayList<>();
        int i=0;
        for (String fName : firstName) {
            fullName.add(fName+" "+surName[i]);
            i++;
        }
        return fullName;
    }
}