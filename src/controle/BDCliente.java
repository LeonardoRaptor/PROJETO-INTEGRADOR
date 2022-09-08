package controle;

import java.util.ArrayList;

import modelo.Cliente;

public class BDCliente {
	ArrayList<Cliente> cli = new ArrayList<Cliente>();

	public void addLivro(Cliente clie) {
		cli.add(clie);
	}

	public void delLivro(Cliente clie) {
		cli.remove(clie);
	}
}
