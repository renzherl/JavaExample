/**
 * Created by mi on 2017/5/31.
 */

import org.apache.commons.lang3.StringUtils;

public class HelloJava {
    public static Boolean verify(String mapImeiMd5, String ImeiMd5) {
        return StringUtils.equals(mapImeiMd5, ImeiMd5);
    }

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");
        Boolean result = verify("54573f4f5c05ec2e38663769068d947c", "54573f4f5c05ec2e38663769068d947c");
    }
}

