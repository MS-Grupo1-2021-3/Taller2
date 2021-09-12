package javeriana.ms.calculadora;

import java.util.ArrayList;
import java.util.List;

public class ResponseLog {
    List<Log> list;

    public ResponseLog() {
        this.list = new ArrayList<>();
    }

    public List<Log> getList() {
        return list;
    }

    public void setList(List<Log> list) {
        this.list = list;
    }
}
