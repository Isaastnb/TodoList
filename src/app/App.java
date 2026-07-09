package app;
import model.Task;
import model.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main (String[] args) throws IOException {
        List list = new List();
        BufferedReader br = new BufferedReader(new FileReader("src/app/task.txt"));
        
        for (int i = 0; i < 3; i++) {
            Task tsk = new Task();
            String[] readLine = br.readLine().split(";");
            tsk.setName(readLine[0]);
            tsk.setPriority(readLine[1]);
            tsk.setStatus(Boolean.parseBoolean(readLine[2]));
            list.adicionar(tsk);
        }
        br.close();

        list.showTasks();
        
    }
}
