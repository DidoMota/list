import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {
		
		
		List <String> list = new ArrayList<>();		//declarando e instanciando uma Lista através da classe ArrayList
		
		list.add("Maria");			//adicionando itens a lista, por padrão o item é adicionado no fim da lista
		list.add("Alex");
		list.add("Bob");
		list.add("Anna");
		list.add("Dário");
		list.add("Irene");	
		list.add("Felipe");	
		list.add("Dimas");
		list.add(2, "Marcos");		//Adicionando o item "Marcos" na posição 2 da lista, automaticamente os outros itens aumentam uma casa para "Marcos" entrar na posição 2
		list.add(0, "Dido");   		//Adicionando o item "Dido" na posição 0 da lista, automaticamente os outros itens aumentam uma casa para "Dido" entrar na posição 0
		
		System.out.println(list.size()); 			//visualizando o tamanho da lista
		
		for(String x : list) {				//percorrendo e imprimindo a lista com um for each
			System.out.println(x);
		}
		
		System.out.println("--------------------");		
		list.remove(2);								//remove o dado da posição 2 da lista
		list.remove("Anna");						//remove um dado a partir da comparação dele com outro, no caso "anna"
		System.out.println(list.size());
		for(String x : list) {		
			System.out.println(x);
		}	
		
		
		System.out.println("--------------------");												
		list.removeIf(x -> x.charAt(0) == 'M');			//removendo dados pelo predicado. Remove todos os dados que se encaixem na condição, nesse caso "remover todo "x" tal que x.charAt(0) == 'M"		
		System.out.println(list.size());
		for(String x : list) {		
			System.out.println(x);
		}
		System.out.println("Posição de Irene na lista é: " + list.indexOf("Irene"));		//busca, compara e retorna qual a posição na lista do item buscado
		System.out.println("Posição de Marcos na lista é: " + list.indexOf("Marcos"));		//quando o indexOf não encontra o elemento, ele retorna o valor de -1
		
		
		System.out.println("--------------------");		
		//filtra os itens da lista que atendem à condição, criando uma nova lista com esses itens, nesse caso todos os itens que começam com a letra D	
		List <String> result = list.stream().filter(x -> x.charAt(0) == 'D').collect(Collectors.toList());	
		System.out.println(result.size());
		for(String x : result) {		
			System.out.println(x);
		}
		
		System.out.println("--------------------");		
		//irá filtrar o primeiro elemento que atende o predicado, no caso, que contenha letra D na primeira letra, caso não encontre, irá retornar null
		String name = list.stream().filter(x -> x.charAt(0) == 'D').findFirst().orElse(null);
		System.out.println(result.size());
		System.out.println(name);
	}

}
/* O modo de filtrar itens é um pouco complicado porque o List é antigo e o Stream foi introduzido no java8, 
 * então tem que converter 2x, primeito pra stream filtrando o resultado, com o list.stream().filter(x -> x.charAt(0) == 'D')
 * e depois de volta pra String com collect(Collectors.toList())
 * Essa foi a forma que o Java fez para manter a compatibilidade do List e trabalhar com recursos Lambda
 */
