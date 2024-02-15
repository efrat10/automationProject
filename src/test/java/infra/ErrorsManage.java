package infra;

public class ErrorsManage {

    public static int numError = 0;

    //The method return the value of numError
    public static int getNumError() {
        return numError;
    }

    //The method update number of error
    public static void setNumError() {
        numError++;
    }

    //The method reset number of error
    public static void resetErrors() {
        numError = 0;
    }
}
