package Interviews;

public class StringEncoding_GoldmanSachs {
    public static void main(String[] args) {
        String inputString = "GGGGrrrrrrrt";
        String result = collapseString(inputString);
        System.out.println(result);
    }

    private static String collapseString(String inputString) {
        if(inputString.isEmpty()){
            return "";
        }

        StringBuilder result = new StringBuilder();
        int count =1;
        char ch = inputString.charAt(0);
        for (int i = 1; i < inputString.length(); i++) {
            if(ch == inputString.charAt(i)){
                count++;
            } else {
                // can use Character.toString() or "" else it will add up count and ch
                result.append(count +""+ ch);
                ch = inputString.charAt(i);
                count = 1;
            }
        }

        return result.append(count + ""+ch).toString();
    }
}
