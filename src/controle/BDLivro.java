package controle;
import java.util.ArrayList;

import modelo.Livro;

public class BDLivro {
	ArrayList <Livro> li = new ArrayList <Livro> ();
	public void addLivro(Livro l) {
		li.add(l);
	}
	public void delLivro(Livro l) {
		li.remove(l);
	}
}
