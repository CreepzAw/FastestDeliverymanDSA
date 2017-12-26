/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC_Test;

/**
 *
 * @author lenovo
 */
public class TestStackClass<TestDataClass> {
    TestDataClass[] data;
    int length = -1;
    int size = 1;
    
    public TestStackClass(){
        data = (TestDataClass[]) new Object[size];
    }
    
    public void push(TestDataClass newEntry){
        length++;
        if (isArrayFull() == true){
            doubleArray();
            System.out.println("True");
        }
        data[length] = newEntry;
    }
    public TestDataClass pop(){
        TestDataClass pop = data[length];
        data[length] = null;
        length--;
        return pop;
    }
    public TestDataClass peek(){
        return data[length];
    }
    public boolean isEmpty(){
        if (length == -1){
            return true;
        }
        else
            return false;
    }
    public void clear(){
        length = -1;
    }
    
    private boolean isArrayFull(){
        if (length >= size){
            return true;
        }
        else 
            return false;
    }
    
    private void doubleArray(){
        size = size * 2;
        
        TestDataClass[] oldArray = data;
        data = (TestDataClass[]) new Object[size];
        for (int counter = 0; counter < oldArray.length; counter++){
            data[counter] = oldArray[0];
        }
    }
}
