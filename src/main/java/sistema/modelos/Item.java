package sistema.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigoItem;
	
	private String alternativa;
	private boolean alternativaCorreta;
	
	
	public long getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(long codigoItem) {
		this.codigoItem = codigoItem;
	}
	public String getAlternativa() {
		return alternativa;
	}
	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}
	public boolean isAlternativaCorreta() {
		return alternativaCorreta;
	}
	public void setAlternativaCorreta(boolean alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}
	
	
}
