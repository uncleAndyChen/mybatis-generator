package common.lib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {
    /**
     * 获取指定字符串出现的次数
     *
     * @param srcText 源字符串
     * @param findText 要查找的字符串
     * @return 返回匹配的次数
     */
    public static int appearNumber(String srcText, String findText) {
        int count = 0;
        Pattern p = Pattern.compile(findText);
        Matcher m = p.matcher(srcText);

        while (m.find()) {
            count++;
        }

        return count;
    }
}
