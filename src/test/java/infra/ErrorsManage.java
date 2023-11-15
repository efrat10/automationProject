package infra;

public class ErrorsManage {
    public static int numError=0;

    public static int getNumError() {
        return numError;
    }

    public static void setNumError() {
        numError++;
    }
}
