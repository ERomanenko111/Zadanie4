package ru.stormsar;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //4.1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String str = scanner.nextLine();
        System.out.println("Введите подстроку:");
        String subStr = scanner.nextLine();
        int count = countSubstringOccurrences(str, subStr);
        System.out.println("Подстрока встречается в строке " + count + " раз");
        // Ввод строки
        System.out.println("Введите строку:");
        String inputString = scanner.nextLine();

        //4.2
        // Замена слов
        String newString = inputString.replaceAll("\\b(кака|бяка)\\b", "вырезано цензурой");
        // Вывод результата
        System.out.println("Результат замены:");
        System.out.println(newString);

        //4.3
        System.out.print("Введите дату в формате (дд.мм.гггг): ");
        String date = scanner.nextLine();
        // Разделение даты на день, месяц и год
        String[] dateParts = date.split("\\.");
        // Переформатирование строки даты в формат "гггг-мм-дд"
        String newDate = dateParts[2] + "-" + dateParts[1] + "-" + dateParts[0];
        // Вывод нового формата даты
        System.out.println("Дата в новом формате: " + newDate);

        //4.4
        String inputDate = "31.12.2020";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date1 = inputFormat.parse(inputDate);
            String outputDate = outputFormat.format(date1);

            System.out.println("Входная дата: " + inputDate);
            System.out.println("Преобразованная дата: " + outputDate);
        } catch (ParseException e) {
            System.out.println("Ошибка парсинга даты");
        }
    }



    public static int countSubstringOccurrences(String str, String subStr) {
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {
            lastIndex = str.indexOf(subStr, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += subStr.length();
            }
        }

        return count;


    }
}