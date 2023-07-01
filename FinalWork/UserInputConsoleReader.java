package FinalWork;

import java.util.Scanner;

public class UserInputConsoleReader implements UserInputReader {
  private Scanner scanner;

  public UserInputConsoleReader(Scanner scanner) {
    this.scanner = scanner;
  }

  @Override
  public UserData readUserData() throws UserDataException {
    while (true) {
      System.out.println("Введите данные через пробел в следующем порядке: Фамилия Имя Отчество Номер телефона");

      try {
        String input = scanner.nextLine();
        String[] data = input.split(" ");

        if (data.length != 4) {
          throw new UserDataException("Введено неверное количество данных! Попробуйте еще раз!");
        }

        long phoneNumber = parsePhoneNumber(data[3]);
        
        return new UserData(data[0], data[1], data[2], phoneNumber);
      } catch (ParseException | NumberFormatException e) {
        System.out.println("Ошибка: " + e.getMessage());
      }
    }
  }

  private long parsePhoneNumber(String phoneNumberString) throws ParseException {
    try {
      return Long.parseLong(phoneNumberString);
    } catch (NumberFormatException e) {
      throw new ParseException("Неверный формат ввода номера телефона!");
    }
  }

}
