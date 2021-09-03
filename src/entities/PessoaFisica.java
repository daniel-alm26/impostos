package entities;

public class PessoaFisica extends Contribuinte {
	
	private Double gastosSaude;
	
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public double taxa() {		
		if (getRendaAnual() < 20000.00) {
			return getRendaAnual() * 0.15 - gastosSaude * 0.5;
		}
		else {
			return getRendaAnual() * 0.25 - gastosSaude * 0.5;
		}
	}
}
