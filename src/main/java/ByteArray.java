/**
 * Created by mi on 2018/3/6.
 */

import com.google.common.primitives.Longs;

public class ByteArray {
    public static void main(String[] args) {
        Long number = 1520330400000L;
        byte[] a = guavaLongs(number);
        byte[] b = stringLongs(number);

        System.out.println("Hello, World");

    }

    public static byte[] guavaLongs(Long number){
        return Longs.toByteArray(number);
    }

    public static byte[] stringLongs(Long number){
        return number.toString().getBytes();
    }


}
