package sistema.contentflow;
 
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class ImagesView {
     
    private List<String> images;
    private String[] nome = {"cadastroConteudo.xhtml.jpg", "cadastroDisciplina.xhtml.jpg", "cadastroPergunta.xhtml.jpg"
    , "cadastroProfessor.xhtml.jpg", "cadastroProva.xhtml.jpg"};
    
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            images.add(nome[i]);
        }
    }
    public List<String> getImages() {
        return images;
    }

    
}