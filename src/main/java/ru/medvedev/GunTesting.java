package main.java.ru.medvedev;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class GunTesting {
    public static void gunTesting(int theme) throws IOException {

        ArrayList arrayListQ = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayListA = new ArrayList();
        ArrayList list = new ArrayList();
        FileInputStream fstream = new FileInputStream("src\\main\\resources\\test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int countTrue = 0;
        int i = 0;

        while ((strLine = br.readLine()) != null) {
            switch (i){
                case 0:
                    arrayListQ.add(strLine);
                    i++;
                    continue;
                case 1:
                    arrayList1.add(strLine);
                    i++;
                    continue;
                case 2:
                    arrayList2.add(strLine);
                    i++;
                    continue;
                case 3:
                    arrayList3.add(strLine);
                    i++;
                    continue;
                case 4:
                    arrayListA.add(strLine);
                    i++;
                    continue;
                case 5:
                    i = 0;
            }
        }

        for (int ptr = 0; i < 10; i ++){
            list.add(new Random().nextInt(theme));
        }
        Collections.sort(list);

        for(int p = 0; p < 10; p++){
            System.out.println(arrayListQ.get((Integer) list.get(p)));
            System.out.println(arrayList1.get((Integer) list.get(p)));
            System.out.println(arrayList2.get((Integer) list.get(p)));
            System.out.println(arrayList3.get((Integer) list.get(p)));
            System.out.println("Введите ответ(1,2,3): ");
            Scanner console = new Scanner(System.in);
            String name = console.nextLine();
            if (name.equals(arrayListA.get((Integer) list.get(p)))){
                System.out.println("Верно!");
                countTrue++;
            }
            else {
                System.out.println("Неверно!");
                System.out.println("Правильный ответ: " + arrayListA.get((Integer) list.get(p)));
            }
        }
        if (countTrue == 9 || countTrue == 10){
            System.out.println("Вы сдали!Ваш результат - " + countTrue + "/10");
        }else{
            System.out.println("Вы не сдали! Ваш результат - " + countTrue + "/10");
        }
    }
}
