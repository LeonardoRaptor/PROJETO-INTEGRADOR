import java.util.ArrayList;

public class ListaLiv {
	ArrayList <Livro> li = new ArrayList <Livro> ();
	public void addLivro(Livro l) {
		li.add(l);
	}
	public void delLivro(Livro l) {
		li.remove(l);
	}
}
