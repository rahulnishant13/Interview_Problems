package Interviews;

import java.io.*;

public class SecureChannel_GoldmanSachs {
    static String secureChannel(int operation, String message, String key) {
        if(message.isEmpty() || key.isEmpty() || operation < 1 || operation > 2){
            return "-1";
        }
        if(operation == 1){
            return encode(message, key);
        }
        else {
            return decode(message, key);
        }
    }

    static String encode(String message, String key){
        StringBuilder result = new StringBuilder();
        for(int i=0; i<key.length() && i<message.length(); i++){
            if(!Character.isDigit(key.charAt(i))){
                return "-1";
            }
            int val = Integer.parseInt(String.valueOf(key.charAt(i)));
            for(int j=0; j<val; j++){
                result.append(message.charAt(i));
            }
        }
        if(key.length() < message.length()){
            result.append(message.substring(key.length(), message.length()));
        }

        return result.toString();
    }

    static String decode(String message, String key){
        StringBuilder result = new StringBuilder();
        int j=0;
        for(int i=0; i<key.length() && j<message.length(); i++){
            if(!Character.isDigit(key.charAt(i))){
                return "-1";
            }
            int val = Integer.parseInt(String.valueOf(key.charAt(i)));
            char ch = message.charAt(j);
            for(int k=0; k<val; k++){
                if(ch == message.charAt(j)){
                    ch = message.charAt(j);
                    j++;
                    continue;
                } else{
                    return "-1";
                }
            }
            result.append(ch);
        }
        result.append(message.substring(j, message.length()));

        return result.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int operation = Integer.parseInt(bufferedReader.readLine().trim());

        String message = bufferedReader.readLine();

        String key = bufferedReader.readLine();

        String res = secureChannel(operation, message, key);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
