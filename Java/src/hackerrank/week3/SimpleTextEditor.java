package hackerrank.week3;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    public static void main(String[] args) {
        SimpleTextEditor s = new SimpleTextEditor();
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < q ; i++) {
            String query = scanner.nextLine();
            int queryType = Integer.parseInt(query.split(" ")[0]);
            if (queryType == 1) {
                String w = query.split(" ")[1];
                s.append(w);
            } else if (queryType == 2) {
                int k = Integer.parseInt(query.split(" ")[1]);
                s.delete(k);
            } else if (queryType == 3) {
                int k = Integer.parseInt(query.split(" ")[1]);
                s.print(k);
            } else  {
                s.undo();
            }
        }
        scanner.close();
    }

    private String s;
    private Stack<String> backup;

    public SimpleTextEditor(){
        this.s = "";
        backup = new Stack<>();

    }


    public void append(String w) {
        this.backup.push(s);
        this.s += w;
    }

    public void delete(int k) {
        this.backup.push(s);
        this.s = this.s.substring(0, this.s.length()-k);
    }

    public void print(int k) {
        System.out.println(this.s.charAt(k-1));
    }

    public void undo() {
        this.s = backup.pop();
    }
}
