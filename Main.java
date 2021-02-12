import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		boolean error=false,error2=false;
		char fallo='a';
		String cadena;
        //Creación de la pila
        Stack<Character> pila = new Stack<Character>();
        //Apertura del archivo. Usar el path que les funcione local
        File file = new File("C:\\Users\\Victor\\Desktop\\estructura\\Examen-1\\Prueba.txt");

        // Intento de abrir el archivo
        try (FileReader fr = new FileReader(file)) {

            //Variable para guardar el caracter que regrese file reader
            int content;
            //Ciclo que lee el archivo caracter por caracter, termina cuando regrese -1 lo cual indica fin del archivo
            while ((content = fr.read()) != -1 && error==false && error2==false) {
                //Proceso para llaves
                if((char)content == '{'){ //Si lee el caracter de apertura lo avienta a la pila
                    pila.push((char)content);
                }
                else if((char)content == '}'){
                    if(!pila.empty()){ //Checa si la pila no está vacía
                        if(pila.peek().equals('{')){ //Si el elemento al tope de la pila concuerda con el caracter a entrar
                            pila.pop();     //Saca el elemento del tope simbolizando que cierran bien
                        }else {
                        		error2=true;
                        		fallo=(char)content;//Guarda el caracter de cerradura errado
                        }
                    }
                    else {
                    	//La pila esta vacia y el caracter es un carater de clausura
                    	System.out.println("Error de llave que cierra se esperaba llave de apertura");
                        error=true;//Se activa la bandera de error para finalizar el programa
                    }
                }

                //Proceso para corchetes
                if((char)content == '['){ //Si lee el caracter de apertura lo avienta a la pila
                    pila.push((char)content);
                }
                else if((char)content == ']'){
                    if(!pila.empty()){ //Checa si la pila no está vacía
                        if(pila.peek().equals('[')){ //Si el elemento al tope de la pila concuerda con el caracter a entrar
                            pila.pop();     //Saca el elemento del tope simbolizando que cierran bien
                        }else {
                        		error2=true;
                        		fallo=(char)content;//Guarda el caracter de cerradura errado
                        }
                    }
                    else {
                    	//La pila esta vacia y el caracter es un carater de clausura
                    	System.out.println("Error de corchete que cierra se esperaba corchete de apertura");
                        error=true;//Se activa la bandera de error para finalizar el programa
                    	 
                    }
                }

                //Proceso para parentesis
                if((char)content == '('){//Si lee el caracter de apertura lo avienta a la pila
                    pila.push((char)content);
                }
                else if((char)content == ')'){
                    if(!pila.empty()){ //Checa si la pila no está vacía
                        if(pila.peek().equals('(')){ //Si el elemento al tope de la pila concuerda con el caracter a entrar
                            pila.pop();  //Saca el elemento del tope simbolizando que cierran bien
                        }else {
                        		error2=true;
                        		fallo=(char)content;//Guarda el caracter de cerradura errado
                        }
                    }
                    else {
                    	//La pila esta vacia y el caracter es un carater de clausura
                    	System.out.println("Error de parentesis que cierra se esperaba parentesis de apertura");        
                        error=true;//Se activa la bandera de error para finalizar el programa
                    }
                }
            }
          //La pila vacia simboliza que todos los caracteres cerraron, y no hubo error de que el primer caracter fuera uno de clausura
            if(pila.empty() && error==false && error2==false){ 
                System.out.println("Todos los simbolos estan balanceados");
            }
            else{
            	if(error==false && error2==false) {//El error no fue de que el primer caracter fuera uno de clausura
	            	if(pila.peek().equals('{'))
	                    System.out.println("Error de llave que abre falta llave que cierra");
	            	if(pila.peek().equals('['))
	            		System.out.println("Error de corchete que abre falta corchete que cierra");
	            	if(pila.peek().equals('('))
	            		System.out.println("Error de parentesis que abre falta parentesis que cierra");
            	}else {//error2 indica que el caracter de cerradura no concuerda con el de apertura
            		switch(pila.peek()) {
            			case '(':cadena=" se esperaba un parentesis de cerradura";
            					 break;
            			case '[':cadena=" se esperaba un corchete de cerradura";
   					 			 break;
            			default:cadena=" se esperaba un cerradura de cerradura";
            		}
            		if(fallo=='}')
                		System.out.println("Error de llave que cierra"+cadena);
                	if(fallo==']')
                        System.out.println("Error de corchete que cierra"+cadena);
                	if(fallo==')')
                        System.out.println("Error de parentesis que cierra"+cadena);
            	}
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
