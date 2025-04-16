package common.textutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtil {

    public static String extractTextByRegex(String inputText, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }
}
