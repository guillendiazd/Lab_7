package david_diaz_lab6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdministrarProducto {
   private ArrayList<Producto> productos = new ArrayList();
   private File archivo = null;

    public AdministrarProducto(String source) {
        archivo = new File(source);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    public void setProducto(Producto p){
        this.productos.add(p);
    }

    @Override
    public String toString() {
        return "productos=" + productos;
    }
    public void EscribirArchivo() throws IOException{
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Producto t : productos) {
                bw.write(t.getNombre()+ ";");
                bw.write(t.getCategoria()+ ";");
                bw.write(t.getPrecio()+ ";");
                bw.write(t.getDescuento()+ ";");
            }
            bw.flush();
        } catch (Exception e) {
        }
        bw.close();
        fw.close();
    }
    
    public void CargarArchivo(){
        Scanner sc = null;
        productos = new ArrayList();
        try {
            sc = new Scanner(archivo);
            sc.useDelimiter(";");
            while(sc.hasNext()){
                productos.add(new Producto(sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble()));
            }
            sc.close();
        } catch (Exception e) {
        }
    }
}
