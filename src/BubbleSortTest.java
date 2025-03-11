import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BubbleSortTest {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello! Press 1 to generate an array of random integers, sort them, and store to a file.");
        System.out.println("Press 2 to read a file, sort it, and store into another file");

        Scanner scanner = new Scanner(System.in);
        int nextResponse = scanner.nextInt();

        if (nextResponse == 1) {
            System.out.println("Enter the length of the array: ");
            int arrayLength = scanner.nextInt();
            int[] array = createRandomArray(arrayLength);
            System.out.println("Here is your array before it is sorted:");
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i] + " ");
            }
            System.out.println("Here is your array after it is sorted:");
            bubbleSort(array);
            writeArrayToFile(array, "sortedArray.txt");
            
            
        }

        if (nextResponse == 2) {
            System.out.println("Enter the name of the file:");
            String filename = scanner.next();
            int[] array = readFileToArray(filename);
            System.out.println("Here is your array before it is sorted:");
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i] + " ");
            }
            System.out.println("Here is your array after it is sorted:");
            bubbleSort(array);
            writeArrayToFile(array, "sortedArray2.txt");

        }
        scanner.close();
    }
    

    public static int[] createRandomArray(int arrayLength){
        Random random = new Random();
        int[] array = new int[arrayLength];
        for(int i = 0; i < arrayLength; i++){
            array[i] = random.nextInt(100); 
        }
        return array;
    }

    public static void bubbleSort(int[] array) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for(int i = 0; i < array.length - 1; i++) {
                if(array[i] > array[i+1]) {
                    swapped = true;
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            
        }
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void writeArrayToFile(int[] array, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for(int i = 0; i < array.length; i++){
            writer.write(array[i] + " ");
            writer.newLine();
        }
        writer.close();
    }

    public static int[] readFileToArray(String filename) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int count = 0;
        String line;
        while((line  = reader.readLine()) != null) {
            count++;
        }
        int[] array = null;
        if (count > 0) {
            array = new int[count];
            int index = 0;
            reader.close();
            reader = new BufferedReader(new FileReader(filename));
            while((line = reader.readLine()) != null){
                String[] values = line.split(" ");
                for(String value : values){
                    array[index++] = Integer.parseInt(value);
                }
            }
        }
        
        reader.close();
        return array;
    }
}



    

