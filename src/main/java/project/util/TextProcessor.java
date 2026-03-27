package project.util;

public class TextProcessor {
        //método: usa os espaços em branco como separação
    public static String[] splitWords(String line) {
        return line.split("\\s+");
    }
}
