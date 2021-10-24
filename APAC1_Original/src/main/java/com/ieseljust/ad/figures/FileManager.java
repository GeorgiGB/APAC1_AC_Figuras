package com.ieseljust.ad.figures;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class FileManager {

    public FileManager() {

    }


    private boolean validaInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public Boolean Exists(String file) {
        File f = new File(file);

        return f.exists();

    }

    public Escena importFromText(String file) {
        Escena escena = null;
        FileReader fr = null;
        try {
            /**
             * *********************************************************
             * TO-DO: Mètode a implementar: * Llegirà el fitxer indicat, en format
             * text, i importarà * la llista de figures. *
             * **********************************************************
             */
            /*
            dimensions 500 500
            rectangle 10 10 480 480 #ccccee
            cercle 250 250 100 #aaaaaa
            */
            escena = new Escena();
            File f = new File(file);
            fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            String linea = "";
            while (bfr.ready()) {

                linea = bfr.readLine();

                String elements[] = linea.split(" ");

                Figura figura1;

                switch (elements[0]) {

                    case "dimensions":

                        escena.dimensions(Integer.parseInt(elements[1]),
                                Integer.parseInt(elements[2]));

                        break;

                    case "rectangle":

                        figura1 = new Rectangle(Integer.parseInt(elements[1]),
                                Integer.parseInt(elements[2]),
                                Integer.parseInt(elements[3]),
                                Integer.parseInt(elements[4]),
                                elements[5]);

                        escena.add(figura1);

                        break;

                    case "cercle":

                        figura1 = new Cercle(Integer.parseInt(elements[1]),
                                Integer.parseInt(elements[2]),
                                Integer.parseInt(elements[3]),
                                elements[4]);

                        escena.add(figura1);

                        break;

                    case "linia":

                        figura1 = new Linia(Integer.parseInt(elements[1]),
                                Integer.parseInt(elements[2]),
                                Integer.parseInt(elements[3]),
                                Integer.parseInt(elements[4]),
                                elements[5]);

                        escena.add(figura1);

                        break;

                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return escena;
    }


    public Escena importFromObj(String file) {

        /**
         * **********************************************************************
         * TO-DO: Mètode a implementar: * Llegirà el fitxer indicat, en format
         * d'objectes seriats, i importa * la llista de figures. *
         * **********************************************************************
         */
        // Comentar o elimina aquestes línies quan implementeu el mètode
        Escena escena = null;

        FileInputStream fis = null;

        try{
            fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (fis.available()> 0){
                Figura f = (Figura) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                fis.close(); //cerrar el FileInputStream
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return escena;

    }

    public Boolean exportText(Escena escena, String file) {

        /**
         * ************************************************
         * TO-DO: Mètode a implementar: * exporta l'escena donada a un fitxer de
         * text, * en format per poder ser importat posteriorment.*
         * ************************************************
         */
        // Comentar o elimina aquestes línies quan implementeu el mètode
        boolean out = false;
        FileWriter fw = null;

        try{
            fw = new FileWriter(file);
            BufferedWriter bfw = new BufferedWriter(fw);
            bfw.write(escena.getDimensionsASText + "\n");//recoge lo escrito del file

            for (Figura f : escena.LlistaFigures){
                bfw.write(f.getAsText() + "\n");
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }finally {
            try{
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return out;

    }

    public Boolean exportObj(Escena escena, String file) {

        /**
         * **********************************************************
         * TO-DO: Mètode a implementar: * exporta l'escena donada a un fitxer
         * binari d'objectes, * per poder ser importat posteriorment. *
         * **********************************************************
         */
        // Comentar o elimina aquestes línies quan implementeu el mètode
        boolean out = false;

        return out;

    }

    public Boolean exportSVG(Escena escena, String file) {
        /**
         * **********************************************************
         * TO-DO: Mètode a implementar: * exporta l'escena donada a un fitxer
         * SVG (format XML). * El fitxer s'haurà de poder obrir amb Inkscape. *
         * **********************************************************
         */
        /*
            <?xmlversion="1.0"encoding="UTF-8"standalone="no"?> 2 <svgheight="500"width="500">
            <rect fill="#ccccee" height="480" width="480" x="10" y="10"/>
            <circle cx="250" cy="250" fill="#aaaaaa" r="100"/>
            <line stroke="#aaaaaa" stroke-width="3" x1="50" x2="450" y1="250" y2="250"/>
            <line stroke="#aaaaaa" stroke-width="3" x1="50" x2="50" y1="50" y2="
            450"/>
            <line stroke="#aaaaaa" stroke-width="3" x1="450" x2="450" y1="40" y2= "450"/>
            </svg>
         */

        // Comentar o elimina aquestes línies quan implementeu el mètode
        boolean out = false;

        return out;

    }

    public Boolean exportJSON(Escena escena, String filename) {

        /**
         * **********************************************
         * TO-DO: Mètode a implementar: * exporta l'escena donada a un fitxer
         * JSON. * **********************************************
         */
        // Comentar o elimina aquestes línies quan implementeu el mètode
        boolean out = false;

        JSONObject escenajson = new JSONObject();

        escenajson.put("width", escena.getX());
        escenajson.put("height", escena.getY());
        JSONArray lesfigures = new JSONArray();


        return out;

    }

}
