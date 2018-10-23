import java.awt.image.BufferedImage;

public class Filme {

	private Integer ID;
	private String nome;
	private BufferedImage foto;
	
	public Filme(int ID, String nome, BufferedImage foto) {
		super();
		this.ID = ID;
		this.nome = nome;
		this.foto = foto;
	}
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer ID) {
		this.ID = ID;
	}
	public void setID(String ID) {
		this.ID = new Integer(ID);
	}
	public String getnome() {
		return nome;
	}
	public void setnome(String nome) {
		this.nome = nome;
	}
	public BufferedImage getFoto() {
		return foto;
	}
	public void setFoto(BufferedImage foto) {
		this.foto = foto;
	}
	
	
	
}
