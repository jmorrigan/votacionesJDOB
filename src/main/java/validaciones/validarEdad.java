/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validaciones;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author juan
 */

@FacesValidator(value="edad")
public class validarEdad implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
            String fechaa = String.valueOf(value);
          
            SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendario = GregorianCalendar.getInstance();
            Date fechai = calendario.getTime();
           
            
            
            
            
            
            
//            if(años < 35){
//                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "NO ES APTO", "La edad minima es 35 años");
//                throw new ValidatorException(msg);
//            }
//      
        
    }
    
}
