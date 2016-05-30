package sistema.geradorPDF;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import sistema.modelos.Alternativa;
import sistema.modelos.Dissertativa;
import sistema.modelos.MultiplaEscolha;
import sistema.modelos.Prova;
import sistema.modelos.VerdadeiroFalso;
import sistema.service.ProvaService;


@ManagedBean
@ViewScoped
public class GeradorPDF 
{

	private Prova prova;
	private List<Prova> provas;
	private ProvaService provaService = new ProvaService(); 
	
	public Prova getProva() {
		return prova;
	}


	public void setProva(Prova prova) {
		this.prova = prova;
	}
	
	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}


	public List<Prova> getProvas() {
		if (provas == null)
			provas = provaService.getProvas();

		return provas;
	}
	public void gerador() {
        // criação do documento
       Document document = new Document();
       
       String c = "";
       char alternativaAscii = 'a';
       int aux = 0;
       
       try {
          
           PdfWriter.getInstance(document, 
        new FileOutputStream("C:\\prova"+ prova.getCodProva()+" - "+prova.getNomeProva()+".pdf"));
           document.open();
          
           for(int i = 0; i < prova.getConteudos().size(); i++)
           {
        	  /* if(prova.getConteudos().size() == 1)
        	   {
        		   c = c + prova.getConteudos().get(i).getNomeCont();
        	   }*/
        	   if(i == prova.getConteudos().size() - 1)
        	   {
        		   c = c + prova.getConteudos().get(i).getNomeCont() + "";
        	   }
        	   else
        	   {
        		   c = c + prova.getConteudos().get(i).getNomeCont() + ", ";
        	   }
           }
           document.add(new Paragraph("Faculdade: " + prova.getFaculdade()));
           document.add(new Paragraph("Curso: " + prova.getCurso()));
           document.add(new Paragraph("Turma: " + prova.getTurma()));
           document.add(new Paragraph("Data de Aplicação: " + prova.getDataAplicacao().getDate()
        		   +"/"+prova.getDataAplicacao().getMonth()+"/"+"16"));
           document.add(new Paragraph("Tempo Estimado: " + prova.getTempo()+" minutos"));
           document.add(new Paragraph("Dificuldade da prova: " + prova.getDificuldade()));
           document.add(new Paragraph("Disciplina: " + prova.getDisciplina().getNomeDisc()));
           document.add(new Paragraph("Conteudos: " + c));
           document.add(new Paragraph("Professor: " + prova.getDisciplina().getProfessor().getNomeProf()));
           document.add(new Paragraph("Quantidade de Questões: " + prova.getPerguntas().size()));
          
           
           document.add(Chunk.NEWLINE);
           
           for(int i = 0; i < prova.getPerguntas().size(); i++)
           {
        	   document.add(new Paragraph(""+(i + 1)+") " + 
           prova.getPerguntas().get(i).getEnunciado()));
        	   document.add(new Paragraph(""+"("+ "Tempo Estimado: "+ 
           prova.getPerguntas().get(i).getTempoEstimado() +" minutos, Dificulade: " + 
           prova.getPerguntas().get(i).getDificuldade()+")"));
        	   document.add( Chunk.NEWLINE );
        	   
        	   if(prova.getPerguntas().get(i) instanceof Alternativa)
        	   {
        		   alternativaAscii = 'a';
        		  Alternativa a = (Alternativa)prova.getPerguntas().get(i);
        		   for(int j = 0; j < a.getItens().size(); j++)
        		   {
        			   document.add(new Paragraph(""+alternativaAscii+") "+a.getItens().get(j).getAlternativa()));
        			   aux = (int)alternativaAscii;
        			   aux++;
        			   alternativaAscii = (char)aux;
        			   document.add( Chunk.NEWLINE );
        		   }
        		  
        	   }
        	   else if(prova.getPerguntas().get(i) instanceof MultiplaEscolha)
        	   {
        		   alternativaAscii = 'a';
        		   MultiplaEscolha m = (MultiplaEscolha)prova.getPerguntas().get(i);
        		   for(int j = 0; j < m.getItens().size(); j++)
        		   {
        			   document.add(new Paragraph(""+alternativaAscii+") "+m.getItens().get(j).getAlternativa()));
        			   aux = (int)alternativaAscii;
        			   aux++;
        			   alternativaAscii = (char)aux;
        			   document.add( Chunk.NEWLINE );
        		   }
        	   }
        	   else if(prova.getPerguntas().get(i) instanceof VerdadeiroFalso)
        	   {
        		   alternativaAscii = 'a'; 
        		   VerdadeiroFalso v = (VerdadeiroFalso)prova.getPerguntas().get(i);
        		   for(int j = 0; j < v.getItens().size(); j++)
        		   {
        			   document.add(new Paragraph(""+alternativaAscii+") "+v.getItens().get(j).getAlternativa()));
        			   aux = (int)alternativaAscii;
        			   aux++;
        			   alternativaAscii = (char)aux;
        			   document.add( Chunk.NEWLINE );
        		   }
        	   }
        	   else if(prova.getPerguntas().get(i) instanceof Dissertativa)
        	   {
        		   document.add(new Paragraph("Resposta:"));
        		   
        		   document.add(Chunk.NEWLINE);
        		   document.add(Chunk.NEWLINE);
        		   document.add(Chunk.NEWLINE);
        		   document.add(Chunk.NEWLINE);
        		   document.add(Chunk.NEWLINE);
        	   }
           }
           
       }
       catch(DocumentException de) {
           System.err.println(de.getMessage());
           }
       catch(IOException ioe) {
           System.err.println(ioe.getMessage());
       }
       document.close();
   }   

}



