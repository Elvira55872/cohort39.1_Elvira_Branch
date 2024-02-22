public class Main01 {
    /*
    Сохранить массив чисел в строку точно так же как Arrays.toString(), но не используя этот метод
    Сделать это через StringBuilder и String, замерять время выполнения
     */
    public static void main(String[] args) {
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        long start = System.nanoTime();
        String res = "[ ";
        for (int i = 0; i < arr.length; i++) {
            res += arr[i];
            if (i + 1 != arr.length) {
                res += ", ";
            }
        }
        res += " ]";
        long end = System.nanoTime();
        System.out.println((end - start) / 1000);

        start = System.nanoTime();

        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i + 1 != arr.length) {
                sb.append(", ");
            }
        }
        sb.append(" ]");

        end = System.nanoTime();
        System.out.println((end - start) / 1000);
    }
}
