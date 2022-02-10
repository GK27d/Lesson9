package com.kostina;

public class Lesson9 {
    public static void main(String[] args) {
        //System.out.println(getNumbers());
        //int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //binarySearch(array, 5);
        System.out.println(getMoney(10.00, 1) + " грн.");
    }

    //1) В банк положили s денег. Какой станет сумма вклада через n лет,
    // если процент 1,5% добавляется к сумме вклада ежемесячно. (сложный процент)
    //Написать метод который принимает 2 параметра - s, n и возвращает сумму денег на счету.
    public static double getMoney(double money, int years) {
        double deposit = 0;
        for (int i = 0; i < years * 12; i++) {
            deposit = money * 0.015;
            money += deposit;
        }
        money = money * 100 + 0.5;
        money = (int) money;
        return (double) money / 100;
    }

    //2) Реализовать метод который вернет строку String,
    // в которой через пробел все числа от 1 до 99 со следующими изменениями:
    //(!!!Сам метод не должен ничего печатать в консоль,
    // он просто должен вернуть строку!!!)
    //- если число кратно 3 то вывести вместо него Hello
    //- если число кратно 5 то вывести вместо него World
    //- если число кратно и 3 и 5 то вывести вместо него HelloWorld
    //- иначе вывести просто само число
    public static String getNumbers() {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < 100; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                result.append("HelloWorld ");
            } else if (i % 5 == 0) {
                result.append("World ");
            } else if (i % 3 == 0) {
                result.append("Hello ");
            } else {
                result.append(i).append(" ");
            }
        }
        return result.toString().trim();
    }


    //3*) Написать метод который ищет при помощи бинарного поиска есть ли число в отсортированном массиве.
    // Входящие параметры: массив и число.
    //(считаем что массива который нам передали отсортирован, проверять это не нужно)
    public static void binarySearch(int[] array, int item) {
        int first = 0;
        int last = array.length - 1;
        int position;
        position = (first + last) / 2;
        while ((array[position] != item) && (first <= last)) {
            if (array[position] > item) {
                last = position - 1;
            } else {
                first = position + 1;
            }
            position = (first + last) / 2;
        }
        if (first <= last) {
            System.out.println(item + " является " + ++position + " элементом в массиве");
        } else {
            System.out.println("Элемент не найден в массиве.");
        }
    }
}
