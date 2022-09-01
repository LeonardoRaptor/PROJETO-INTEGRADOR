import java.util.ArrayList;
import java.sql.*;
public class ListaCli {
	ArrayList <Cliente> cli = new ArrayList <Cliente> ();
	public void addLivro(Cliente clie) {
		cli.add(clie);
	}
	public void delLivro(Cliente clie) {
		cli.remove(clie);
	}
}
