package noclassify;

public enum PrintResultState {
    URL_PRINT_TYPE_INCORRECT(-2, "链接打印类型错误"),
    URL_EXCUTE_ERROR(-3, "访问错误"),
    NO_RESPONSE(-4, "无响应"),
    NOT_PDF_PROBABLY(-5, "可能不是pdf文件"),
    PRINT_FAIL(-1, "打印失败"),
    PRINT_SUCCESS(1, "打印成功"),
    NO_STATE(0, "无状态");

    private int resultCode;
    private String info;

    PrintResultState(int resultCode) {
        this.resultCode = resultCode;
    }

    PrintResultState(int resultCode, String info) {
        this.resultCode = resultCode;
        this.info = info;
    }
}
