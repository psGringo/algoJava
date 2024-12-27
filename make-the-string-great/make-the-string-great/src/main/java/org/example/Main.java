package org.example;


import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        makeGood("leEeetcode");
    }


    /**
     * more optimal solution
     *
     * @param s
     * @return
     */
    public String makeGood2(String s) {
        Stack <Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if(!stack.isEmpty()){
                char c = stack.peek();
                if(Math.abs(c-s.charAt(i))==32){
                    stack.pop();
                }
                else{
                    stack.push(s.charAt(i));
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        StringBuilder k = new StringBuilder();
        while(!stack.isEmpty()){
            k.append(stack.pop());
        }
        return k.reverse().toString();
    }


    public static String makeGood(String s) {
        while (true) {
            int[] wrongIndices = getWrongIndices(s);
            if (wrongIndices == null) {
                break;
            }
            s = cutTheString(s, wrongIndices);
        }
        return s;
    }

    private static String cutTheString(String s, int[] indices){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i != indices[0] && i != indices[1]) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private static int[] getWrongIndices(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (Math.abs((int) s.charAt(i) - (int) s.charAt(i - 1)) == 32) {
                return new int[]{i - 1, i};
            }
        }
        return null;
    }



}