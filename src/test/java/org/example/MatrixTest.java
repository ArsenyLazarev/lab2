package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {

    @Test
    void testStolbChoose() {
        int[][] testData = {
                {10, 20, 60},  // столбец 2: 60,70 > 50
                {30, 40, 70}   // столбец 2 не подходит
        };

        Matrix testMatrix = new Matrix(2, 3, 50, testData);
        testMatrix.stolbChoose();

        // Должны найтись только столбцы 0 и 1
        assertEquals(2, testMatrix.k);
        assertEquals(0, testMatrix.mas[0]);
        assertEquals(1, testMatrix.mas[1]);
    }

    @Test
    void testStolbChooseNoValidColumns() {
        int[][] testData = {
                {100, 200},  // оба > 10
                {300, 400}   // оба > 10
        };

        Matrix testMatrix = new Matrix(2, 2, 10, testData);
        testMatrix.stolbChoose();

        assertEquals(0, testMatrix.k); // не должно быть подходящих столбцов
    }

    @Test
    void testFinalFunc() {
        int[][] testData = {
                {2, 3},  // столбец 0: 2*4=8, столбец 1: 3*5=15
                {4, 5}
        };

        Matrix testMatrix = new Matrix(2, 2, 100, testData);
        testMatrix.mas = new int[]{0, 1}; // оба столбца подходят
        testMatrix.k = 2;
        testMatrix.minProduct = Long.MAX_VALUE;

        testMatrix.finalFunc();

        assertEquals(8, testMatrix.minProduct); // минимальное произведение
        assertEquals(0, testMatrix.number);     // в столбце 0
    }
}