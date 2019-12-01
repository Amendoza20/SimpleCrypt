import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    int encrypt;
    int decrypt;
    Character cs;
    Character cf;
    ROT13(Character cs, Character cf) {
        encrypt = cf - cs;
        decrypt = 26 - encrypt;
        this.cs= cs;
        this.cf = cf;
    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {

        return "";
    }

    public String encrypt(String text) {
        return cryptRotate(text, (char) encrypt);
    }

    public String decrypt(String text) {
        return cryptRotate(text, (char) decrypt);
    }

    public static String rotate(String s, Character c) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
           if(c.equals(s.charAt(i))){
             stringBuilder.append(s.substring(i)).append(s.substring(0,i));
             break;
           }
       }
       return stringBuilder.toString();


    }

    public static String cryptRotate(String s, Character c){
        int rotate = Character.getNumericValue(c) - Character.getNumericValue(c);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char nextChar = s.charAt(i);
            if (Character.isUpperCase(nextChar)) {
                stringBuilder.append((char) ((nextChar + rotate - 65) % 26 + 65));
            } else if (Character.isLowerCase(nextChar)){
                stringBuilder.append((char) ((nextChar + rotate - 97) % 26 + 97));

            }else {
                stringBuilder.append(nextChar);
            }
        }
        return stringBuilder.toString();
    }

}
