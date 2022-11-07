package com.autoWorkPlace;

import java.util.ArrayList;
import java.util.HashMap;

public class NumToString {
    private HashMap<Integer, String> number = new HashMap<>();
    private String string = "";
    private HashMap<Integer, String> table = new HashMap<>();

    public NumToString() {
        this.table.put(1, "Один");
        this.table.put(2, "Два");
        this.table.put(3, "Три");
        this.table.put(4, "Четыре");
        this.table.put(5, "Пять");
        this.table.put(6, "Шесть");
        this.table.put(7, "Семь");
        this.table.put(8, "Восемь");
        this.table.put(9, "Девять");
        this.table.put(10, "Десять");
        this.table.put(11, "Одиннадцать");
        this.table.put(12, "Двенадцать");
        this.table.put(13, "Тринадцать");
        this.table.put(14, "Четырнадцать");
        this.table.put(15, "Пятнадцать");
        this.table.put(16, "Шестнадцать");
        this.table.put(17, "Семнадцать");
        this.table.put(18, "Восемнадцать");
        this.table.put(19, "Девятнадцать");
        this.table.put(20, "Двадцать");
        this.table.put(30, "Тридцать");
        this.table.put(40, "Сорок");
        this.table.put(50, "Пятьдесят");
        this.table.put(60, "Шестьдесят");
        this.table.put(70, "Семдесят");
        this.table.put(80, "Восемдесят");
        this.table.put(90, "Девяносто");
        this.table.put(100, "Сто");
        this.table.put(200, "Двести");
        this.table.put(300, "Триста");
        this.table.put(400, "Четыреста");
        this.table.put(500, "Пятьсот");
        this.table.put(600, "Шестьсот");
        this.table.put(700, "Семьсот");
        this.table.put(800, "Восемсот");
        this.table.put(900, "Девятсот");
        this.table.put(1000,"Тысяча");
    }

    public void setNumber(int number) {
        int len = String.valueOf(number).length();
        int temp = number;
        int num;
        for(int i = 0; i < len; i++){
            num = temp%10;
            temp = temp/10;
            for(int j = 0; j < i; j++){
                num *= 10;
            }
            if (num > 1000000) num /= 1000000;
            else
            if (num > 1000) num /= 1000;

            System.out.print(num + " ");
            System.out.println(this.table.get(num));
        }
    }

    public String getString() {
        for(int i = 0; i < this.number.size(); i++){
            string = string + table.get(i);
        }

        return string;
    }
}
