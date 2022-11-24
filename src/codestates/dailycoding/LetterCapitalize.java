package codestates.dailycoding;

public class LetterCapitalize {
    public static void main(String[] args) {
        String output1 = letterCapitalize("hello world");
        System.out.println(output1); // "Hello World"
        String output2 = letterCapitalize("java  is good");
        System.out.println(output2); // "Java  Is Good"
    }
    public static String letterCapitalize(String str) {
        // TODO:
        String[] strArr = str.split(" ");
        String result = "";

        if(str.isBlank()) {
            return "";
        }

        for(int i = 0; i < strArr.length; i++) {
            if(!strArr[i].isEmpty()) {
                strArr[i] = strArr[i].substring(0, 1).toUpperCase() + strArr[i].substring(1, strArr[i].length());
            }
        }

        result += strArr[0];

        for(int i = 1; i < strArr.length; i++) {
            result = result + " " + strArr[i];
        }

        return result;
    }
}
