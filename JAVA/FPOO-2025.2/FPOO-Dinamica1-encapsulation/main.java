package dinamica;

public class main {
	public static void main(String[] args) {
		
		//CRIANDO OBJETO DA CLASSE HEROI
		SUPERHEROI superheroiUm = new SUPERHEROI();
		//DANDO VALORES PARA ATRIBUTOS
		superheroiUm.nome = "Batman";
		superheroiUm.setHabilidade("Riqueza e Tecnologia");
		
		//CRIANDO OBJETO DA CLASSE VILAO
		VILAO vilaoUm = new VILAO();
		//DANDO VALORES PARA ATRIBUTOS
		vilaoUm.nome = "Coringa";
		vilaoUm.setHabilidade("Grupo de muitos membros e imprevísibilidade");
		
		//CRIANDO OBJETO DA CLASSE CIDADE
		CIDADE cidadeAtual = new CIDADE();
		//DANDO VALORES PARA ATRIBUTOS
		cidadeAtual.nome = "Gotham City";
		cidadeAtual.estado = "Nova Jersey";
		cidadeAtual.populacao = 9000000;
		
		//MOSTRANDO
		System.out.println("O Super Heroí é: " + superheroiUm.nome + ", que possui a habilidade de " + superheroiUm.getHabilidade());
		System.out.println("O Vilão é: " + vilaoUm.nome + ", que possui a habilidade de " + vilaoUm.getHabilidade());
		System.out.println("E estão na cidade: " + cidadeAtual.nome + " de " + cidadeAtual.estado + ", com população de " + cidadeAtual.populacao);
	}
}
