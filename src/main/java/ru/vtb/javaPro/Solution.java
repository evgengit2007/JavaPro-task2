package ru.vtb.javaPro;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        // delete double
        System.out.println(List.of(1,4,4,2,6,7,3,6,5,2,6,10).stream()
                .distinct()
                .collect(Collectors.toList()));
        System.out.println("-------------");

        // 3rd largest number
        System.out.println(List.of(5,2,10,9,4,3,10,1,13).stream()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .limit(3).min((x1, x2) -> (x1 - x2))
                .get());
        System.out.println("-------------");

        // 3rd largest "unique" number
        System.out.println(List.of(5,2,10,9,4,3,10,1,13).stream()
                .distinct()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .limit(3)
                .min((x1, x2) -> (x1 - x2))
                .get());
        System.out.println("--------------");

        // list of names of the 3 most senior employees with the title of "Engineer", in descending order of age
        List<Company> companyList = List.of(
                new Company("Иванов", 25, "Инженер"),
                new Company("Петров", 50, "Директор"),
                new Company("Сидоров", 48, "Инженер"),
                new Company("Горгадзе", 20, "Программист"),
                new Company("Тихонова", 22, "Секретарь"),
                new Company("Бендер", 34, "Инженер"),
                new Company("Безухов", 30, "Инженер")
        );
        companyList.stream()
                .filter(post -> post.getPost().equals("Инженер"))
                .sorted((x1, x2) -> (x2.getAge() - x1.getAge()))
                .limit(3)
                .map(Company::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("-------------");

        // average age of employees with the position of "Engineer"
        System.out.println(companyList.stream()
                .filter(post -> post.getPost().equals("Инженер"))
                .map(Company::getAge)
                .mapToInt(i -> i)
                .average()
                .orElse(0));
        System.out.println("-------------");

        // Find the longest word in the list
        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, "Мороз", "и", "солнце", "день", "чудесный", "Еще", "ты", "дремлешь", "друг", "прелестный");
        System.out.println(stringList.stream()
                .max((x1, x2) -> (x1.length() - x2.length()))
                .get());
        System.out.println("-------------");

        // hashMap, pairs: word - how many times it occurs in the input string
        String str = "и раз и два и три пять четыре три два раз";
        System.out.println(Arrays.asList(str.split(" ")).stream()
                .distinct()
                .collect(Collectors.toMap(k -> k, k -> Arrays.asList(str.split(" "))
                        .stream()
                        .filter(x -> (x.equals(k)))
                        .count())))
        ;
        System.out.println("-------------");

        // lines from the list in order of increasing word length, if words have the same length, then the alphabetical order should be preserved
        List<String> stringList2 = new ArrayList<>();
        Collections.addAll(stringList2, "и", "раз", "и", "два", "и", "три", "пять", "три", "два", "прелестный");
        stringList2.stream()
                .sorted(Collections.reverseOrder((x1, x2) -> (x2.compareTo(x1))))
                .sorted((x1, x2) -> (x1.length() - x2.length()))
                .forEach(System.out::println);
        System.out.println("-------------");

        // get the longest word
        String[] strings = new String[5];
        strings[0] = "Мороз и солнце день чудесный";
        strings[1] = "Еще ты дремлешь друг прелестный";
        strings[2] = "Вечор ты помнишь вьюга злилась";
        strings[3] = "На мутном небе мгла носилась";
        strings[4] = "Блестя на солнце снег лежит";
        System.out.println(Arrays.asList(List.of(strings)
                        .stream()
                        .collect(Collectors.joining(" "))
                        .split(" "))
                .stream()
                .max((x1, x2) -> (x1.length() - x2.length()))
                .get());
    }

}
