import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Савин Евгений Александрович
public class ChatBot {
    public static void main(String[] args){
        try(
        FileInputStream fileInputStream = new FileInputStream("ForFile/FileDefault");
        BufferedReader br= new BufferedReader(new InputStreamReader(fileInputStream));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){

        String value;
        List<String> m = new ArrayList<>();
        while ((value = br.readLine()) != null){
            m.add(value);
        }

        int d1 = 0;
        int d2 = m.size() - 1;
        boolean silent = false;
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
        while (true) {
            String s = bufferedReader.readLine();
            if(s.equals("silent")){
                silent = true;
            }
            else if(s.equals("change")){
                System.out.print("Введите путь нового файла: ");
                String s2 = bufferedReader.readLine();
                m = anotherFile(s2);
                d2 = m.size() - 1;
            }
            else if(s.equals("getUP") && !silent){}
            else if(s.equals("getUP") && silent){silent = false;}
            else if(s.equals("date")){
                Date date = new Date();
                System.out.println(dateFormat1.format(date));
            }
            else if(s.equals("time")){
                Date date = new Date();
                System.out.println(dateFormat2.format(date));
            }
            else if(s.equals("quit")){
                System.out.println("Покасики");
                break;}
            else if(!s.equals("silent") && silent){}
            else{
            System.out.println(m.get(d1 + (int) (Math.random() * d2)));}
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static List<String> anotherFile(String s) throws IOException{
        try (FileInputStream fileInputStream = new FileInputStream(s);
                BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream))) {
            List<String> result = new ArrayList<>();
            String value;
            while ((value = br.readLine()) != null) {
                result.add(value);
            }
            return result;
        }
    }
}
