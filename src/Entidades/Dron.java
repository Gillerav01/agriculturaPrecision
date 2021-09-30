package Entidades;

public class Dron {
    private int idDron;
    private String modeloDron;

    public Dron() {
        
    }

    public Dron(int idDron, String modeloDron) {
        this.idDron = idDron;
        this.modeloDron = modeloDron;
    }
    
    public int getIdDron() {
        return idDron;
    }

    public void setIdDron(int idDron) {
        this.idDron = idDron;
    }

    public String getModeloDron() {
        return modeloDron;
    }

    public void setModeloDron(String modeloDron) {
        this.modeloDron = modeloDron;
    }

    @Override
    public String toString() {
        return "Este dron tiene la ID: " + idDron + ". El modelo del dron es: " + modeloDron;
    }
    
}
