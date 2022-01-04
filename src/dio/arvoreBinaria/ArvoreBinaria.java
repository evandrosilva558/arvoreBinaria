package dio.arvoreBinaria;

	// classe ArvoreBinaria extendendo a interface Comparable
public class ArvoreBinaria<T extends Comparable<T>> {

	// atributo No raiz
	private BinNo<T> raiz;
	
	// No raiz setado nulo
	public ArvoreBinaria() {
		this.raiz = null;
	}
	
	// metodo de inserção de um novo no
	public void inseir(T conteudo) {
		BinNo<T> novoNo = new BinNo<>(conteudo);
		raiz = inserir(raiz, novoNo);
	}
	
	// metodo de inserção de um novo no comparando se é menor ou maior se menor inseri na esquerda se maior inseri na direita
	private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo) {
		if (atual == null) {
			return novoNo;
			
		}else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
			atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));
			
		}else {
			atual.setNoDir(inserir(atual.getNoDir(), novoNo));
		}
		
		return atual;
			
	}
}
