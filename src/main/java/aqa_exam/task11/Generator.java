package aqa_exam.task11;

import java.util.UUID;

public class Generator {
    public static String generateText(Integer minLength, Integer maxLength){
        return UUID.randomUUID().toString().substring(minLength, maxLength);
    }
}
