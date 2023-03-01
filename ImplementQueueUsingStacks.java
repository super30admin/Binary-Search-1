/*
 * Time Complexity - O(1) for push
 * 					 O(N) for peek and pop. However in avg case it is O(1).
 * 					 O(1) for isEmpty().
 * Space Complexity - O(N) N is the number of element in the queue.
 * 
 * Approach - Use two stacks. 
 *            Push into firstStack or oldStack.
 *            For pop and peek - if secondStack is not empty, return the first element in stack.
 *            					 if not pop all elements from first stack into second stack.
 *            						then return the first element from second stack.
 * */
package com.sivakami.leetcode.solutions;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack<Integer> stackNew;
    Stack<Integer> stackOld;

    public ImplementQueueUsingStacks() {
        stackNew = new Stack<Integer>();
        stackOld = new Stack<Integer>();
    }
    
    public void push(int x) {
        stackOld.push(x);
    }
    
    private void transfer()
    {
        if(stackNew.isEmpty())
        {
            while(!stackOld.isEmpty())
            {
                stackNew.push(stackOld.pop());
            }
        }
    }

    public int pop() {
        transfer();
        return stackNew.pop();
    }
    
    public int peek() {
        transfer();
        return stackNew.peek();
    }
    
    public boolean empty() {
        return stackNew.isEmpty() && stackOld.isEmpty();
    }
    
    public static void main(String args[]) {
    	  ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks();
    	  obj.push(2);
    	  obj.push(3);
    	  System.out.println(obj.pop());
    	  System.out.println(obj.peek());
    	  System.out.println(obj.empty());
    	  obj.empty();
    }
}
