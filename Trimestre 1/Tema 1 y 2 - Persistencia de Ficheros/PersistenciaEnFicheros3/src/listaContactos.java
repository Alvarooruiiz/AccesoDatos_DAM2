import java.util.ArrayList;

public class listaContactos {
    ArrayList<Contacto> lista;

    public listaContactos(){
        this.lista=new ArrayList<>();
    }

    public void anadirContacto(Contacto c){
        lista.add(c);
    }

    @Override
    public String toString() {
        return "listaContactos{" +
                "lista=" + lista +
                '}';
    }
}
