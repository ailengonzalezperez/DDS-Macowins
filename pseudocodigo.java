public abstract class MedioPago {
  public abstract int recargo(ArrayList prendaslist prendas,int cuotas);
}

public class Efectivo extends MedioPago{
  public int recargo(ArrayList prendas,int cuotas){
    return 0;
  }  
}

public class Tarjeta extends MedioPago{
  private int coeficiente;
  public int recargo(ArrayList prendas,int cuotas){
    int recargoPrendas = this.prendas.stream().map(Prenda::precio()).sum()*0.01; //A la sumatoria de los precios por prenda lo multiplico por 0.01


    return cuotas * this.coeficiente + recargoPrendas;
  }  
}

  
public class Venta {
  private ArrayList prendas;
  private ArrayList cantidades;
  private date fecha;
  private MedioPago metodo;
  
  public int monto(){
    return (valortotal); //El valor total es la sumatoria de calcular el monto de cada prenda * cantidadcomprada.Combinamos las 2 listas
  }	
}

public abstract class Prenda {
  private int precio;
  private Estado estadoPrenda;
  str tipo;
  
  public void precio() {
    return this.precio - this.estadoPrenda.descuentoAplicado(this); //mi precio menos lo que me descuentan
  }
}

public class Saco extends Prenda{}
public class Camisa extends Prenda{}
public class Pantalon extends Prenda{}

public abstract class Estado {
  public abstract int descuentoAplicado(Prenda prenda);
}

public class Nueva extends Estado{
 public abstract int descuentoAplicado(Prenda prenda){
  return 0;
 }
}

public class Promocion extends Estado{
  private int valorDescuento;
  public abstract int descuentoAplicado(Prenda prenda){
    return this.valorDescuento;
  }
}

public class Liquidacion extends Estado{
 public abstract int descuentoAplicado(Prenda prenda){
   return (prenda.precio() * 0.5);
}


  
public class VentaDiaria {
  private ArrayList ventas;
  
  public int ganaciaDia(){
    return this.ventas.stream().map(Venta::monto()).sum(); //El valor total es la sumatoria de obtener el monto de cada venta del día
  }	
}
               
public class Ganancias {
  private Map<Date, Integer> ganancias = new HashMap<Date, Integer>();
  
  public int ganaciaFecha(Date fecha){
    return (this.ganancias.get(fecha));
  }	
  
  public void incorporarGanancia(Date fecha, int ganancia){
    this.ganancias.put(fecha, ganancia);
  }
  
}
