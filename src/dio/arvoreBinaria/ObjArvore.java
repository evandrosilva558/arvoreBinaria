package dio.arvoreBinaria;

	// classe abstrata
public abstract class ObjArvore<T> implements Comparable<T> {

	public abstract boolean equals(Object o);
	
	public abstract int hashcode();
	
	public abstract int compareto(T outro);
	
	public abstract String toString();
	
}
