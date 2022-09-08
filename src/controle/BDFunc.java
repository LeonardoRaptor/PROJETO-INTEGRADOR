package controle;
import java.util.ArrayList;

import modelo.Funcionario;
public class BDFunc {
	ArrayList <Funcionario> func = new ArrayList <Funcionario> ();
	public void addFunc(Funcionario f) {
		func.add(f);
	}
	public void delFunc(Funcionario f) {
		func.remove(f);
	}
}
