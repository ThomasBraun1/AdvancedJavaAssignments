package model;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class Sequences extends ArrayList<Sequences.HeaderSequence> {

    ArrayList<HeaderSequence> headseq=new ArrayList<HeaderSequence>();
    public String getText(boolean showHeaders){
        if (showHeaders){
            String addin = "";
            for(int i=1;  i<headseq.size(); i++){
                addin+=headseq.get(i).header+"\n";
                addin+=headseq.get(i).sequence+"\n";
            }
            return addin;
        } else {
            String addin = "";
            for (HeaderSequence item : headseq){
                addin+= item.sequence + "\n";
            }
            return addin;
        }
    }

    public void read(String fileName) throws IOException{

        try {
            BufferedReader r = new BufferedReader(new FileReader(fileName));
            String header="";
            String seq="";
            String line;
            headseq.clear();
            while((line=r.readLine()) != null){
                line=line.trim();
                if(line.charAt(0)=='>'){
                    header=line;
                }
                else{seq=line;}
                headseq.add(new HeaderSequence(header, seq));
            }
            r.close();
            System.out.println(headseq);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void read(BufferedReader r) throws IOException{
    }
    public static record HeaderSequence(String header, String sequence) {
    }
}
