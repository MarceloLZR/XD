package edu.aed.cap16enteromuygrande;

import java.math.BigInteger;

public class TestEnteroMuyGrande {
     public static void main(String[] args) {
        String arregloCad[]={"100005000",
                               "9182734738218170000000072817",
                               "8000",
                               "3283748300000",
                               "7",
                               "100005000",
                               "2147483646",
                               "2147480000",
                               "1000000000000000000000000000000000000",//36
                            };
        EnteroMuyGrande e1,e2,e3; 
        BigInteger b1,b2,b3;
        int errorCnt=0;
        for(int i=0;i<arregloCad.length;i++){
            for(int j=0;j<arregloCad.length;j++){
                e1=new EnteroMuyGrande(arregloCad[i]);
                e2=new EnteroMuyGrande(arregloCad[j]);
                b1=new BigInteger(arregloCad[i]);
                b2=new BigInteger(arregloCad[j]);
                System.out.println("\n");
                System.out.println("Para numeros pares: i="+i+" j= "+j);
                System.out.print("e1: "+ e1.aString()+" " );
                System.out.print("e2: "+ e2.aString()+" " );
                //resta positiva
                e3=e1.restaPos(e2);
                b3=b1.subtract(b2);
                System.out.print("Resultado: "+ e3.aString()+" " );
                if(b3.compareTo(new BigInteger(e3.aString()))!=0){
                  errorCnt++;
                  System.out.print("Fallo la suma");                  
                }                
            }
        }
        System.out.print("\n\nTest Resultado: " + (errorCnt==0 ? "¡Exito!": errorCnt+ "errores"));
     }
     public void testSuma2(){
                String arregloCad[]={"100005000",
                               "9182734738218170000000072817",
                               "8000",
                               "3283748300000",
                               "7",
                               "100005000",
                               "2147483646",
                               "2147480000",
                               "1000000000000000000000000000000000000",//36
                            };
        EnteroMuyGrande e1,e2,e3; 
        BigInteger b1,b2,b3;
        int errorCnt=0;
        for(int i=0;i<arregloCad.length;i++){
            for(int j=0;j<arregloCad.length;j++){
                e1=new EnteroMuyGrande(arregloCad[i]);
                e2=new EnteroMuyGrande(arregloCad[j]);
                b1=new BigInteger(arregloCad[i]);
                b2=new BigInteger(arregloCad[j]);
                System.out.println("\n");
                System.out.println("Para numeros pares: i="+i+" j= "+j);
                System.out.print("e1: "+ e1.aString()+" " );
                System.out.print("e2: "+ e2.aString()+" " );
                //suma positiva
                e3=e1.suma(e2);
                b3=b1.add(b2);
                System.out.print("Resultado: "+ e3.aString()+" " );
                if(b3.compareTo(new BigInteger(e3.aString()))!=0){
                  errorCnt++;
                  System.out.print("Fallo la suma");                  
                }                
            }
        }
        System.out.print("\n\nTest Resultado: " + (errorCnt==0 ? "¡Exito!": errorCnt+ "errores")); 
     }
     public void testSuma1(){
         EnteroMuyGrande e1,e2,esum;
         BigInteger b1,b2,bsum;
         e1=new EnteroMuyGrande("123450006789");
         e2=new EnteroMuyGrande("987654321");
         esum=e1.suma(e2);
         
         b1=new BigInteger("123450006789");
         b2=new BigInteger("987654321");
         bsum=b1.add(b2);
         
         if(bsum.compareTo(new BigInteger(esum.aString()))==0)
             System.out.println("Coinciden: esum= "+esum.aString() + " bsum= "+bsum);
         else
             System.out.println("No coinciden");
     }
     public void testPaso1(){
         EnteroMuyGrande[] eg = new EnteroMuyGrande[7];
         eg[0]=new EnteroMuyGrande(123456789);
         eg[1]=new EnteroMuyGrande(-45);
         eg[2]=new EnteroMuyGrande("123456789012344");
         eg[3]=new EnteroMuyGrande("-0004000000");
         eg[4]=new EnteroMuyGrande(-3458);
         eg[5]=new EnteroMuyGrande(-0000);
         eg[6]=new EnteroMuyGrande();
         
         for(int i=0;i<eg.length;i++)
             System.out.println(i+": "+eg[i].aString());
     }
    
}
