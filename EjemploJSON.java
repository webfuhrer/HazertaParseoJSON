/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.net.URL;

/**
 *
 * @author Admin
 */
public class EjemploJSON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

		FileReader fr;
		try {
			fr = new FileReader("D:\\datos.json");
			JsonParser p=new JsonParser();
                        
                        JsonElement e=p.parse(fr);
                        JsonObject objeto=e.getAsJsonObject();
                        JsonObject objeto_responsable=objeto.getAsJsonObject("responsable");
                        JsonArray objeto_empleados=objeto.getAsJsonArray("empleados");
                        JsonElement elemento_nombre=objeto_responsable.get("Nombre");
                        String nombre=elemento_nombre.getAsString();
                        int edad=objeto_responsable.get("Edad").getAsInt();
                        JsonArray aficiones=objeto_responsable.getAsJsonArray("Aficiones");
                        for(int i=0; i<aficiones.size(); i++)
                        {
                            String aficion=aficiones.get(i).getAsString();
                            System.out.println(aficion);
                        }
                        for (int i=0; i<objeto_empleados.size(); i++)
                        {
                           JsonObject objeto_empleado= objeto_empleados.get(i).getAsJsonObject();
                           String nombre_empleado=objeto_empleado.get("Nombre").getAsString();
                           String residencia=objeto_empleado.get("Residencia").getAsString();
                           int edad_empleado=objeto_empleado.get("Edad").getAsInt();
                            System.out.println("nombre: "+nombre_empleado);
                            System.out.println("residencia: "+residencia);
                            System.out.println("edad: "+edad_empleado);
                           JsonArray aficiones_empleado=objeto_empleado.get("Aficiones").getAsJsonArray();
                           for (int j=0; j<aficiones_empleado.size();j++)
                           {
                               String aficion_empleado=aficiones_empleado.get(j).getAsString();
                               System.out.println(aficion_empleado);
                           }
                        }
                        
                        
                        
                        
                }catch(Exception e)
                {
                    System.out.println("ERROR: "+e.getMessage()+" "+e.getLocalizedMessage()); 
                }
		
    }
}
