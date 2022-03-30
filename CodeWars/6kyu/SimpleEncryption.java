public class Kata {

  public static String encrypt(final String text, final int n) {

    if (text == null)
      return null;

    var txt = text;

    for (int jk = n; jk > 0; jk--) {
      var odd = "";
      var even = "";

      for (int i = 0; i < txt.length(); i++) {
        if (i % 2 == 0) {
          even += txt.charAt(i);
        } else {
          odd += txt.charAt(i);
        }
      }
      txt = odd + even;
    }

    return txt;
  }

  public static String decrypt(final String encryptedText, final int n) {

    if (encryptedText == null)
      return null;

    var txt = encryptedText;

    var txtLen = txt.length();
    var evenStart = txtLen / 2;

    for (int jk = n; jk > 0; jk--) {

      var tmp = "";

      for (int i = 0; i < evenStart; i++) {
        tmp += txt.charAt(i + evenStart);
        tmp += txt.charAt(i);
      }
      if (txtLen % 2 != 0)
        tmp += txt.charAt(txtLen - 1);

      txt = tmp;
    }

    return txt;
  }

}