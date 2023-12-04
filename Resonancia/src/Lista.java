import java.util.ArrayList;
import java.util.List;
public class Lista{
    List<PuntoAcceso> routers;

    public Lista(){
        routers=new ArrayList<PuntoAcceso>();
    }
    public List<PuntoAcceso> getRouters(){
        return routers;
    }
    /*public void predefinir(){
        routers.add(new PuntoAcceso(1, "HP", "192.168.1.0", 10));
        routers.add(new PuntoAcceso(3, "ASUS", "192.168.1.1", 15));
        routers.add(new PuntoAcceso(2, "ASUS", "192.168.1.2", 20));
        routers.add(new PuntoAcceso(5, "CISCO", "192.168.1.3", 25));
        routers.add(new PuntoAcceso(4, "DELL", "192.168.1.4", 30));
    }*/
    public boolean agregar(PuntoAcceso dato) {
        for (PuntoAcceso j : routers) {
            if (j.getCodigo() == dato.getCodigo()) {
                j.setMarca(dato.getMarca());
                j.setIp(dato.getIp());
                j.setPrecio(dato.getPrecio());
                return true;
            }
        }
        routers.add(dato);
        return false;
    }
    public void ordenarInsercion(){
        PuntoAcceso aux=new PuntoAcceso();
        int j;
        for (int i=1;i<routers.size();i++){
            aux=routers.get(i);
            j=i-1;
            while (j>=0 && aux.getCodigo()<routers.get(j).getCodigo()){
                routers.set(j+1,routers.get(j));
                j--;
            }
            routers.set(j+1,aux);
        }
    }
    public float sumarPreciosPorMarca(List<PuntoAcceso> lista, String marca) {
        return sumarPreciosPorMarcaRecursivo(lista, marca, 0);
    }
    private float sumarPreciosPorMarcaRecursivo(List<PuntoAcceso> lista, String marca, int index) {
        if (index >= lista.size()) {
            return 0;
        }
        PuntoAcceso router = lista.get(index);
        float sumaRestante = sumarPreciosPorMarcaRecursivo(lista, marca, index + 1);
        if (router.getMarca().equals(marca)) {
            return router.getPrecio() + sumaRestante;
        } else {
            return sumaRestante;
        }
    }
}
