import java.util.ArrayList;
import java.sql.*;
public class ListaFunc {
	ArrayList <Funcionario> func = new ArrayList <Funcionario> ();
	public void addFunc(Funcionario f) {
		func.add(f);
	}
	public void delFunc(Funcionario f) {
		func.remove(f);
	}
}
