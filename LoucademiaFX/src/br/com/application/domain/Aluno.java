
public class Aluno extends Pessoa {

	// Situa��o do aluno
	private Situacao situacao;
	
	// Retorna uma situa��o
	public Situacao getSituacao() {
		return situacao;
	}

	// Recebe uma situa��o
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
}
