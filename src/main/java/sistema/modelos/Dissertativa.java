package sistema.modelos;

import javax.persistence.Entity;

@Entity
public class Dissertativa extends Pergunta 
{
	private String resposta;

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	
}
