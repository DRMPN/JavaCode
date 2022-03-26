public class Abbreviator {

    private String abbrHelper(String word) {
        int len = word.length();
        if (len > 3) {
            word = "" + word.charAt(0) + (len - 2) + word.charAt(len - 1);
        }
        return word;
    }

    public String abbreviate(String string) {
        String word = "";
        String answer = "";
        for (char ch : string.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                word += ch;
            } else {
                word = abbrHelper(word);
                word += ch;
                answer += word;
                word = "";
            }
        }
        answer += abbrHelper(word);
        return answer;
    }

}