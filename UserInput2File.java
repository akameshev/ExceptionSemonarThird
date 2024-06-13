import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class UserInput2File {
    public static void main(String[] args) throws InvalidDataException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате c пробелом:" +
                "Фамилия Имя Отчество дата_рождения тел_номер пол(f или m)");
        String input = scanner.nextLine();
        System.out.println(input);
        String[] data = input.split(" ");
        validData(data);
        writeToFile(data);
    }

    private static void validData(String[] data) throws InvalidDataException {
        if (data.length != 6)throw new InvalidDataException("Не все данные введены, " +
                "либо добавлено лишнее, предпологалось 6 аргументов");
        String name = data[0];
        String secondName = data[1];
        String thirdName = data[2];
        String dateOfBirth = data[3];
        String phoneNumber = data[4];
        String gender = data[5];

        if (!dateOfBirth.matches("\\d{2}.\\d{2}.\\d{4}"))
            throw new InvalidDataException("Вы ввели дату с ошибкой, введите данные в формате dd.mm.yyyy");
        if (!phoneNumber.matches("\\d+"))
            throw new InvalidDataException("Вы ввели неверный номер телефона, нужно целое число без знаков");
        if (!gender.matches("[fm]"))
            throw new InvalidDataException("Вы неверно указали пол, допускается только f и m");

    }

    private static void writeToFile(String[] data)throws IOException{
        String name = data[0];
        String fileName = name+".txt";
        try(FileWriter writer = new FileWriter(fileName,true)){
            writer.write(String.join(" ", Arrays.toString(data) + "\n"));
            writer.flush();
        }
    }

}
