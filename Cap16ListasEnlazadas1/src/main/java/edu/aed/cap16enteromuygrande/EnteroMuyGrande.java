package edu.aed.cap16enteromuygrande;

public class EnteroMuyGrande {
    private static final char MENOS='-';
    private Nodo cabeza;
    private byte signo;

    public EnteroMuyGrande() {
        this("0");
    }
    
    public EnteroMuyGrande(long numero) {
        this("" + numero);      
    }

    public EnteroMuyGrande(Nodo cabeza) {
        this.cabeza = cabeza;
        this.signo=+1;
    }
    
    public EnteroMuyGrande(String numero) {
        //sin comprobacion de error, suponiendo 
        //que el parametro tiene un formato valido
        numero.trim();
        signo=+1;
        if(numero.charAt(0)==MENOS){
            signo=-1;
            numero=numero.substring(1);//remueve el primer caracter            
        }
        numero=extraeCerosPrecedentes(numero);
        if(numero.equals("0")){
            signo=+1;//el patron de entrada \-0+ o \+0+ se convierte en //+0 internamente            
        }
        cabeza=new Nodo();//usa un nodo cabeza ficticio
        Nodo cola=cabeza;
        String digitos;
        while(!numero.equals("")){
            int loc=Math.max(numero.length()- Nodo.getDIGITOS_MAX(),0);
            digitos=numero.substring(loc);//corta los ultimos 3 digitos, o corta todo si es <3 digitos
            numero=numero.substring(0,loc);//si loc==0, el numero se convierte en ""
            Nodo bloque=new Nodo(digitos);
            cola.setSiguiente(bloque);
            cola=bloque;
        }
        cabeza=cabeza.getSiguiente();//remueve el nodo ficticio    
    }
    public String aString(){
        StringBuffer strBuf=new StringBuffer("");
        String formato="%0"+Nodo.getDIGITOS_MAX()+"d";
        Nodo p=cabeza;
        while(p.getSiguiente()!=null){
            strBuf.insert(0, String.format(formato, p.getValor()));//rellena los 0 precedentes si los digitos estan en medio del numero
            p=p.getSiguiente();
        }
        strBuf.insert(0,p.getValor());//procesa el nodo mas significativo, no rellena los 0 precedentes para este nodo
        if(signo<0)
            strBuf.insert(0,"-");
        return strBuf.toString();
    }
    private static String extraeCerosPrecedentes(String str) {
        StringBuffer strBuf=new StringBuffer(str);
        int length=strBuf.length();
        for(int i=0;i<length;i++){
            if(strBuf.charAt(0)=='0')
                strBuf.deleteCharAt(0);
        }
        if(strBuf.length()==0)
            strBuf.append('0');
        return strBuf.toString();
    }
    public EnteroMuyGrande suma(EnteroMuyGrande num){
        return this.sumaPos(num);//suma solo dos valores positivos
    }
    public EnteroMuyGrande sumaPos(EnteroMuyGrande num){
        Nodo p,q,r,t;
        p=this.cabeza;
        q=num.cabeza;
        t=new Nodo();//nodo cabeza ficticio
        r=t;
        short acarreo=0;
        while(p!=null && q!=null){
            short sum=(short)(acarreo +p.getValor()+q.getValor());
            r.setSiguiente(new Nodo());
            r=r.getSiguiente();
            r.setValor((short)(sum%Nodo.getVALOR_MAX()));
            acarreo=(short)(sum/Nodo.getVALOR_MAX());
            p=p.getSiguiente();
            q=q.getSiguiente();
        }
        p=(p==null)?q:p;//restablece p para apuntar a los bloque restantes
        while(p!=null)
        {
            r.setSiguiente(new Nodo());
            r=r.getSiguiente();
            r.setValor((short)((p.getValor()+acarreo)%Nodo.getVALOR_MAX()));
            acarreo=(short)((p.getValor()+acarreo)/Nodo.getVALOR_MAX());
            p=p.getSiguiente();
        }
        if(acarreo>0)
            r.setSiguiente(new Nodo((short)acarreo));
        return new EnteroMuyGrande(t.getSiguiente());//quita el nodo cabeza ficticio
    }
    public int comparaA(EnteroMuyGrande num){
        EnteroMuyGrande L=this;
        EnteroMuyGrande R=num;
        if(L.esPositivo()&& R.esNegativo())
            return +1;
        if(L.esNegativo()&& R.esPositivo())
            return -1;
        //L y R tienen el mismo signo, asi que se les compara
        //aqui se utilizara un artificio, al convertir L y R a string y usar string comparaA
        String Lstr=L.aString();
        String Rstr=R.aString();
        int result;
        int lengthL=Lstr.length();
        int lengthR=Rstr.length();
        //primero verifica la magnitud
        if(lengthL==lengthR)
            result=Lstr.compareTo(Rstr);
        else
            result=(lengthL<lengthR) ? -1 : +1;
        //ahora comprueba el signo de dos muy grandes
        return L.signo*result;//Nota: Puesto que el string comparaA
        //podria regresar valores distintos a +1, o -1,
        //asi que hace este metodo como consecuencia
    }
    private boolean esPositivo(){
        return signo>0;
    }
    private boolean esNegativo(){
        return signo<0;
    }
    public EnteroMuyGrande extraeCerosPrecedentes(){
        String numStr=this.toString();
        String result=extraeCerosPrecedentes(numStr);
        if(result.equals("0"))
            return new EnteroMuyGrande(0);
        else if (result.length()<numStr.length())
            return new EnteroMuyGrande(result);
        else
            return this;
    }
    public EnteroMuyGrande negativo(){
        signo=(byte)-signo;//el signo - es int asi que se necesita conversion
        return this;
    }
    public EnteroMuyGrande restaPos(EnteroMuyGrande num){
        Nodo p,q,r,t;
        boolean esNegativo=false;
        //siempre resta el mas pequeño del mayor
        //si num es mayor, entonces el resultado es negativo
        if(this.comparaA(num)>=0){
            p=this.cabeza;
            q=num.cabeza;
        }else{
            p=num.cabeza;
            q=this.cabeza;
            esNegativo=true;
        }
        t=new Nodo();//nodo cabeza ficticio
        r=t;
        short prestamo=0, minuendo;//para L es un minuendo
        while(p!=null && q!=null){
            r.setSiguiente(new Nodo());
            r=r.getSiguiente();
            minuendo=(short)(p.getValor()-prestamo);
            if(minuendo<q.getValor()){
                r.setValor((short)(Nodo.getVALOR_MAX()+minuendo-q.getValor()));
                prestamo=1;
            }else{//no prestamo
                r.setValor((short)(minuendo - q.getValor()));
                prestamo=0;
            }
            p=p.getSiguiente();
            q=q.getSiguiente();
        }
        p=(p==null) ? q : p;//restablece p para apuntar a los bloques restantes
        while(p!=null){
            r.setSiguiente(new Nodo());
            r=r.getSiguiente();
            r.setValor((short)(p.getValor() - prestamo));
            if(r.getValor()<0){
                r.setValor((short)(r.getValor()+ Nodo.getVALOR_MAX()));
                prestamo=1;
            }else
                prestamo=0;
            p=p.getSiguiente();
        }
        EnteroMuyGrande result=new EnteroMuyGrande(t.getSiguiente());//remueve el nodo cabeza ficticio
        result=result.extraeCerosPrecedentes();
        if(esNegativo)
            result.negativo();
        return result;
    }
    
}
