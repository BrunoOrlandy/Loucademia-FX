
public class PessoaFabrica {
	
	public void constroiPessoa(TipoDePessoa pessoa) {
		
		switch(pessoa) {
		
			case ALUNO:
						new Aluno();
						break;
				
			case INSTRUTOR:
						new Instrutor();
						break;
				
			case RECEPCIONISTA:
						new Recepcionista();
						break;
		}
	}
}
