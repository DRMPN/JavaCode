public class Kata {

    public static String encrypt(final String text, final int n) {
      
      if (text == "") return "";
      if (text == null) return null;
      
      var txt = text;
      var times = n;
      
      while (times > 0) {
          String odd = "";
          String even = "";
        
          for (int i = 0; i < txt.length(); i++) {
              if (i % 2 == 0) {
                  even += txt.charAt(i);
              } else {
                  odd += txt.charAt(i);
              }
          }
          txt = odd + even;
          times--;
      }
      
      return txt;   
    }
    
    public static String decrypt(final String encryptedText, final int n) {
      if (encryptedText == "") return "";
      if (encryptedText == null) return null;
      
      return null;
    }
    
  }