public class PuntoAcceso{
    private int codigo;
    private String marca;
    private String ip;
    private float precio;

    public PuntoAcceso() {
    }
    public PuntoAcceso(int codigo, String marca, String ip, float precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.ip = ip;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Punto Acceso " +
                "Codigo: " + codigo +
                ", Marca: " + marca +
                ", IP: " + ip +
                ", Precio: " + precio;
    }
}
