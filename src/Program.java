import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {
		
		
		List <String> list = new ArrayList<>();		//declarando e instanciando uma Lista atrav�s da classe ArrayList
		
		list.add("Maria");			//adicionando itens a lista, por padr�o o item � adicionado no fim da lista
		list.add("Alex");
		list.add("Bob");
		list.add("Anna");
		list.add("D�rio");
		list.add("Irene");	
		list.add("Felipe");	
		list.add("Dimas");
		list.add(2, "Marcos");		//Adicionando o item "Marcos" na posi��o 2 da lista, automaticamente os outros itens aumentam uma casa para "Marcos" entrar na posi��o 2
		list.add(0, "Dido");   		//Adicionando o item "Dido" na posi��o 0 da lista, automaticamente os outros itens aumentam uma casa para "Dido" entrar na posi��o 0
		
		System.out.println(list.size()); 			//visualizando o tamanho da lista
		
		for(String x : list) {				//percorrendo e imprimindo a lista com um for each
			System.out.println(x);
		}
		
		System.out.println("--------------------");		
		list.remove(2);								//remove o dado da posi��o 2 da lista
		list.remove("Anna");						//remove um dado a partir da compara��o dele com outro, no caso "anna"
		System.out.println(list.size());
		for(String x : list) {		
			System.out.println(x);
		}	
		
		
		System.out.println("--------------------");												
		list.removeIf(x -> x.charAt(0) == 'M');			//removendo dados pelo predicado. Remove todos os dados que se encaixem na condi��o, nesse caso "remover todo "x" tal que x.charAt(0) == 'M"		
		System.out.println(list.size());
		for(String x : list) {		
			System.out.println(x);
		}
		System.out.println("Posi��o de Irene na lista �: " + list.indexOf("Irene"));		//busca, compara e retorna qual a posi��o na lista do item buscado
		System.out.println("Posi��o de Marcos na lista �: " + list.indexOf("Marcos"));		//quando o indexOf n�o encontra o elemento, ele retorna o valor de -1
		
		
		System.out.println("--------------------");		
		//filtra os itens da lista que atendem � condi��o, criando uma nova lista com esses itens, nesse caso todos os itens que come�am com a letra D	
		List <String> result = list.stream().filter(x -> x.charAt(0) == 'D').collect(Collectors.toList());	
		System.out.println(result.size());
		for(String x : result) {		
			System.out.println(x);
		}
		
		System.out.println("--------------------");		
		//ir� filtrar o primeiro elemento que atende o predicado, no caso, que contenha letra D na primeira letra, caso n�o encontre, ir� retornar null
		String name = list.stream().filter(x -> x.charAt(0) == 'D').findFirst().orElse(null);
		System.out.println(result.size());
		System.out.println(name);
	}

}
/* O modo de filtrar itens � um pouco complicado porque o List � antigo e o Stream foi introduzido no java8, 
 * ent�o tem que converter 2x, primeito pra stream filtrando o resultado, com o list.stream().filter(x -> x.charAt(0) == 'D')
 * e depois de volta pra String com collect(Collectors.toList())
 * Essa foi a forma que o Java fez para manter a compatibilidade do List e trabalhar com recursos Lambda
 */
