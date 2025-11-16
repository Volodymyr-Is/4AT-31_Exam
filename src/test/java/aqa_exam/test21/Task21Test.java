package aqa_exam.test21;

import org.junit.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.io.File;

import static aqa_exam.task21.ScreenHelper.makeScreenshot;

public class Task21Test {
    @Test
    public void calcTest() throws FindFailed {
//        Screen screen = new Screen();
//        Pattern pattern = new Pattern(
//                new File("src/main/resources/pattern/searchInput.png")
//                        .getAbsolutePath());
//        screen.find(pattern).click();
//
//        screen.type("calc");
//        screen.type(Key.ENTER);
//        makeScreenshot();

        Screen screen = new Screen();
        Pattern patternCalc = new Pattern(
                new File("src/main/resources/pattern/calcButton.png")
                        .getAbsolutePath());
        screen.find(patternCalc).click();

        Pattern patternButton2 = new Pattern(
                new File("src/main/resources/pattern/button2.png")
                        .getAbsolutePath());
        screen.find(patternButton2).click();

        Pattern patternButtonPlus = new Pattern(
                new File("src/main/resources/pattern/buttonPlus.png")
                        .getAbsolutePath());
        screen.find(patternButtonPlus).click();

        screen.find(patternButton2).click();

        Pattern patternButtonEqual = new Pattern(
                new File("src/main/resources/pattern/buttonEqual.png")
                        .getAbsolutePath());
        screen.find(patternButtonEqual).click();

        makeScreenshot();
    }
}
