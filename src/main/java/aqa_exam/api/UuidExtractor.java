package aqa_exam.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UuidExtractor {

    private static final Pattern UUID_PATTERN = Pattern.compile(
            "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}"
    );

    private static final Pattern UUID_STRICT_PATTERN = Pattern.compile(
            "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"
    );

    public static String extractUuid(String jsonText) {
        Matcher matcher = UUID_PATTERN.matcher(jsonText);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}