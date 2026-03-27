package project.util;

public class TextProcessor {
    //método: limpa o texto (pontuação, virgula e maiusculo)
    public static String cleanText(String line) {
        return line.replaceAll("[^a-zA-ZÀ-ÿ ]", "").toLowerCase();
    }

    //método: usa os espaços em branco como separação
    public static String[] splitWords(String line) {
        return line.split("\\s+");
    }
}
