package model;

public class Feedback {
	
	private int id_feedback;
    private String descricao;
    private String data;
    
	public int getId_feedback() {
		return id_feedback;
	}
	public void setId_feedback(int id_feedback) {
		this.id_feedback = id_feedback;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
		
	@Override
	public String toString() {
		return "Feedback [id_feedback=" + id_feedback + ", descricao=" + descricao + ", data=" + data + "]";
	}
    
}
