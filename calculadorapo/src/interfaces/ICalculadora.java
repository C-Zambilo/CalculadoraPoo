package interfaces;

public interface ICalculadora {

	Integer calcula(Integer n1, Integer n2);
	Float calcula(Float n1, Float n2);
	Double calcula(Double n1, Double n2);
	
	Integer calcula(Integer[] numeros);
	Float calcula(Float[] numeros);
	Double calcula(Double[] numeros);
	
}
