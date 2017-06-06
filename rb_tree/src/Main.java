/**
 * Created by zaGamer on 2017-06-06.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        rb_tree rb = new rb_tree();
        int n;

        while (true) {
            String line = br.readLine();
            line = onlyNum(line);
            n = Integer.parseInt(line);
            if (n > 0) rb.insert(n);
            else if (n < 0){
                if(rb.search(rb.root,n)==null) System.out.println("Cannot delete: does not exist");
                n = Math.abs(n);
                rb.delete(n);
            } else if (n == 0) break;
        }

        rb.numbering(rb.root);

        System.out.println("total = " + rb.total);
        System.out.println("nb = " + rb.nb);
        System.out.println("bh = " + rb.b_height());
        rb.inorder(rb.root);
        System.out.println();
    }

    public static String onlyNum(String str) {
        if ( str == null ) return "";
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if( Character.isDigit( str.charAt(i) ) || str.charAt(i) == '-' ) { sb.append( str.charAt(i) ); }
        } return sb.toString();
    }
}
