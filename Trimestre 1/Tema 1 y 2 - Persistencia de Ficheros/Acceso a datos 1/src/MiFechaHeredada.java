public class MiFechaHeredada extends MiFecha{

    private boolean esBisiesto;
    public MiFechaHeredada(Integer dia, Integer mes, Integer ano) {
        super(dia, mes, ano);

        if ((ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0))){
            this.esBisiesto=true;
        }
    }

    public void setDia(Integer dia){
        switch (getMes()){
            case 1,3,5,7,8,10,12->{
                if(dia>0 && dia<32){
                    super.setDia(dia);
                }else super.setDia(0);
            }
            case 4,6,9,11->{
                if(dia>0 && dia<31){
                    super.setDia(dia);
                }else super.setDia(0);
            }
            case 2->{
                if(dia>0 && dia<30){
                    super.setDia(dia);
                }else super.setDia(0);
            }

        }
    }

    @Override
    public void setMes(Integer mes) {
        if(mes>=1 && mes<=12){
            super.setMes(mes);
        }else super.setMes(0);
    }

    @Override
    public String toString() {
        return super.toString() + (esBisiesto ? ", y el año es bisiesto": ", y el año no es bisiesto");

    }
}
