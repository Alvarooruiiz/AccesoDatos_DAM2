import java.util.Date;

public class MiFecha {
    private Integer dia;
    private Integer mes;
    private Integer ano;

    public MiFecha(Integer dia, Integer mes, Integer ano) {
        setMes(mes);
        setDia(dia);
        this.ano = ano;


    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia=dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes=mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return dia + "-" + mes +  "-" + ano;
    }
}
