package Model;

public class pontoFunc {
	private int aMes;
	private int aAno;
	private int aNroFaltas;
	private int aNroAtrasos;
	
	public pontoFunc(int pMes, int pAno){
		this.aMes = pMes;
		this.aAno = pAno;
	}
	
	public pontoFunc(int pMes, int pAno, int pNroFaltas, int pNroAtrasos){
		this.aMes = pMes;
		this.aAno = pAno;
		this.aNroFaltas = pNroFaltas;
		this.aNroAtrasos = pNroAtrasos;
	}
	
	public int getaMes() { return aMes; }
	public int getaAno() { return aAno; }
	public int getaNroFaltas() { return aNroFaltas; }
	public int getaNroAtrasos() { return aNroAtrasos; }
	
	public void lancaFaltas(int pNroFaltas){ this.aNroFaltas = pNroFaltas; }
	public void lancaAtrasos(int pNroAtrasos){ this.aNroAtrasos = pNroAtrasos; }
}
