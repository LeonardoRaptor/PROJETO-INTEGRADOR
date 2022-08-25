import java.util.ArrayList;
public class ListaCli {
	ArrayList <Cliente> cli = new ArrayList <Cliente> ();
	public void addLivro(Cliente clie) {
		cli.add(clie);
	}
	public void delLivro(Cliente clie) {
		cli.remove(clie);
	}
}
