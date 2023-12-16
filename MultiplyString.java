import java.util.Arrays;

public class MultiplyString {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];

        int[] n1 = new int[num1.length()];
        int[] n2 = new int[num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            n1[i] = num1.charAt(i) - '0';
        }
        for (int i = num2.length() - 1; i >= 0; i--) {
            n2[i] = num2.charAt(i) - '0';
        }

        int z = result.length - 1;
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {

                // System.out.println("n1: " + n1[i] + " n2: " + n2[j] + " z: " + z);
                int old = result[z];
                result[z] = (old + n1[i] * n2[j]) % 10;
                if (z >= 0)
                    result[z - 1] += (old + n1[i] * n2[j]) / 10;
                z--;
            }
            System.out.println(Arrays.toString(result));
            z = z + num2.length() - 1;

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0)
                while (result[i] == 0)
                    i++;
            sb.append(result[i]);
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        MultiplyString ms = new MultiplyString();
        String num1 = "123";
        String num2 = "456";
        System.out.println(ms.multiply(num1, num2));
    }

}
