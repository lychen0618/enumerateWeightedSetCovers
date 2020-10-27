import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;

public class MyHelpFunc {
    public static void creatDataSetsForMSC(int universeSize, int numOfSets, String fileName) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fileName));
        osw.write(universeSize + " " + numOfSets + "\n");
        for (int i = 0; i < numOfSets; ++i) {
            osw.write(1 + " ");
            if (i != numOfSets - 1 && i != 0 && i % 10 == 0) osw.write("\n");
        }
        osw.write("\n");

        Random rmv = new Random();
        Random rms = new Random();
        for (int i = 0; i < universeSize; ++i) {
            int size = rmv.nextInt(numOfSets) - 10;
            if (size <= 0) size = 1;
            osw.write(size + " \n");
            int[] generateSet = new int[size];
            boolean[] flag = new boolean[numOfSets + 1];
            int num = 0;
            while (num < size) {
                while (true) {
                    int newInt = rms.nextInt(numOfSets) + 1;
                    if (!flag[newInt]) {
                        flag[newInt] = true;
                        generateSet[num++] = newInt;
                        break;
                    }
                }
            }
            for (int j = 0; j < size; ++j) {
                osw.write(generateSet[j] + " ");
                if (j != size - 1 && j != 0 && j % 10 == 0) osw.write("\n");
            }
            osw.write("\n");
        }

        osw.close();
    }

    public static void main(String[] args) throws IOException {
        String fileName = "tests/paper/example1.txt";

        creatDataSetsForMSC(20, 30, fileName);
    }
}
