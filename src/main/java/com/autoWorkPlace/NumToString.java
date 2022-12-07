package com.autoWorkPlace;

import java.util.ArrayList;
import java.util.HashMap;

public class NumToString {
    private ArrayList<Integer> number = new ArrayList<>();
    private String string = "";
    private HashMap<Integer, String> table = new HashMap<>();

    public NumToString() {
        this.table.put(1, "один");
        this.table.put(2, "два");
        this.table.put(3, "три");
        this.table.put(4, "четыре");
        this.table.put(5, "пять");
        this.table.put(6, "шесть");
        this.table.put(7, "семь");
        this.table.put(8, "восемь");
        this.table.put(9, "девять");
        this.table.put(10, "десять");
        this.table.put(11, "одиннадцать");
        this.table.put(12, "двенадцать");
        this.table.put(13, "тринадцать");
        this.table.put(14, "четырнадцать");
        this.table.put(15, "пятнадцать");
        this.table.put(16, "шестнадцать");
        this.table.put(17, "семнадцать");
        this.table.put(18, "восемнадцать");
        this.table.put(19, "девятнадцать");
        this.table.put(20, "двадцать");
        this.table.put(30, "тридцать");
        this.table.put(40, "сорок");
        this.table.put(50, "пятьдесят");
        this.table.put(60, "шестьдесят");
        this.table.put(70, "семдесят");
        this.table.put(80, "восемдесят");
        this.table.put(90, "девяносто");
        this.table.put(100, "сто");
        this.table.put(200, "двести");
        this.table.put(300, "триста");
        this.table.put(400, "четыреста");
        this.table.put(500, "пятьсот");
        this.table.put(600, "шестьсот");
        this.table.put(700, "семьсот");
        this.table.put(800, "Восемсот");
        this.table.put(900, "девятсот");
        this.table.put(1000,"тысяча");
    }

    public void setNumber(int number) {
        System.out.println(number);
        int len = String.valueOf(number).length();
        int temp = number;
        int num;
        String numStr = "";
        for(int i = 0; i < len; i++){
            num = temp%10;
            temp = temp/10;
            for(int j = 0; j < i; j++){
                num *= 10;
            }
            if (num > 1000000) {
                num /= 1000000;
                if (num < 10) numStr = " миллионов";
                else numStr = "";
            }
            else
            if (num > 1000) {
                num /= 1000;
                if (num < 10) numStr = " тысяч";
                else numStr = "";
            }

            // System.out.print(num + " ");
            string = string + numStr + " " + this.table.get(num);
            //string = string + this.table.get(num) + " " + numStr;

        }
        System.out.println(string);
        this.getString();
    }



    public String getString() {
        String[] temp = this.string.split(" ");
        string = "";
        for (int i = temp.length-1; i > 0; i--){
            string = string +" "+ temp[i];
        }
        System.out.println(string);
        return string;
    }
}
