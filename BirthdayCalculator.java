import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BirthdayCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Узнаём дату рождения
        System.out.println("Введите дату рождения (в формате дд.мм.гггг).И не забудьте точки!:");
        String birthDateString = scanner.nextLine();

        // Уточняем текущую дату
        System.out.println("Введите текущую дату (в формате дд.мм.гггг) Да и тут их тоже поставьте:");
        String currentDateString = scanner.nextLine();

        try {
            // Переводим данные от пользователя в даты
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate birthDate = LocalDate.parse(birthDateString, formatter);
            LocalDate currentDate = LocalDate.parse(currentDateString, formatter);

            // Считаем дни с рождения до сегодня
            long daysSinceBirth = ChronoUnit.DAYS.between(birthDate, currentDate);

            // Считаем время до юбилея
            long daysToNext10000 = 10000 - (daysSinceBirth % 10000);
            long daysToNext20000 = 20000 - (daysSinceBirth % 20000);
            long daysToNext30000 = 30000 - (daysSinceBirth % 30000);

            // Итоги
            System.out.println("Количество дней с момента рождения: " + daysSinceBirth);
            System.out.println("До юбилея в 10000 дней осталось: " + daysToNext10000 + " дней");
            System.out.println("До юбилея в 20000 дней осталось: " + daysToNext20000 + " дней");
            System.out.println("До юбилея в 30000 дней осталось: " + daysToNext30000 + " дней");
        } catch (DateTimeParseException e) {
            // Тут ловим ошибки и пихаем их обратно пользователю
            System.out.println("Дата введена некорректно");
        }

        scanner.close();
    }
}
