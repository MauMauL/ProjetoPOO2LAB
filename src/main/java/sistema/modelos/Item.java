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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alternativa == null) ? 0 : alternativa.hashCode());
		result = prime * result + (int) (codigoItem ^ (codigoItem >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (alternativa == null) {
			if (other.alternativa != null)
				return false;
		} else if (!alternativa.equals(other.alternativa))
			return false;
		if (codigoItem != other.codigoItem)
			return false;
		return true;
	}
	
	
}
