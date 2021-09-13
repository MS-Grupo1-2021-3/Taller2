package javeriana.ms.calculadora;

import java.util.Map;
import java.util.HashMap;

public class ResponseLogMap {
    Map<String, ResponseLog> maps;

    public ResponseLogMap() {
        maps = new HashMap<>();
    }

    public Map<String, ResponseLog> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, ResponseLog> maps) {
        this.maps = maps;
    }
    
}
