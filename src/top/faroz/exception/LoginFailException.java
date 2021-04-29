package top.faroz.exception;

/**
 * @ClassName LoginFailException
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/28 下午11:03
 * @Version 1.0
 **/
public class LoginFailException extends Exception {
    public LoginFailException() {
        super("错误，用户名或密码错误");
    }
}
