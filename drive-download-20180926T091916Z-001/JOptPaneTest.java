import javax.swing.*;

public class JOptPaneTest
{

    public static void main(String [] args)
    {
     
        //Declare variables
        
        String strName;
        String strMonths;
        String strMessage;
        Integer months;
        
        //Get the users info
        strName = JOptionPane.showInputDialog ("Enter your name: ");
        strMonths = JOptionPane.showInputDialog ("How many months have you been programming? ");
        
        months = Integer.parseInt(strMonths);
        
        Integer days = months * 30;
        strMessage = "Hello " +  strName + ". You have been programming for " + days.toString() +   " days";
        
        JOptionPane.showMessageDialog(null, strMessage );
        
        System.exit(0) ;
    
    }

}