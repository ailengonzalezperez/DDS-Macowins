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
  private List<Prenda> prendas;
  private List<Int> cantidades;
  private date fecha;
  private MedioPago metodo;
  
  public int monto(){
    return (valortotal); //El valor total es la sumatoria de calcular el monto de cada prenda * cantidadcomprada.Combinamos las 2 listas
  }	
}

//OJO son clases sin comportamiento y eso no está bien :(
//public class Saco extends Prenda{}
//public class Camisa extends Prenda{}
//public class Pantalon extends Prenda{}
//qué podemos hacer? una alternativa con enum

public abstract class Prenda {
  private Double precio;
  private Estado estadoPrenda;
  //str tipo; esto es polémico porque podría poner cualquier cosa en el string
  TipoPrenda tipo;
  
  public void precio() {
    return this.precio - this.estadoPrenda.descuentoAplicado(this.precio); //mi precio menos lo que me descuentan
  }
}

public enum TipoPrenda{
  SACO, PANTALON, CAMISA
}


public Interface Estado {
  public abstract int descuentoAplicado(Double precio);
}

public class Nueva implements Estado{
 public abstract int descuentoAplicado(Double precio){
  return 0;
 }
}

public class Promocion implements Estado{
  private int valorDescuento;
  public abstract int descuentoAplicado(Double precio){
    return this.valorDescuento;
  }
}

public class Liquidacion implements Estado{
 public abstract int descuentoAplicado(Double precio){
   return (precio * 0.5);
}


  
public class VentaDiaria {
  private ArrayList ventas;
  
  public int gananciaDia(){
    return this.ventas.stream().map(Venta::monto()).sum(); //El valor total es la sumatoria de obtener el monto de cada venta del día
  }	
}
               
public class Ganancias {
  private Map<Date, Integer> ganancias = new HashMap<Date, Integer>();
  
  public int gananciaFecha(Date fecha){
    return (this.ganancias.get(fecha));
  }	
  
  public void incorporarGanancia(Date fecha, int ganancia){
    this.ganancias.put(fecha, ganancia);
  }
  
}
