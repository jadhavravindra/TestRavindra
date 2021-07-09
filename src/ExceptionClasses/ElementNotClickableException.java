package ExceptionClasses;

import org.openqa.selenium.WebElement;

public class ElementNotClickableException extends Exception {
	
	   ElementNotClickableException(){
		super("Element you are trying to input is not Clickable");
	}
	 ElementNotClickableException(String message){
		super(message);
		

	}
	
}
