package ru.vtb.javaPro;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        // удаление из листа всех дубликатов
        System.out.println(List.of(1,4,4,2,6,7,3,6,5,2,6,10).stream()
                .distinct()
                .collect(Collectors.toList()));
        System.out.println("-------------");

        // Найдите в списке целых чисел 3-е наибольшее число
        System.out.println(List.of(5,2,10,9,4,3,10,1,13).stream()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .limit(3)
                .min((x1, x2) -> (x1 - x2))
                .orElseThrow(() -> new RuntimeException("Получено пустое значение (null)"))
        );
        System.out.println("-------------");

        // Найдите в списке целых чисел 3-е наибольшее «уникальное» число
        System.out.println(List.of(5,2,10,9,4,3,10,1,13).stream()
                .distinct()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .limit(3)
                .min((x1, x2) -> (x1 - x2))
                .orElseThrow(() -> new RuntimeException("Получено пустое значение (null)")));
        System.out.println("-------------");

        // получить список имен 3 самых старших сотрудников с должностью «Инженер», в порядке убывания возраста
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

        // посчитайте средний возраст сотрудников с должностью Инженер
        System.out.println(companyList.stream()
                .filter(post -> post.getPost().equals("Инженер"))
                .map(Company::getAge)
                .mapToInt(i -> i)
                .average()
                .orElseThrow(() -> new RuntimeException("Получено пустое значение (null)")));
        System.out.println("-------------");

        // Find the longest word in the list
        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, "Мороз", "и", "солнце", "день", "чудесный", "Еще", "ты", "дремлешь", "друг", "прелестный");
        System.out.println(stringList.stream()
                .max((x1, x2) -> (x1.length() - x2.length()))
                .orElseThrow(() -> new RuntimeException("Получено пустое значение (null)")));
        System.out.println("-------------");

        //  Постройте хеш-мапы, в которой будут хранится пары: слово - сколько раз оно встречается во входной строке
        String str = "и раз и два и три пять четыре три два раз";
        System.out.println(Arrays.asList(Arrays.stream(str.split(" "))
                        .collect(
                                Collectors.groupingBy(k -> k
                                    ,Collectors.counting()
                        )))
        );
        System.out.println("-------------");

        // Отпечатайте в консоль строки из списка в порядке увеличения длины слова,
        // если слова имеют одинаковую длины, то должен быть сохранен алфавитный порядок
        List<String> stringList2 = new ArrayList<>();
        Collections.addAll(stringList2, "и", "раз", "и", "два", "и", "три", "пять", "три", "два", "прелестный");

        stringList2.stream()
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
        System.out.println("-------------");

        //  Найдите в списке слов самое длинное
        String[] strings = new String[5];
        strings[0] = "Мороз и солнце день чудесный";
        strings[1] = "Еще ты дремлешь друг прелестный";
        strings[2] = "Вечор ты помнишь вьюга злилась";
        strings[3] = "На мутном небе мгла носилась";
        strings[4] = "Блестя на солнце снег лежит";

        System.out.println(Arrays.asList(Arrays.stream(List.of(strings)
                        .stream()
                        .collect(Collectors.joining(" "))
                        .split(" "))
                        .max((x1, x2) -> (x1.length() - x2.length()))
                        .orElseThrow(() -> new RuntimeException("Получено пустое значение (null)")))
        );
    }

}
