package aqa_exam.task12;

import java.util.UUID;

public class Generator {
    public static String generateText(Integer minLength, Integer maxLength){
        return UUID.randomUUID().toString().substring(minLength, maxLength);
    }
}
