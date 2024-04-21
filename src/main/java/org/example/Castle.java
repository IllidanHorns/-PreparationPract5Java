package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Castle {
    private static double treasury;

    private static long count_of_humans = 1;

    public ArrayList<String> buildings = new ArrayList<>(Arrays.asList("Ратуша"));

    public int guard = 1;

    public double guard_efficiency_coefficient = 1;

    public static String king = "Джофри";

    public static void execute(long count){
        if (count <= 0){
            System.out.println("Нельзя казнить - " + count + " человек");
        }
        else if (count <= count_of_humans){
            count_of_humans -= count;
            System.out.println("В замке было казнено - " + count + " человек");
        }
        else {
            System.out.println("Нельзя так делать!");
        }
    }

    public static void born_people(long kef_of_born){
        long womans = count_of_humans / 2;
        if (kef_of_born < 0){
            System.out.println("Рожать не могут отрицательно!");
        }
        else{
            count_of_humans += womans * kef_of_born;
            System.out.println("В замке родилось " + womans * kef_of_born + " человек");
        }
    }

    public static void SaveOrSpend(double amount_of_money)
    {
        if (amount_of_money > 0) {
            treasury += amount_of_money;
            System.out.println("Казна была пополнена на " + amount_of_money + " монет");
        }
        else if (amount_of_money < 0){
            if (amount_of_money / -1 <= treasury)
            {
                treasury += amount_of_money;
                System.out.println("Из казны потрачено " + amount_of_money / -1 + " монет");
            }
            else {
                System.out.println("Нельзя потратить больше монет чем есть в казне!");
            }
        }
        else {
            System.out.println("Нельзя пополнить казну на 0 монет!");
        }
    }

    public Boolean create_build(String name_of_build, int cost)
    {
        for (var i : buildings){
            if (i == name_of_build)
            {
                System.out.println("Такое здание уже существует");
                return false;
            }
        }
        if (cost > 0)
        {
            buildings.add(name_of_build);
            System.out.println("Построено здание " + name_of_build);
            System.out.println("Из казны взято " + cost);
            return true;
        }
        else {
            System.out.println("Здание не может стоить меньше нуля!");
            return false;
        }
    }

    public Boolean destroy_build(String name_of_build)
    {
        for (var i : buildings){
            if (i == name_of_build)
            {
                buildings.remove(name_of_build);
                System.out.println("Разрушено здание " + name_of_build);
                return true;
            }
        }
        System.out.println("Такого здание нет в замке!");
        return false;
    }

    public Boolean sell_build(String name_of_build, int cost)
    {
        for (var i : buildings){
            if (i == name_of_build)
            {
                if (cost > 0)
                {
                    buildings.remove(name_of_build);
                    System.out.println("Продано здание " + name_of_build);
                    System.out.println("В казну поступило " + cost);
                    return true;
                }
                else
                {
                    System.out.println("Цена не может быть меньше нуля!");
                    return false;
                }
            }
        }
        System.out.println("Такого здание нет в замке!");
        return false;
    }

    public void get_tax(double count_of_money_for_tax){
        if (count_of_money_for_tax > 0) {
            double tax_from_people = count_of_humans * count_of_money_for_tax;
            double tax_from_buildings = buildings.size() * count_of_money_for_tax * 10;
            double sum_of_tax = tax_from_people + tax_from_buildings;
            treasury += sum_of_tax;
            System.out.println("В казну поступило " + sum_of_tax + " монет");
        }
        else
        {
            System.out.println("Налог не может быть отрицательным!");
        }
    }

    public Boolean hire_a_guard(int count)
    {
        if (count > 0)
        {
            if (treasury <= count)
            {
                System.out.println("В казне недостаточно монет для найма стражи!");
                return false;
            }
            else
            {
                guard += count;
                treasury -= count;
                System.out.println("Стража пополнилась на " + count + " человек");
                System.out.println("Из казны было взято " + count + " монет");
                return true;
            }
        }
        else
        {
            System.out.println("Нельзя нанять отрицательное кол-во человек!");
            return false;
        }
    }

    public Boolean train_the_guard()
    {
        if (treasury >= guard*0.1)
        {
            if (guard_efficiency_coefficient < 2)
            {
                treasury -= guard*0.1;
                guard_efficiency_coefficient += 0.1;
                System.out.println("Эффективность гвардии повышена!");
                System.out.println("Из казны было взято " + guard_efficiency_coefficient + " монет");
                return true;
            }
            else
            {
                System.out.println("Гвардия максимально обучена!");
                return false;
            }
        }
        else
        {
            System.out.println("В казне недостатоно средств для обучения стражи!");
            return false;
        }
    }

    public double check_guard_power()
    {
        System.out.println("Мощь гвардии - " + guard_efficiency_coefficient * guard);
        return guard_efficiency_coefficient * guard;
    }

    public static Boolean new_king(String king_name)
    {
        if (king_name != null && !king_name.isEmpty())
        {
            king = king_name;
            System.out.println("Да здравствует новый король " + king_name);
            return true;
        }
        else
        {
            System.out.println("Король " + king + " всё ещё у престола!");
            return false;
        }
    }
}


