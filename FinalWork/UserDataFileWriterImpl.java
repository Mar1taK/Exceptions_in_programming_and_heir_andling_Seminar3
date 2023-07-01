package FinalWork;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class UserDataFileWriterImpl implements UserDataFileWriter {

  @Override
  public void writeUserData(UserData userData) throws IOException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите имя файла для записи данных: ");
    String fileName = scanner.nextLine();
    FileWriter writer = new FileWriter(fileName, true);
    String userDataString = String.join(" ",
        userData.getLastName(),
        userData.getFirstName(),
        userData.getMiddleName(),
        String.valueOf(userData.getPhoneNumber()));
    
    writer.write(userDataString + "\n");
    writer.close();
    System.out.println("Данные успешно записаны в файл: " + fileName);
  }
}
