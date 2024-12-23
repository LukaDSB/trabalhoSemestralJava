package Infraestrutura;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
    public String obterDataAtual() {
        LocalDateTime myDateObj = LocalDateTime.now();
        return myDateObj.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String somarDiasData() {
        return "";
    }
}
