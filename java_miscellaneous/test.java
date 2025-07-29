class test {
   public static void main(String[] args) {
      int a =-5;
      int b = 8;
      for(int i = 0; i < 8 ;i++){
         if((++a > 2)||(b-->2)) {
            a++;
         }
      } 
      System.out.println("a="+ a +" b="+b);
   }
}