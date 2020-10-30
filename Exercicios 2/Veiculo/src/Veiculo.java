// CLASSE PAI
public class Veiculo {
    protected String  marca;
    protected String  cor;
    protected boolean motorLigado ;

    // METODO PARA LIGAR/DESLIGAR O MOTOR
    public void ligaDesligaMotor(boolean estado){
        if(estado == true){
            if(this.motorLigado == true){
                System.out.println("\nO motor da "+marca+" já está ligado");
            }else{
                this.motorLigado = true;
                System.out.println("\nO motor da "+marca+" foi ligado");
            }
        }else{
            if(this.motorLigado == false){
                System.out.println("\nO motor da "+marca+" já está desligado");
            }else{
                this.motorLigado = false;
                System.out.println("\nO motor da "+marca+" foi desligado");
            }
        }
    }        
}