package org.example;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
    int number = -1;
    int k = 0;
    int a = 0;
    int b = 0;
    int n = 0;
    long minProduct = Long.MAX_VALUE; // используем long для больших произведений
    int[][] matr;
    int[] mas;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public Matrix() {
        System.out.print("Введите количество строк ");
        a = scanner.nextInt();
        System.out.print("Введите количество столбцов ");
        b = scanner.nextInt();
        System.out.print("Введите число n ");
        n = scanner.nextInt();

        matr = new int[a][b];
        mas = new int[b];

        for(int i = 0; i < a; i++) {
            for(int j = 0; j < b; j++) {
                matr[i][j] = random.nextInt(200) - 100;
            }
        }
    }
    public Matrix(int a, int b, int n, int[][] testData) {//для тестов
        this.a = a;
        this.b = b;
        this.n = n;
        this.matr = testData;
        this.mas = new int[b];
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    void stolbChoose() {

        for(int j = 0; j < b; j++) {
            boolean c = true;

            // Проверяем ВСЕ элементы столбца j
            for(int i = 0; i < a; i++) {
                if(Math.abs(matr[i][j]) > Math.abs(n)) {
                    c = false;
                    break;
                }
            }

            if (c) {
                mas[k] = j;
                k++;

            }
        }

    }

    void finalFunc() {
        if (k == 0) {
            System.out.println("Нет подходящих столбцов");
            return;
        }


        for(int colIndex = 0; colIndex < k; colIndex++) {
            int curColumn = mas[colIndex];
            long product = 1;

            for(int i = 0; i < a; i++) {
                product *= matr[i][curColumn];
            }

            System.out.println("Столбец " + curColumn + ": произведение = " + product);

            if (product < minProduct) {
                minProduct = product;
                number = curColumn;
            }
        }

        System.out.println("\nМинимальное произведение: " + minProduct + " в столбце " + number);
    }

    void showMatrix() {
        System.out.println("\nМатрица:");
        for(int i = 0; i < a; i++) {
            for(int j = 0; j < b; j++) {
                System.out.print(matr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.showMatrix();
        matrix.stolbChoose();
        matrix.finalFunc();
    }
}