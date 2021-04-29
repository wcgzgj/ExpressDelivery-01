package top.faroz.exception;

/**
 * @ClassName RunInputException
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/28 下午10:54
 * @Version 1.0
 **/
public class WrongInputException extends Exception{
    public WrongInputException() {
        super("错误，用户输入错误");
    }
}
