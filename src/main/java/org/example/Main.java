package org.example;

import com.google.gson.Gson;

import java.awt.*;
import java.util.InputMismatchException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ListTrud truds = new ListTrud();
        File file = new File("./file.txt");
        if (file.createNewFile()) {
            System.out.println("Файл успешно был создан");
        }else {
            System.out.println("Файл уже существует, можете вводить данные");
        }
        try (FileReader fileReader = new FileReader(file)) {
            Scanner fileScanner = new Scanner(fileReader);
            if (fileScanner.hasNextLine()){
                String str2 = fileScanner.nextLine();
                Gson gson = new Gson();
                truds = gson.fromJson(str2, ListTrud.class);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден ");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        byte menu = 0;

        do {
            Menu.mainMenu();
            try {
                menu = scanner.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введите только число из меню.");
                scanner.nextLine();
                continue;
            }
            switch (menu) {
                case (1) -> {
                    Birgha birgha = new Birgha();
                    System.out.println("Введите профессию безработного");
                    scanner.nextLine();
                    birgha.setProff(scanner.nextLine());
                    System.out.println("Введите образование безработного");
                    birgha.setEdication(scanner.nextLine());

                    System.out.println("Введите место последней работы безработного");
                    birgha.setPlaceJob(scanner.nextLine());

                    System.out.println("Введите должность прошлой работы безработного");
                    birgha.setDoljnost(scanner.nextLine());

                    System.out.println("Введите причину увольнения безработного");
                    birgha.setReason(scanner.nextLine());

                    System.out.println("Введите семейное положение безработного");
                    birgha.setSemPog(scanner.nextLine());

                    System.out.println("Введите статус ваших жилищных условий безработного");
                    birgha.setUslovie(scanner.nextLine());

                    System.out.println("Введите контактные координаты безработного");
                    birgha.setCoordinat(scanner.nextLine());

                    System.out.println("Введите требования  к будущей работе"); //324234
                    birgha.setTreb(scanner.nextLine());

                    if (truds.getData() == null) {
                        List<Birgha> temp = new ArrayList<>(); //cvdfg
                        temp.add(birgha);
                        truds.setData(temp);
                    } else {
                        truds.getData().add(birgha);
                    }
                    System.out.println("Безработный успешно добавлен! ");
                }

                case (2) -> truds.getData().forEach(System.out::println);
                case (3) -> {
                   System.out.println("Введите любое сведение о безработном, которого хотите удалить:");
                    scanner.nextLine();
                    String deleteBirga = scanner.nextLine();
                    List<Birgha> deleteResult = new ArrayList<>();
                    for (Birgha b : truds.getData()) {
                        if (b.getProff().equalsIgnoreCase(deleteBirga)
                                || b.getEdication().equalsIgnoreCase(deleteBirga)
                                || b.getPlaceJob().equalsIgnoreCase(deleteBirga)
                                || b.getDoljnost().equalsIgnoreCase(deleteBirga)
                                || b.getReason().equalsIgnoreCase(deleteBirga)
                                || b.getSemPog().equalsIgnoreCase(deleteBirga)
                                ||b.getUslovie().equalsIgnoreCase(deleteBirga)
                                ||b.getCoordinat().equalsIgnoreCase(deleteBirga)
                                ||b.getTreb().equalsIgnoreCase(deleteBirga)) {
                          deleteResult.add(b);
                       }
                    }
                    if (deleteResult.isEmpty()) {
                        System.out.println("Безработный не найден");

                    } else {
                        for (Birgha b : deleteResult) {
                            System.out.println("Удалить безработного? (Да - удалить, Нет - не удалять)\n" + b);
                            String k = scanner.nextLine();
                            if (k.equalsIgnoreCase("Да")) {
                                truds.getData().remove(b);
                                System.out.println("Безработный удален");
                            } else {
                                System.out.println("Безработный не удален");
                            }
                        }

                    }
                }
                case (4) -> {
                    System.out.println("Введите любой параметр для поиска безработного: ");
                    scanner.nextLine();
                    String textSearch = scanner.nextLine();
                    List<Birgha> searchResult = new ArrayList<>();
                    for (Birgha b : truds.getData()) {
                        if (b.getProff().equalsIgnoreCase(textSearch)
                                || b.getEdication().equalsIgnoreCase(textSearch)
                                || b.getPlaceJob().equalsIgnoreCase(textSearch)
                                || b.getDoljnost().equalsIgnoreCase(textSearch)
                                || b.getReason().equalsIgnoreCase(textSearch)
                                || b.getSemPog().equalsIgnoreCase(textSearch)
                                ||b.getUslovie().equalsIgnoreCase(textSearch)
                                ||b.getCoordinat().equalsIgnoreCase(textSearch)
                                ||b.getTreb().equalsIgnoreCase(textSearch)) {
                            searchResult.add(b);
                        }
                    }

                    if (searchResult.isEmpty()) {
                        System.out.println("Безработный не найден!");
                    } else {
                        searchResult.forEach(System.out::println);
                    }
                }
                case (5) -> {
                    Gson gson = new Gson();
                    String str1 = gson.toJson(truds);
                    try (FileWriter fileWriter = new FileWriter(file)) {
                        fileWriter.write(str1);
                        System.out.println("Данные успешно сохранены в файле.");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("До свидания!");
                }
                default -> System.out.println("Ошибка! Недопустимый формат ");
            }
        }
        while (menu != 5) ;

    }
}
