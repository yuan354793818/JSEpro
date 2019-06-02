package noclassify;

import java.io.Serializable;

public class PrintResult implements Serializable {

    private PrintResultState state;
    private String info;
    private String errorStackMsg;
    private int costPageNum;

    public int getCostPageNum() {
        return costPageNum;
    }

    public void setCostPageNum(int costPageNum) {
        this.costPageNum = costPageNum;
    }

    public PrintResult(PrintResultState state, String info) {
        this.state = state;
        this.info = info;
    }

    public PrintResult(PrintResultState state, String info, String errorStackMsg) {
        this.state = state;
        this.info = info;
        this.errorStackMsg = errorStackMsg;
    }

    public PrintResult(PrintResultState state) {
        this.state = state;
    }

    public PrintResultState getState() {
        return state;
    }

    public void setState(PrintResultState state) {
        this.state = state;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getErrorStackMsg() {
        return errorStackMsg;
    }

    public void setErrorStackMsg(String errorStackMsg) {
        this.errorStackMsg = errorStackMsg;
    }

    @Override
    public String toString() {
        return "PrintResult{" +
                "state=" + state +
                ", info='" + info + '\'' +
                ", errorStackMsg='" + errorStackMsg + '\'' +
                ", costPageNum=" + costPageNum +
                '}';
    }
}

