import java.util.TreeMap;
public class Convertor {
    TreeMap<Character, Integer> RomanKeyMap = new TreeMap<>();
    TreeMap<Integer, String> ArabianKeyMap = new TreeMap<>();

    public Convertor() { //creat MAP kay = roman : value = arabian
        RomanKeyMap.put('I', 1);
        RomanKeyMap.put('V', 5);
        RomanKeyMap.put('X', 10);
        RomanKeyMap.put('L', 50);
        RomanKeyMap.put('C', 100);
        RomanKeyMap.put('D', 500);
        RomanKeyMap.put('M', 1000);



        ArabianKeyMap.put(1000, "M");
        ArabianKeyMap.put(900, "CM");
        ArabianKeyMap.put(500, "D");
        ArabianKeyMap.put(100, "C");
        ArabianKeyMap.put(50, "L");
        ArabianKeyMap.put(40, "XL");
        ArabianKeyMap.put(10, "X");
        ArabianKeyMap.put(5, "V");
        ArabianKeyMap.put(4, "IV");
        ArabianKeyMap.put(1, "I");
    }

    public boolean isRoman(String number){
        return RomanKeyMap.containsKey(number.charAt(0)); //string to char
    }
    public String IntToRoman(int number){
        StringBuilder roman = new StringBuilder();
        int arabianKey;
        do {
            arabianKey = ArabianKeyMap.floorKey(number);
            roman.append(ArabianKeyMap.get(arabianKey));
            number -= arabianKey;
        }
        while (number != 0);
        return roman.toString();
    }
    public int RomanToInt(String roman){
        TreeMap<Character, Integer> romanKeyMap = new TreeMap<>();
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);
        romanKeyMap.put('D', 500);
        romanKeyMap.put('M', 1000);

        int end = roman.length() - 1;
        char[] arr = roman.toCharArray();
        int arabian;
        int res = romanKeyMap.get(arr[end]);
        for(int i = end -1; i >= 0; i--){
            arabian = romanKeyMap.get(arr[i]);

            if(arabian < romanKeyMap.get(arr[i + 1])) res -= arabian;
            else res += arabian;
        }

        return res;
    }

}