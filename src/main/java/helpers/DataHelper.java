package helpers;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;


public class DataHelper {
    private static final Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.letterify("??????????@gmail.com");
    }

    public static String getRandomPassword(int number) {
        return RandomStringUtils.randomAlphanumeric(number);
    }

    public static String getRandomPID(int number) {
        return RandomStringUtils.randomNumeric(number);
    }

    public static String getValidPID(int number) {
        return RandomStringUtils.randomNumeric(number);
    }
}
