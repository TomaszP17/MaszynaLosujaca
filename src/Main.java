import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<String> array = new ArrayList<>();
        try {
            saveToArrayFromFile(array);
            savetoFileFromArray(array);
            System.out.print("the program completed successfully");
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
    private static void saveToArrayFromFile(ArrayList<String> array)throws IOException {
        File file = new File("pytania.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String pytanie = scanner.nextLine();
            array.add(pytanie);
        }
    }
    private static void savetoFileFromArray(ArrayList<String> array)throws FileNotFoundException{
        File file = new File("answers.txt");
        PrintWriter printWriter = new PrintWriter(file);
        ArrayList<String> copy = new ArrayList<>(array);
        String result = "";
        int iterator = 1;
        while (!copy.isEmpty()) {
            int drawnIndex = (int)(Math.random()*copy.size());
            String drawnElement = copy.get(drawnIndex);
            result += (iterator++) + ". " + drawnElement + "\n";
            copy.remove(drawnIndex);
        }
        printWriter.write(result);
        printWriter.close();
    }
}
