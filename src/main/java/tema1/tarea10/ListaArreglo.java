package tema1.tarea10;

public class ListaArreglo {
  ListaDoble elem[];
  public int cantElem;
  public int MAX;

  public ListaArreglo(int max) {
    this.MAX = max;
    this.cantElem = max;
    this.elem = new ListaDoble[MAX];
    for (int i = 0; i < max; i++) {
      elem[i] = new ListaDoble();
    }
  }

  public String mostrarMenorAMayor() {
    String s = "";
    for (int i = 0; i < cantElem; i++) {
      if (elem[i].cantElem > 0) {
        String listaDoble = elem[i].mostrarMenorAMayor();
        s = s + listaDoble + '\n';
      }
    }
    return s;
  }

  public String mostrarMayorAMenor() {
    String s = "";
    for (int i = cantElem - 1; i >= 0; i--) {
      if (elem[i].cantElem > 0) {
        String listaDoble = elem[i].mostrarMayorAMenor();
        s = s + listaDoble + '\n';
      }
    }
    return s;
  }

  public void insertar(String x) {
    int longitud = x.length();
    elem[longitud].insertarLugarAsc(x);
  }
}
