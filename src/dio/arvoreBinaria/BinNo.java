package dio.arvoreBinaria;

	// classe No da arvore extendendo a interface Comparable
public class BinNo<T extends Comparable<T>> {


	// atributos da classe BinNo contendo conteudo e referencia para esquerda e direita
	private T conteudo;
	private BinNo<T> noEsq;
	private BinNo<T> noDir;
	
	// construtor do conteudo com a referencia esquerda e direita recebendo nulo
	public BinNo(T conteudo) {
		this.conteudo = conteudo;
		this.noDir = this.noEsq = null;
	}

	public BinNo() {
		
	}
	
	// metodos acessores geters e seters
	public T getConteudo() {
		return conteudo;
	}

	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}

	public BinNo<T> getNoEsq() {
		return noEsq;
	}

	public void setNoEsq(BinNo<T> noEsq) {
		this.noEsq = noEsq;
	}

	public BinNo<T> getNoDir() {
		return noDir;
	}

	public void setNoDir(BinNo<T> noDir) {
		this.noDir = noDir;
	}
	

	@Override
	public String toString() {
		return "BinNo [conteudo=" + conteudo + "]";
	}
	
}
