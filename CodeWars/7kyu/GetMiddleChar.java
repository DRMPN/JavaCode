class Kata {
    public static String getMiddle(String word) {
        int wordLength = word.length();
        int saved = wordLength / 2;
        if (wordLength == 1) {
            return word;
        } else if (wordLength % 2 == 0) {
            return word.substring(saved - 1, saved + 1);
        } else {
            return word.substring(saved, saved + 1);
        }
    }
}