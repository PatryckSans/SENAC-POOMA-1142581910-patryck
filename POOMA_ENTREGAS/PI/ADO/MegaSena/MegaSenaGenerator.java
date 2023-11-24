package POOMA_ENTREGAS.PI.ADO.MegaSena;

import java.util.Arrays;
import java.util.Random;

public class MegaSenaGenerator {

    public int[] sortearNumeros() {
        int[] numerosSorteados = new int[6];
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int numero = random.nextInt(60) + 1;
            while (contains(numerosSorteados, numero)) {
                numero = random.nextInt(60) + 1;
            }
            numerosSorteados[i] = numero;
        }

        Arrays.sort(numerosSorteados);
        return numerosSorteados;
    }

    private boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
}
