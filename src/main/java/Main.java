import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // 1. Leap year check
        int year = 2020;
        System.out.println(isLeapYear(year));

        // 2. Localized date for India
        LocalDate date = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Date for India: " + date);

        // 3. Date in the specified format
        ZonedDateTime now = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy, d, D, HH:mm");
        System.out.println("Formatted date: " + now.format(formatter));

        // 4. Birthdate
        LocalDate birthDate = LocalDate.of(1992, 3, 21);
        DateTimeFormatter birthDateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("ua"));
        System.out.println("Birthdate: " + birthDate.format(birthDateFormatter));

        // 5. Checking the day of the week
        System.out.println("Day of the week: " + birthDate.getDayOfWeek());
        LocalDate anotherDate = LocalDate.of(2024, 8, 1);
        System.out.println("Day of the week for another date: " + anotherDate.getDayOfWeek());

        // 6. Subtracting 10 years
        LocalDate newDate = birthDate.minusYears(10);
        System.out.println("Date minus 10 years: " + newDate.format(birthDateFormatter));

        // 7. Instant from string
        Instant instant = Instant.parse("2022-12-19T06:55:30.00Z");
        System.out.println("Instant: " + instant);

        // 8. ZonedDateTime from Pacific/Midway
        ZonedDateTime midwayTime = ZonedDateTime.now(ZoneId.of("Pacific/Midway"));
        System.out.println("Pacific/Midway time: " + midwayTime);

        // 9. Age of a person
        LocalDate birthDateForAge = LocalDate.of(1992, 3, 21);
        System.out.println("Age: " + calculateAge(birthDateForAge, LocalDate.now()));

        // 10. Time until work
        ZonedDateTime wakeUpTime = ZonedDateTime.now();
        ZonedDateTime workStartTime = wakeUpTime.withHour(9).withMinute(0).withSecond(0);
        long minutesUntilWork = ChronoUnit.MINUTES.between(wakeUpTime, workStartTime);
        if (minutesUntilWork > 0) {
            System.out.println("Time until work: " + minutesUntilWork + " minutes");
        } else {
            System.out.println("You overslept by: " + Math.abs(minutesUntilWork) + " minutes");
        }
    }

    public static boolean isLeapYear(int year) {
        return LocalDate.of(year, 1, 1).isLeapYear();
    }

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if (birthDate != null && currentDate != null) {
            return (int) ChronoUnit.YEARS.between(birthDate, currentDate);
        } else {
            return 0;
        }
    }
}

