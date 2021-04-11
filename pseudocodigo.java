public abstract class MedioPago {
  public abstract int recargo(list prendas,int cuotas);
}

public class Efectivo extends MedioPago{
  public int recargo(list prendas,int cuotas){
    return 0;
  }  
}

public class Tarjeta extends MedioPago{
  private int coeficiente;
  public int recargo(list prendas,int cuotas){
    int recargoPrendas = sumatoria(forall(map(prendas, getMonto),*0.01)) //Definir código correcto
    return cuotas * this.coeficiente + recargoPrendas;
  }  
}

  
public class Venta {
  private list prendas;
  private list cantidades;
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

