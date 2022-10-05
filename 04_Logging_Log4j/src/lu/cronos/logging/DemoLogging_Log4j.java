package lu.cronos.logging;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
  
public class DemoLogging_Log4j{  
  
   /* Get the class name to be printed on */  
   static Logger log = Logger.getLogger(DemoLogging_Log4j.class.getName());  
     
   public static void main(String[] args)throws IOException,SQLException{  
      log.debug("Hello this is a debug message");  
      log.info("Hello this is an info message");  
   }  
}  	