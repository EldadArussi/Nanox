package common.seleniumutils.collectionutils;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListUtil {

    public static <T> T getRandomElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
