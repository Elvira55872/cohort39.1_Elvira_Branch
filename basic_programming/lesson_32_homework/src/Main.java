public class Main {

    public static String rgb(int r, int g, int b) {
        String rr = null;
        String gg = null;
        String bb = null;

        if (r >= 255) {
            rr = "FF";
        }
        if (g >= 255) {
            gg = "FF";
        }
        if (b >= 255) {
            bb = "FF";
        }

        if (r <= 0) {
            rr = "00";
        }
        if (g <= 0) {
            gg = "00";
        }
        if (b <= 0) {
            bb = "00";
        }

        if (r > 0 && r < 255) {
            rr = Integer.toHexString(r).toUpperCase();
        }
        if (g > 0 && g < 255) {
            gg = Integer.toHexString(g).toUpperCase();
        }
        if (b > 0 && b < 255) {
            bb = Integer.toHexString(b).toUpperCase();
        }

        return rr + gg + bb;
    }
}
