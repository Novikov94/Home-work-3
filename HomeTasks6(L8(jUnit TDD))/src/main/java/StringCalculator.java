public class StringCalculator {

    public int Add(String str) throws Exception {
        if (str.equals(" "))
            return 0;
        if (str.contains(",") || str.contains("\n")) {
            return handleMultipleNumbers(str);
        }
        return Integer.parseInt(str);
    }

    private int handleMultipleNumbers(String str) throws Exception {
        String delimiter = ",|\n";

        String[] strings = str.split(delimiter);
        char[] arr;

        int num = 0;
        String negatives = "";

        if (strings[0].contains("//")) {
            arr = strings[0].toCharArray();
            delimiter += "|" + arr[2];

            for (int i = 1; i < strings.length; i++) {
                String[] stringDeli = strings[i].split(delimiter);

                for (int j = 0; j < stringDeli.length; j++) {
                    if (Integer.parseInt(stringDeli[j]) < 0)
                        negatives += stringDeli[j];
                    else
                        num += Integer.parseInt(stringDeli[j]);
                }
            }
        } else {
            for (int i = 0; i < strings.length; i++) {
                if (Integer.parseInt(strings[i]) < 0)
                    negatives += strings[i];
                else
                    num += Integer.parseInt(strings[i]);
            }
        }
        if (!negatives.equals(""))
            throw new Exception("negatives not allowed: " + negatives);
        return num;
    }
}