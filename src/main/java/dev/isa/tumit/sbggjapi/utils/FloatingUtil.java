package dev.isa.tumit.sbggjapi.utils;

public class FloatingUtil {

    public static String toIEEE754(float f) {
        String bits = "%32s"
                .formatted(Integer.toBinaryString(Float.floatToIntBits(f)))
                .replace(' ', '0');
        String signBit = bits.substring(0, 1);
        String exponentBits = bits.substring(1, 9);
        String exponentBias = bits.substring(9);



        return "%s %s %s".formatted(signBit, exponentBits, exponentBias);
    }

    public static void main(String[] args) {
        System.out.println(toIEEE754(Float.parseFloat(args[0])));
    }
}
