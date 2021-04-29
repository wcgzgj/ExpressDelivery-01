package top.faroz.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @ClassName IdUtil
 * @Description 生成 id的工具类
 * @Author FARO_Z
 * @Date 2021/4/28 下午10:46
 * @Version 1.0
 **/
public class IdUtil {

    //随机数工具类
    private static Random random = new Random();

    //记录已经使用过的订单号
    private static Set<Integer> usedCodes = new HashSet<>();

    /**
     * 获取不重复的随机六位取件码
     * @return
     */
    public static Integer getUnsameSixGetCode() {
        Integer code = random.nextInt(899999)+100000;
        while (usedCodes.contains(code)) {
            code=random.nextInt(899999)+100000;
        }
        usedCodes.add(code);
        return code;
    }

}
