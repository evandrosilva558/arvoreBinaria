package dio.arvoreBinaria;

import java.util.Objects;

// objeto extendendo da classe abstrata ObjArvore
public class Obj extends ObjArvore<Obj> {


	Integer meuValor;
	
	public Obj(Integer meuValor) {
		this.meuValor = meuValor;
	}

	// implementacao dos metodos da classe abstrata compara a igualdade dos objetos
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Obj other = (Obj) o;
		return Objects.equals(meuValor, other.meuValor);
	}
	
	@Override
	public int hashcode() {
		return Objects.hash(meuValor);
	}

	@Override
	public int compareto(Obj outro) {
		int i = 0; 
		if (this.meuValor > outro.meuValor) {
			i = 1;
			
		}else if (this.meuValor < outro.meuValor){
			i = -1;
			
		}
		return i;
	}

	@Override
	public String toString() {
		return meuValor.toString();
	}

	@Override
	public int compareTo(Obj outro) {
		int i = 0; 
		if (this.meuValor > outro.meuValor) {
			i = 1;
			
		}else if (this.meuValor < outro.meuValor){
			i = -1;
			
		}
		return i;
	}

}
