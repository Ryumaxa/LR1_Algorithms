package org.example.iec61850.datatypes.logicalNodes.protocol;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.io.FileUtils;
import org.example.iec61850.datatypes.logicalNodes.common.LN;
import org.example.iec61850.datatypes.measurements.SAV;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс для парсинга CSV файла
 */

@Getter @Setter
public class LSVS extends LN {

    private String path;
    private String fileName;

    private File csvFile;
    private File cfgFile;
    private final List<SAV> out = new ArrayList<>();
    private List<String> csvFileList = new ArrayList<>();
    private List<String> cfgFileList = new ArrayList<>();
//    private List<Double> kAList = new ArrayList<>();
//    private List<Double> kBList = new ArrayList<>();
    private Iterator<String> csvFileIter;

    private int analogNumber = 0;
    private int discretNumber = 0;



    public LSVS() {
        for (int i = 0; i < 20; i++) {
            out.add(new SAV());
        }
    }

    @Override
    public void process() {
        if (this.csvFileIter.hasNext()){
            String[] str = this.csvFileIter.next().split(",");

            for(int i = 0; i < analogNumber; i++) {
                double value = 1000 * Double.parseDouble(str[i + 1]);
                out.get(i).getInstMag().getF().setValue(value);
            }

//            for (int i = 2 , j = 0; i < this.analogNumber + 2; i++, j++){
//                double value = 1000 * Double.parseDouble(str[i]) * this.kAList.get(j) + this.kBList.get(j);
//
//                this.out.get(j).getInstMag().getF().setValue(value);
//            }
        }
    }

    public void readCsv(String path, String name) throws IOException {
        csvFile = new File(path + "\\" + name + ".csv");
        cfgFile = new File(path + "\\" + name + ".cfg");
        csvFileList = FileUtils.readLines(csvFile, StandardCharsets.UTF_8);
        cfgFileList = FileUtils.readLines(cfgFile, StandardCharsets.UTF_8);
        csvFileIter = csvFileList.iterator();
        if (csvFileIter.hasNext()){
            csvFileIter.next();
        }
        analogNumber = Integer.parseInt(cfgFileList.get(1).split(",")[1].replace("A", ""));
        discretNumber = Integer.parseInt(cfgFileList.get(1).split(",")[2].replace("D", ""));
    }

    public boolean hasData() {
        return this.csvFileIter.hasNext();
    }
//
//    public void setFileName(String fileName) throws Exception {
//        this.fileName = fileName;
//
//        String cfgPath = path + fileName + ".cfg";
//        String datPath = path + fileName + ".dat";
//
//        File cfgFile = new File(cfgPath);
//        File datFile = new File(datPath);
//
//        if (!cfgFile.exists()) throw new Exception("Путь указан неверно");
//        if (!datFile.exists()) throw new Exception("Путь указан неверно");
//
//        this.cfgFileList = Files.readAllLines(cfgFile.toPath());
//        this.datFileList = Files.readAllLines(datFile.toPath());
//
//        String strNumber = this.cfgFileList.get(0)
//                .replace("A", "")
//                .replace("D", "");
//        this.analogNumber = Integer.parseInt(strNumber.split(",")[1]);
//        this.discretNumber = Integer.parseInt(strNumber.split(",")[2]);
//
//        for (int i = 2; i < this.analogNumber + 2; i++ ) {
//            double kA = Double.parseDouble(this.cfgFileList.get(i).split(";")[5]);
//            double kB = Double.parseDouble(this.cfgFileList.get(i).split(";")[6]);
//
//            this.kAList.add(kA);
//            this.kBList.add(kB);
//
//            System.out.println(this.cfgFileList.get(i));
//        }

        //Iterator datIterator = new Iterator








}
