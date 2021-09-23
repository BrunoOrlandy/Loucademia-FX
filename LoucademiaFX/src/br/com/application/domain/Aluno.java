
public class Aluno extends Pessoa {

	// Situação do aluno
	private Situacao situacao;
	
	// Retorna uma situação
	public Situacao getSituacao() {
		return situacao;
	}

	// Recebe uma situação
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
}
