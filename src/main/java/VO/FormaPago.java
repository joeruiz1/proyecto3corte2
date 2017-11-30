
package VO;

public class FormaPago {
    private int id ;
    private String formarPago;

    public FormaPago(int id, String formarPago) {
        this.id = id;
        this.formarPago = formarPago;
    }

    public FormaPago() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormarPago() {
        return formarPago;
    }

    public void setFormarPago(String formarPago) {
        this.formarPago = formarPago;
    }
    
    
    
    
    
    
}
