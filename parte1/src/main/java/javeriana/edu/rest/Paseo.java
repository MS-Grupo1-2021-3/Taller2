package javeriana.edu.rest;

public class Paseo {
    String ID;
    String origen;
    String destino;

    public Paseo() {
    }
    public Paseo(String ID, String origen, String destino) {
        this.ID = ID;
        this.origen = origen;
        this.destino = destino;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getOrigen() {
        return origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public String toString(){
        return "ID:" + this.ID + " Origen: " + this.origen + " Destino: " + this.destino + "\n";
    }
}
