package teste;

import br.com.prod.datasource.model.Produto;

public class Test2 {

	public static void main(String[] args) {
		teste test = new teste();
		
		System.out.println(test.getById(5l).toString());
		Produto a = test.update(5l, new Produto(8l, "alison", 5.78f ,"ascuzczud", "sadsadsad"));
		
		System.out.println(a.toString());

	}

}
