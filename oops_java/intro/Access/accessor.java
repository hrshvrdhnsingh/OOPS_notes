package oops_java.intro.Access;
/*Directly allowing the access to another entity isn't a good idea from security
  point of view.
 * 
 */
public class accessor {
    public static void main(String[] args) {
        accmod ob = new accmod(10,"Harsh");
        ob.display();
    }
}
