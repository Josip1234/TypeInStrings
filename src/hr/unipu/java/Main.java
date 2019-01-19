package hr.unipu.java;

import java.util.Scanner;

/**
 * @author Josip Bošnjak
 *
 */
public class Main {

    public static final char[] samoglasnici={'a','e','i','o','u'};
    /**
     * Za kopiranje polja u novo polje radi uštede memorije
     */
    public static String[] newField;
    /**
     * Nova veličina za novo polje
     * */
    public static Integer newSize;
    /**
     * konstanta za kraj unosa
     */
    public static final String END_INPUT="kraj";
    /**
     * fiksna maksimalna veličina polja
     */
    public static final Integer MAX_FIELD_SIZE=255;
    /**
     * Polje za unos elemenata
     */
    public static String[] Input;

    /***
     *
     * @param rijec
     * @return broj samoglasnika
     */
    public static Integer brojiSamoglasnike(String rijec){
        int samoglasnik=0;

        char[] rastavi=rastavi(rijec);

        for (char slovo:rastavi) {
            for (char samoglas:samoglasnici) {
                if(samoglas==slovo){

                    samoglasnik=samoglasnik+1;

                    break;
                }

            }
        }



        return samoglasnik;
    }


    /**
     *
     * @param rijec
     * @return rastavljeno char polje
     */
    public static char[] rastavi(String rijec){
        char[] rastavljeno=new char[rijec.length()];

        for (int i=0;i<rijec.length();i++){
            rastavljeno[i]=rijec.charAt(i);

        }
        return rastavljeno;
    }

    //broj suglasnika je ostatak od samoglasnika

    /**
     *
     * @param velicinaRijeci
     * @param brojSamoglasnika
     * @return broj suglasnika
     */
    public static Integer brojSuglasnika(Integer velicinaRijeci,Integer brojSamoglasnika){
        Integer brojSuglasnika=(velicinaRijeci-brojSamoglasnika);
        return brojSuglasnika;

    }


    /**
     * Unos stringova
     * @return unešeni element
     */
    public static String  InputStrings(){
        //pozovi klasu za input
        Scanner scanner=new Scanner(System.in);

        //vrati input string
        return scanner.nextLine();

    }

    /**
     *
     * @return poruka za unos stringova
     */
    public static void WriteMessage(){
        System.out.println("Input string from keyboard, if the string equals kraj, it is the end of the input.");
    }

    /**
     *
     * @param string koji je input
     * stavi string da bude lowercase
     * @return true if input is equals to constant else return false
     */
    public static boolean isEnd(String string){
      string=string.toLowerCase();
      if(string.equalsIgnoreCase(END_INPUT)){
          return true;
      }else{
          return false;
      }
    };


    /**
     *ispiši polje
     * @param polje
     */
    public static void ispisiPolje(String[] polje){
        int brojSuglasnika=0;
        int brojSamoglasnika=0;


      ;

       for (int i=0;i<polje.length;i++){
           String rijec1=polje[i];
           brojSamoglasnika=brojiSamoglasnike(rijec1);
           brojSuglasnika=brojSuglasnika(rijec1.length(),brojSamoglasnika);

           if(brojSamoglasnika==brojSuglasnika){

               System.out.println(rijec1);
           }

       }

    }
    public static void main(String[] args) {
        //varijabla za primanje inputa
        String input="";
        /**
         * Inicijaliziraj novu veličinu polja
         */
        newSize=0;
        /**
         * Inicijaliziraj polje sa konstanttom
         */
        Input=new String[MAX_FIELD_SIZE];

        //dok je veličina manja od glavnog polja
        //ispisuj poruku
        //primi input za funkcije inputstrings
        //stavi u polje
        //povećaj veličinu novog polje
        //ako je odgovor kraj
        //izađi iz petlje
	  for (int i=0;i<MAX_FIELD_SIZE;i++){
	     WriteMessage();
	     input=InputStrings();



	     Input[i]=input;
	     newSize+=1;
	     if(isEnd(Input[i])==true){
	         break;
         }


      }
	  //inicijaliziraj novo polje
	  newField=new String[newSize];

	    //dok je indeks manji od veličine glavnog polje
        //ako je vrijednost null izađi iz petlje
        //inače kopiraj vreijednost glavnog polja u novo polje
        for (int k=0;k<Input.length;k++) {
            if(Input[k]==null) break;
            else{
                newField[k]=Input[k];

            }


        }
        //ispiši polje
        ispisiPolje(newField);


    }
}
