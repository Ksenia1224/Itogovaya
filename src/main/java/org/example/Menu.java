package org.example;

import lombok.Data;

@Data
public class Menu {
    public static void mainMenu() {

        System.out.println("Выберите действие\n" +
                "1 - добавить нового человека в биржу\n" +
                "2 - показать всех людей в бирже\n" +
                "3 - удалить человека в бирже\n" +
                "4 - поиск человек в бирже\n" +
                "5 - закрыть программу\n");


    }
}

