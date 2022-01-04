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
	
	// exibir InOrdem
	public void exibirInOrdem() {
		System.out.println("\n Exibindo InOrdem");
		exibirInOrdem(this.raiz);
	}
	
	private void exibirInOrdem(BinNo<T> atual) {
		if (atual != null) {
			exibirInOrdem(atual.getNoEsq());
			System.out.println(atual.getConteudo() + ", ");
			exibirInOrdem(atual.getNoDir());
		}
	}
	
	// exibir PosOrdem
	public void exibirPosOrdem() {
		System.out.println("\n Exibindo PosOrdem");
		exibirPosOrdem(this.raiz);
	}
		
	private void exibirPosOrdem(BinNo<T> atual) {
		if (atual != null) {
			exibirPosOrdem(atual.getNoEsq());
			exibirPosOrdem(atual.getNoDir());
			System.out.println(atual.getConteudo() + ", ");
				
		}
	}
		
	// exibir PreOrdem
	public void exibirPreOrdem() {
		System.out.println("\n Exibindo PosOrdem");
		exibirPreOrdem(this.raiz);
	}
		
	private void exibirPreOrdem(BinNo<T> atual) {
		if (atual != null) {
			System.out.println(atual.getConteudo() + ", ");
			exibirPreOrdem(atual.getNoEsq());
			exibirPreOrdem(atual.getNoDir());
		}
	}	
	
	// metodo de remocao
	public void remover (T conteudo) {
		
		// tratando erro com try catch 
		try {
			BinNo<T> atual = this.raiz;
			BinNo<T> pai = null;
			BinNo<T> filho = null;
			BinNo<T> temp = null;
			
			// verifica se o Atual e diferente de nulo e nao e igual ao conteudo
			while (atual != null && !atual.getConteudo().equals(conteudo)) {
				pai = atual;
				if (conteudo.compareTo(atual.getConteudo()) < 0) {
					atual = atual.getNoEsq();
				}else {
					atual = atual.getNoDir();
				}
			}
			if (atual == null) {
				System.out.println("Conteudo nao encontrado..Bloco try");
			}
			
		}catch (NullPointerException erro) {
			System.out.println("Conteudo nao encontrado..Bloco catch");
		}
	}
		
}
