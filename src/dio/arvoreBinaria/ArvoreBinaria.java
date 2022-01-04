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
		System.out.println("\n\n Exibindo InOrdem \n");
		exibirInOrdem(this.raiz);
	}
	
	private void exibirInOrdem(BinNo<T> atual) {
		if (atual != null) {
			exibirInOrdem(atual.getNoEsq());
			System.out.print(atual.getConteudo() + ", ");
			exibirInOrdem(atual.getNoDir());
		}
	}
	
	// exibir PosOrdem
	public void exibirPosOrdem() {
		System.out.println("\n\n Exibindo PosOrdem \n");
		exibirPosOrdem(this.raiz);
	}
		
	private void exibirPosOrdem(BinNo<T> atual) {
		if (atual != null) {
			exibirPosOrdem(atual.getNoEsq());
			exibirPosOrdem(atual.getNoDir());
			System.out.print(atual.getConteudo() + ", ");
				
		}
	}
		
	// exibir PreOrdem
	public void exibirPreOrdem() {
		System.out.println("\n\n Exibindo PreOrdem \n");
		exibirPreOrdem(this.raiz);
	}
		
	private void exibirPreOrdem(BinNo<T> atual) {
		if (atual != null) {
			System.out.print(atual.getConteudo() + ", ");
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
			
			// verifica se o Atual e diferente de nulo e nao e igual ao conteudo e percorre a lista
			while (atual != null && !atual.getConteudo().equals(conteudo)) {
				pai = atual;
				if (conteudo.compareTo(atual.getConteudo()) < 0) {
					atual = atual.getNoEsq();
				}else {
					atual = atual.getNoDir();
				}
			}
			// verifica se a raiz e nula ou esta na folha da arvore
			if (atual == null) {
				System.out.println("Conteudo nao encontrado..Bloco try");
			}
			
			// verifica se o no e direito, esquerdo 
			if (pai == null) {
				if (atual.getNoDir() == null) {
					this.raiz = atual.getNoEsq();
				}else if (atual.getNoEsq() == null) {
					this.raiz = atual.getNoDir();
				}else {
					
					for (temp = atual, filho = atual.getNoEsq();
							filho.getNoDir() != null;
							temp = filho, filho = filho.getNoEsq()
						) {
						if (filho != atual.getNoEsq()) {
							temp.setNoDir(filho.getNoEsq());
							filho.setNoEsq(raiz.getNoEsq());
						}
					}
					filho.setNoDir(raiz.getNoDir());
					raiz = filho;
				}
				// setando as referencias de nos a esquerda ou a direita
			}else if (atual.getNoDir() == null) {
				if (pai.getNoEsq() == atual) {
					pai.setNoEsq(atual.getNoEsq());
				}else {
					pai.setNoDir(atual.getNoEsq());
				}
				
			}else if (atual.getNoEsq() == null) {
				if (pai.getNoEsq() == atual) {
					pai.setNoEsq(atual.getNoDir());
				}else {
					pai.setNoDir(atual.getNoDir());
				}
			}else {
				for (temp = atual, filho = atual.getNoEsq();
						filho.getNoDir() != null;
						temp = filho, filho = filho.getNoDir()
					) {
					if (filho != atual.getNoEsq()) {
						temp.setNoDir(filho.getNoEsq());
						filho.setNoEsq(atual.getNoEsq());
					}
					filho.setNoDir(atual.getNoDir());
					if (pai.getNoEsq() == atual) {
						pai.setNoEsq(filho);
					}else {
						pai.setNoDir(filho);
					}
				}
			}
			
		}catch (NullPointerException erro) {
			System.out.println("Conteudo nao encontrado..Bloco catch");
		}
	}
		
}
