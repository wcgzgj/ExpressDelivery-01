package top.faroz.exception;

/**
 * @ClassName LogedException
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/28 下午8:41
 * @Version 1.0
 **/
public class LoginedException extends Exception{
    public LoginedException() {
        super("错误，已经登录！");
    }
}
