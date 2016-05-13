package sistema.contentflow;
 
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class ImagesView {
     
    private List<String> images;
  //  private String[] nome = {"Conteudo", "Disciplima", "Pergunta", "Professor", "Prova"};
    private String[] nome = {"interrogacao", "professor"};
    
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 0; i < 2; i++) {
            images.add(nome[i]);
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}